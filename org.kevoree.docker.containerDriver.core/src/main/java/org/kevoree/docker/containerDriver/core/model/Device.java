package org.kevoree.docker.containerDriver.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Created by aymeric on 26/11/14.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Device {


    @JsonProperty("CgroupPermissions")     private String cGroupPermissions ;
    @JsonProperty("PathOnHost")            private String pathOnHost ;
    @JsonProperty("PathInContainer")       private String pathInContainer ;


    public String getcGroupPermissions() {
        return cGroupPermissions;
    }

    public void setcGroupPermissions(String cGroupPermissions) {
        this.cGroupPermissions = cGroupPermissions;
    }

    public String getPathOnHost() {
        return pathOnHost;
    }

    public void setPathOnHost(String pathOnHost) {
        this.pathOnHost = pathOnHost;
    }

    public String getPathInContainer() {
        return pathInContainer;
    }

    public void setPathInContainer(String pathInContainer) {
        this.pathInContainer = pathInContainer;
    }


    @Override
    public String toString() {
        return "Device{" +
                "cGroupPermissions='" + cGroupPermissions + '\'' +
                ", pathOnHost='" + pathOnHost + '\'' +
                ", pathInContainer='" + pathInContainer + '\'' +
                '}';
    }
}
