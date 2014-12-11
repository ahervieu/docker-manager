package org.kevoree.docker.containerDriver.core.cgroupDriver;


/**
 * Created by aymeric on 27/11/14.
 */
public class MemoryDriver {

    public static String getMaxMemValue(String containerId) {
        return GenericDriver.ReadValue(containerId,CgroupStructure.memory_subsystem,CgroupStructure.memory_max_mem) ;
    }

    public static String getSwapValue(String containerId) {
        return GenericDriver.ReadValue(containerId,CgroupStructure.memory_subsystem,CgroupStructure.memory_swap) ;
    }

    public static void setMaxMemValue(String containerId, String value) {
        GenericDriver.SetValue(containerId,CgroupStructure.memory_subsystem,CgroupStructure.memory_max_mem,value) ;
    }

    public static void setSwapValue(String containerId, String value) {
        GenericDriver.SetValue(containerId,CgroupStructure.memory_subsystem,CgroupStructure.memory_swap,value) ;
    }

}
