package org.kevoree.docker.containerDriver.core.cgroupDriver;

import java.io.File;

/**
 * Created by aymeric on 27/11/14.
 */
public class CGroupModifier {


    private File        CgroupFile ;
    private String      string ;
    private String      subSystem;

    public CGroupModifier(File CgroupFile, String string, String subSystem) {
        this.CgroupFile = CgroupFile;
        this.string = string;
        this.subSystem = subSystem;
    }


    public void modify(){
        this.CgroupFile = CgroupFile;
        this.string = string;
        this.subSystem = subSystem;
    }
}
