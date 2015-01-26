package org.kevoree.docker.containerDriver.core.cgroupDriver;


import org.kevoree.docker.containerDriver.core.StringParsingUtils;

/**
 * Created by aymeric on 27/11/14.
 */
public class BlkioDriver {


    public static String getWriteValue(String containerId) {
       String value = GenericDriver.ReadValue(containerId,CgroupStructure.blkio_subsystem,CgroupStructure.blkio_write) ;
                if(!value.isEmpty())
                {
                    value = value.split(" ")[1] ;
                }
        return value ;
    }


    public static String getReadValue(String containerId) {
        String value = GenericDriver.ReadValue(containerId,CgroupStructure.blkio_subsystem,CgroupStructure.blkio_read) ;

        if(!value.isEmpty())
        {
            value = value.split(" ")[1] ;
        }

        return value ;
        }

    public static void setReadValue(String containerId, String value) {
        if(StringParsingUtils.isInteger(value)){

            if(value.equals("-1")){
                GenericDriver.SetValue(containerId,CgroupStructure.blkio_subsystem,CgroupStructure.blkio_read,"") ;
            }else{
                value = "8:0 " + value ;
                GenericDriver.SetValue(containerId,CgroupStructure.blkio_subsystem,CgroupStructure.blkio_read,value) ;
            }

        }
    }

    public static void setWriteValue(String containerId, String value) {
        if(StringParsingUtils.isInteger(value)){
            if(value.equals("-1")){
                GenericDriver.SetValue(containerId,CgroupStructure.blkio_subsystem,CgroupStructure.blkio_write,"") ;
            }else{
                value = "8:0 " + value ;
               GenericDriver.SetValue(containerId,CgroupStructure.blkio_subsystem,CgroupStructure.blkio_write,value) ;
            }

        }
    }


}
