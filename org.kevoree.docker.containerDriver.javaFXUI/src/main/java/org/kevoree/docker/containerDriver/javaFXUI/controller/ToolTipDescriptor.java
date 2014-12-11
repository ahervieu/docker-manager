package org.kevoree.docker.containerDriver.javaFXUI.controller;

/**
 * Created by aymeric on 01/12/14.
 */
public interface ToolTipDescriptor {

    static final String cpf_quota_us_descriptor =
            "Specifies the total amount of time in persent for which all tasks in a cgroup can run during one period. As soon as tasks\n" +
            "in a cgroup use up all the time specified by the quota, they are throttled for the remainder of the time specified by the\n" +
            "period and not allowed to run until the next period. Setting the value in cpu.cfs_quota_us to -1 indicates that the cgroup\n" +
            "does not adhere to any CPU time restrictions." ;


    static final String blkio_throttle_read_descriptor =
            "Specifies the upper limit on the number of read operations a device can perform. The rate of the read operations is specified\n" +
            "in bytes per second." ;

    static final String blkio_throttle_write_descriptor =
            "Specifies the upper limit on the number of read operations a device can perform. The rate of the read operations is specified\n" +
             "in operations per second." ;

    static final String cpuset_cpus_descriptor =
            "Specifies the CPUs that tasks in this cgroup are permitted to access. This is a comma-separated list, with dashes (\"-\") to\n" +
             "represent ranges." ;

    static final String memory_max_mem_descriptor =
            "Sets the maximum amount of user memory (including file cache). If no units are specified, the value is interpreted as bytes.\n" +
             "However, it is possible to use suffixes to represent larger units — k or K for kilobytes, m or M for Megabytes, and g or G for\n" +
            "Gigabytes." ;

    static final String memory_swap_descriptor =
            "Sets the maximum amount for the sum of memory and swap usage. If no units are specified, the value is interpreted as bytes.\n" +
            "However, it is possible to use suffixes to represent larger units — k or K for kilobytes, m or M for Megabytes, and g or G for\n" +
             "Gigabytes. ";

}
