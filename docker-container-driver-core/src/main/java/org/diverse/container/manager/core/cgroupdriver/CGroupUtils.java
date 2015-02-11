package org.diverse.container.manager.core.cgroupdriver;


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
