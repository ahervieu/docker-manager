package org.kevoree.docker.containerDriver.javaFXUI.controller;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;
import org.kevoree.docker.containerDriver.core.StringParsingUtils;
import org.kevoree.docker.containerDriver.core.cgroupDriver.BlkioDriver;
import org.kevoree.docker.containerDriver.core.cgroupDriver.CPUDriver;
import org.kevoree.docker.containerDriver.core.cgroupDriver.MemoryDriver;
import org.kevoree.docker.containerDriver.core.cgroupDriver.NetworkDriver;
import org.kevoree.docker.containerDriver.core.client.DockerClientImpl;
import org.kevoree.docker.containerDriver.core.client.DockerException;
import org.kevoree.docker.containerDriver.core.model.Container;
import org.kevoree.docker.containerDriver.core.model.ContainerConfig;
import org.kevoree.docker.containerDriver.core.model.CustomContainerDetail;
import us.monoid.json.JSONException;

import java.io.File;
import java.net.URL;
import java.util.*;


/**
 * Created by aymeric on 25/11/14.
 */
public class ContainerDriverController implements Initializable {

    @FXML
    public TextField cpu_number;
    @FXML
    public TextField freq;

    @FXML
    public TextField maxMem;
    @FXML
    public TextField swap;

    @FXML
    public TextField incoming_traffic;
    @FXML
    public TextField outgoing_traffic;

    @FXML
    public TextField corrupt_rate;
    @FXML
    public TextField loss_rate;
    @FXML
    public TextField delay;

    @FXML
    public TextField io_read;
    @FXML
    public TextField io_write;

    @FXML
    private ListView<CustomContainerDetail> dockerContainers;
    @FXML
    private TextField server;

    private ObservableList<CustomContainerDetail> CCD;

    private DockerClientImpl dci;

    private StringParsingUtils.ContainerDriverFactory factory;

    @FXML
    private void handleButtonApply() {
        if (true) {
            CustomContainerDetail currContainer = getCurrentContainer();
            if (currContainer != null) {

                if(StringParsingUtils.isInteger( io_write.getText())) {
                    BlkioDriver.setWriteValue(currContainer.getId(), io_write.getText());
                }
                if(StringParsingUtils.isInteger( io_read.getText())) {
                    BlkioDriver.setReadValue(currContainer.getId(), io_read.getText());
                }
                CPUDriver.setCPUValue(currContainer.getId(), cpu_number.getText());

                if(StringParsingUtils.isInteger( freq.getText())) {
                    CPUDriver.setFreqValue(currContainer.getId(), freq.getText());
                }


                    MemoryDriver.setMaxMemValue(currContainer.getId(), maxMem.getText());


                    MemoryDriver.setSwapValue(currContainer.getId(), swap.getText());



                //Setting value in the model

                if (currContainer.getBridge().isEmpty()) {
                    System.err.println("Unable to retrieve bridge of docker node");
                } else {

                    if(StringParsingUtils.isInteger( corrupt_rate.getText())) {
                        NetworkDriver.setIncomingCorruptionRate(currContainer.getBridge(), Integer.valueOf(corrupt_rate.getText()));
                        currContainer.setCorruptionRate(Integer.valueOf(corrupt_rate.getText()));
                    }
                    if(StringParsingUtils.isInteger( delay.getText())) {
                        NetworkDriver.setIncomingDelay(currContainer.getBridge(), Integer.valueOf(delay.getText()));
                        currContainer.setDelayRate( Integer.valueOf(delay.getText()));
                    }

                    if(StringParsingUtils.isInteger( loss_rate.getText())) {
                        NetworkDriver.setIncomingLossRate(currContainer.getBridge(), Integer.valueOf(loss_rate.getText()));
                        currContainer.setLossRate(Integer.valueOf(loss_rate.getText()));
                    }

                    if(StringParsingUtils.isInteger( incoming_traffic.getText())) {
                        NetworkDriver.setIncomingTraffic(currContainer.getBridge(), incoming_traffic.getText());
                        currContainer.setIncomingTraffic(Integer.valueOf(incoming_traffic.getText()));
                    }

                    if(StringParsingUtils.isInteger( outgoing_traffic.getText())) {
                        NetworkDriver.setOutgoingTraffic(currContainer.getBridge(), outgoing_traffic.getText());
                        currContainer.setOutgoingTraffic(Integer.valueOf(outgoing_traffic.getText()));
                    }


                }
            }
        }
    }

    private CustomContainerDetail getCurrentContainer() {
        CustomContainerDetail currContainer = dockerContainers.getSelectionModel().getSelectedItem();
        return currContainer;
    }


    @FXML
    private void refreshServer() {
        dci = new DockerClientImpl(server.getText());
        updateCustomContainerDetailList();
    }

    @FXML
    private void refreshServerKey() {
        dci = new DockerClientImpl(server.getText());
        updateCustomContainerDetailList();
    }

    /*

    Check if there are new containers
    Check if some containers disapeard
    update the view
    handle selection
     */

    private void updateCustomContainerDetailList() {

        CustomContainerDetail curr = dockerContainers.getSelectionModel().getSelectedItem();
        //Updating ContainerList
        // removing Container that are no more available
        try {
            List<CustomContainerDetail> ccd_to_rm = new ArrayList<CustomContainerDetail>();
            List<CustomContainerDetail> ccd_to_add = new ArrayList<CustomContainerDetail>();
            List<Container> lstCon = dci.getContainers();
            // Check that all current container in the app are still active
            for (CustomContainerDetail customContainerDetail : CCD) {
                boolean stop = false;
                for (int i = 0; i < lstCon.size() && !stop; i++) {
                    Container currContain = lstCon.get(i);
                    if (currContain.getId().equals(customContainerDetail.getContainer().getId())) {
                        stop = true;
                    }
                }
                if (!stop) {

                    ccd_to_rm.add(customContainerDetail);
                }
            }

            // Check if there are new container
            // adding new container
            for (Container container : lstCon) {
                boolean found = false;
                for (int i = 0; i < CCD.size() && !found; i++) {
                    CustomContainerDetail currContainDetail = CCD.get(i);
                    if (container.getId().equals(currContainDetail.getContainer().getId())) {
                        found = true;
                    }
                }
                if (!found) {
                    ccd_to_add.add(factory.createCustomContainerDetail(dci.getContainer(container.getId())));

                }
            }
            CCD.removeAll(ccd_to_rm);
            CCD.addAll(ccd_to_add);

            //Check if the current selected still here refresh
            if (!ccd_to_rm.contains(curr)) {
                refreshContainerView();
            }


        } catch (DockerException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void refreshContainerView() {
        CustomContainerDetail currContainer = getCurrentContainer();

        if (currContainer != null) {
            ContainerConfig currConf = currContainer.getContainer().getConfig();

            io_read.setText(BlkioDriver.getReadValue(currContainer.getId()));
            io_write.setText(BlkioDriver.getWriteValue(currContainer.getId()));

            cpu_number.setText(CPUDriver.getCpuValue(currContainer.getId()));
            freq.setText(CPUDriver.getFreqValue(currContainer.getId()));

            maxMem.setText(MemoryDriver.getMaxMemValue(currContainer.getId()));
            swap.setText(MemoryDriver.getSwapValue(currContainer.getId()));
            System.out.println(String.valueOf(currContainer.getIncomingTraffic()));
            corrupt_rate.setText(String.valueOf(currContainer.getCorruptionRate()));
            delay.setText(String.valueOf(currContainer.getDelayRate()));
            loss_rate.setText(String.valueOf(currContainer.getLossRate()));
            incoming_traffic.setText(String.valueOf(currContainer.getIncomingTraffic()));
            outgoing_traffic.setText(String.valueOf(currContainer.getOutgoingTraffic()));

        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NetworkDriver.addIpTableRule() ;
        factory = new StringParsingUtils.ContainerDriverFactory();
        if (!isRoot()) {
            System.err.println("Root access is necessary to perform operations");
        }
        dci = new DockerClientImpl(server.getText());
        CCD = FXCollections.observableArrayList();
        dockerContainers.setItems(CCD);
        dockerContainers.setCellFactory(new Callback<ListView<CustomContainerDetail>, ListCell<CustomContainerDetail>>() {
            @Override
            public ListCell<CustomContainerDetail> call(ListView<CustomContainerDetail> param) {
                ListCell<CustomContainerDetail> cell = new ListCell<CustomContainerDetail>() {
                    @Override
                    protected void updateItem( CustomContainerDetail t, boolean bln) {
                        super.updateItem(t, bln);

                        if (t != null && !bln) {
                            setText(t.nameProperty().getValue().replace("/", ""));
                        } else {
                            setText(null);
                        }
                    }
                };

                return cell;
            }
        });
        if(CCD.size() > 0){
            dockerContainers.getSelectionModel().select(0);
        }
        updateCustomContainerDetailList();

        dockerContainers.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CustomContainerDetail>() {
    @Override
    public void changed(ObservableValue<? extends CustomContainerDetail> observable, CustomContainerDetail oldValue, CustomContainerDetail newValue) {
        updateCustomContainerDetailList();
    }
}
        );
        attachToolTip();
    }

    private void attachToolTip() {
        Tooltip io_wrt_tt = new Tooltip();

        io_wrt_tt.setText(ToolTipDescriptor.blkio_throttle_write_descriptor);
        io_write.setTooltip(io_wrt_tt);

        Tooltip io_rd_tt = new Tooltip();
        io_rd_tt.setText(ToolTipDescriptor.blkio_throttle_read_descriptor);
        io_read.setTooltip(io_rd_tt);

        Tooltip cpu_number_tt = new Tooltip();
        cpu_number_tt.setText(ToolTipDescriptor.cpuset_cpus_descriptor);
        cpu_number.setTooltip(cpu_number_tt);

        Tooltip freq_tt = new Tooltip();
        freq_tt.setText(ToolTipDescriptor.cpf_quota_us_descriptor);
        freq.setTooltip(freq_tt);

        Tooltip maxMem_tt = new Tooltip();
        maxMem_tt.setText(ToolTipDescriptor.memory_max_mem_descriptor);
        maxMem.setTooltip(maxMem_tt);

        Tooltip swap_tt = new Tooltip();
        swap_tt.setText(ToolTipDescriptor.memory_swap_descriptor);
        swap.setTooltip(swap_tt);
    }

    private boolean isRoot() {
        return new File("/usr/bin/ls").canWrite();
    }
}
