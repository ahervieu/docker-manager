package org.kevoree.docker.containerDriver.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 *
 * @author expi
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NetworkPort {

    @JsonProperty("HostIp")
    private String hostIp;

    @JsonProperty("HostPort")
    private String hostPort;

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public String getHostPort() {
        return hostPort;
    }

    public void setHostPort(String hostPort) {
        this.hostPort = hostPort;
    }


    @Override
    public String toString() {
        return "NetworkPort{" + "hostIp=" + hostIp + ", hostPort=" + hostPort + '}';
    }
   
}
