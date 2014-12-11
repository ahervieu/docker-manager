package org.kevoree.docker.containerDriver.core.model;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by aymeric on 02/12/14.
 */
public class CustomContainerDetail {


    private ContainerDetail container ;
    private String bridge = "" ;
    private int incomingTraffic ;
    private int outgoingTraffic ;
    private int corruptionRate ;
    private int lossRate ;
    private int delayRate ;
    private SimpleStringProperty idProperty ;
    private SimpleStringProperty nameProp ;

    public CustomContainerDetail(ContainerDetail container) {
        idProperty = new SimpleStringProperty() ;
        idProperty.setValue(container.getId());
        nameProp = new SimpleStringProperty();
        nameProp.setValue(container.getName());
        System.out.println(nameProp.getValue());
        this.container = container ;
        incomingTraffic= -1;
        outgoingTraffic =-1;
        lossRate = -1;
        delayRate = -1 ;
    }

    public SimpleStringProperty nameProperty() {
        return nameProp;
    }

    @Override
    public boolean equals( Object obj) {
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        final CustomContainerDetail other = (CustomContainerDetail) obj;
        return (other.getContainer().getId().equals(this.getContainer().getId()));
    }


    public String getId(){
        return  idProperty.getValue();
    }

    public void  setId(String _id){
          idProperty.setValue(_id);
    }

    public SimpleStringProperty idPropertyProperty() {
        return idProperty;
    }

    public ContainerDetail getContainer() {
        return container;
    }

    public void setContainer(ContainerDetail container) {
        this.container = container;
    }

    public String getBridge() {
         return bridge;
    }

    public void setBridge(String bridge) {
        this.bridge = bridge;
    }

    public int getIncomingTraffic() {
        return incomingTraffic;
    }

    public void setIncomingTraffic(int incomingTraffic) {
        this.incomingTraffic = incomingTraffic;
    }

    public int getOutgoingTraffic() {
        return outgoingTraffic;
    }

    public void setOutgoingTraffic(int outgoingTraffic) {
        this.outgoingTraffic = outgoingTraffic;
    }

    public int getCorruptionRate() {
        return corruptionRate;
    }

    public void setCorruptionRate(int corruptionRate) {
        this.corruptionRate = corruptionRate;
    }

    public int getLossRate() {
        return lossRate;
    }

    public void setLossRate(int lossRate) {
        this.lossRate = lossRate;
    }

    public int getDelayRate() {
        return delayRate;
    }

    public void setDelayRate(int delayRate) {
        this.delayRate = delayRate;
    }


}
