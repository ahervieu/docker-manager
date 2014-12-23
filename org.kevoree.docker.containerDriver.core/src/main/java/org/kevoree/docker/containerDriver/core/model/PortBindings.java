package org.kevoree.docker.containerDriver.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by aymeric on 26/11/14.
 */
public class PortBindings {

    @JsonProperty("HostIp")           private String      hostIp;
    @JsonProperty("HostPort")         private int         hostPort;

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public int getHostPort() {
        return hostPort;
    }

    public void setHostPort(int hostPort) {
        this.hostPort = hostPort;
    }

    @Override
    public String toString() {
        return "PortBindings{" +
                "hostIp='" + hostIp + '\'' +
                ", hostPort=" + hostPort +
                '}';
    }
}
