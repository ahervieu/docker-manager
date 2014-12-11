package org.kevoree.docker.containerDriver.core.cgroupDriver;

import java.io.File;

/**
 * Created by aymeric on 27/11/14.
 */
public class CGroupUtils
{
    public static boolean isRoot()
    {
        return  new File("/usr/bin/ls").canWrite();
    }

}
