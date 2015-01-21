package org.kevoree.docker.containerDriver.core;

import org.kevoree.docker.containerDriver.core.cgroupDriver.BlkioDriver;
import org.kevoree.docker.containerDriver.core.cgroupDriver.CPUDriver;
import org.kevoree.docker.containerDriver.core.cgroupDriver.MemoryDriver;
import org.kevoree.docker.containerDriver.core.cgroupDriver.NetworkDriver;
import org.kevoree.docker.containerDriver.core.model.CustomContainerDetail;

import com.github.dockerjava.api.model.Container;
/**
     * Created by aymeric on 05/12/14.
     */
    public  class ContainerDriverFactory {


        public CustomContainerDetail createCustomContainerDetail(Container c){
            CustomContainerDetail currCD = new CustomContainerDetail(c) ;
            populateCustomContainer(currCD);
            BridgeAcquisition ba = new BridgeAcquisition(currCD) ;
            Thread t = new Thread(ba);
            t.start();
            return currCD ;
        }

    /*
    Read actual value in cGroup
     */
        private void populateCustomContainer(CustomContainerDetail cdc)
        {

          //  ContainerConfig currConf = cdc.getContainer().getConfig();
            int freq_val = -1;
            int io_write_speed = -1 ;
            int io_read_speed = -1 ;

            String cpu = CPUDriver.getCpuValue(cdc.getId());
            String max_mem = MemoryDriver.getMaxMemValue(cdc.getId()) ;
            String max_swap = MemoryDriver.getSwapValue(cdc.getId()) ;

            if(!CPUDriver.getFreqValue(cdc.getId()).equals("")){

                freq_val = Integer.valueOf(CPUDriver.getFreqValue(cdc.getId()).trim()) ;
            }
            if(!BlkioDriver.getWriteValue(cdc.getId()).equals("")){
                io_write_speed = Integer.valueOf(BlkioDriver.getWriteValue(cdc.getId()).trim()) ;
            }
            if(!BlkioDriver.getReadValue(cdc.getId()).equals("")){
                io_read_speed = Integer.valueOf(BlkioDriver.getReadValue(cdc.getId()).trim()) ;
            }
            cdc.setMax_swap(max_swap);
            cdc.setCpu_freq(freq_val);
            cdc.setMax_mem(max_mem);
            cdc.setCpuNumber(cpu);
            cdc.setIo_write_speed(io_write_speed);
            cdc.setIo_read_speed(io_read_speed);
        }




        class BridgeAcquisition implements Runnable{

            public BridgeAcquisition(CustomContainerDetail ccd)
            {
                this.ccd = ccd ;
            }

            private CustomContainerDetail ccd ;


            @Override
            public void run() {
                ccd.setBridge(NetworkDriver.getContainerBridge(ccd.getContainer().().getIpAddress()));
            }
        }

    }