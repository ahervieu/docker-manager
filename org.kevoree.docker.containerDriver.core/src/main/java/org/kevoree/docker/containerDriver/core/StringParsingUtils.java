package org.kevoree.docker.containerDriver.core;

import org.kevoree.docker.containerDriver.core.cgroupDriver.NetworkDriver;
import org.kevoree.docker.containerDriver.core.model.ContainerDetail;
import org.kevoree.docker.containerDriver.core.model.CustomContainerDetail;

/**
 * Created by aymeric on 10/12/14.
 */
public class StringParsingUtils {

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public static boolean isValidMemory(String s) {
        if(isInteger(s))
        {
            return true ;
        }
        String value = s.substring(0,s.length()-2);
        String unit = s.substring(s.length()-2);
        if(isInteger(value)){
            if(unit.equals("k") || unit.equals("m") || unit.equals("g"))
            {
                return true ;
            }
        }
        return false;
    }


    /**
     * Created by aymeric on 05/12/14.
     */
    public static class ContainerDriverFactory {


        public CustomContainerDetail createCustomContainerDetail(ContainerDetail c){
            CustomContainerDetail currCD = new CustomContainerDetail(c) ;
            BridgeAcquisition ba = new BridgeAcquisition(currCD) ;
            Thread t = new Thread(ba);
            t.start();
            return currCD ;
        }

        class BridgeAcquisition implements Runnable{

            public BridgeAcquisition(CustomContainerDetail ccd)
            {
                this.ccd = ccd ;
            }

            private CustomContainerDetail ccd ;


            @Override
            public void run() {
                ccd.setBridge(NetworkDriver.getContainerBridge(ccd.getContainer().getNetworkSettings().getIpAddress()));
            }
        }

    }
}
