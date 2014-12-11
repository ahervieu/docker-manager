package org.kevoree.docker.containerDriver.core.cgroupDriver;



/**
 * Created by aymeric on 28/11/14.
 */
public class CPUDriver {

    private static Double freq ;

    public static String getCpuValue(String containerId) {
        return   GenericDriver.ReadValue(containerId,"cpuset","cpuset.cpus") ;
    }

    public static String getFreqValue(String containerId) {

        String value  = GenericDriver.ReadValue(containerId,CgroupStructure.cpu_subsystem,"cpu.cfs_quota_us") ;
        if(value.contains("-1")){
            return value ;
        }else  if(!value.isEmpty())   {
            value = value.trim();
            int time = Integer.valueOf(value) ;
            if(time > 100){
                time = 100 ;
            }
            time = time/ 10000;
            return String.valueOf(time) ;
        }else
        {
        return  "" ;
        }
    }

    public static void setCPUValue(String containerId, String value) {
        GenericDriver.SetValue(containerId,CgroupStructure.cpuset_subsystem,"cpuset.cpus",value) ;
    }

    public static void setFreqValue(String containerId, String value) {
        if(!value.isEmpty())   {
        int time = Integer.valueOf(value) * 10000 ;
            GenericDriver.SetValue(containerId,CgroupStructure.cpu_subsystem,"cpu.cfs_period_us","1000000") ;
            GenericDriver.SetValue(containerId,CgroupStructure.cpu_subsystem,"cpu.cfs_quota_us",String.valueOf(time)) ;
        }
    }

}
