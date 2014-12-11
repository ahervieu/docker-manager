package org.kevoree.docker.containerDriver.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.Map;

/**
 *
 * @author expi
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NetworkSettings {

    @JsonProperty("IPAddress")
    private String ipAddress;
    @JsonProperty("IPPrefixLen")
    private int ipPrefixLen;
    @JsonProperty("Gateway")
    private String gateway;
    @JsonProperty("Bridge")
    private String bridge;
    @JsonProperty("PortMapping")
    private Map<String, Map<String, String>> portMapping;

    @JsonProperty("Ports")
    private Map<String, NetworkPort[]> ports;

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getIpPrefixLen() {
        return ipPrefixLen;
    }

    public void setIpPrefixLen(int ipPrefixLen) {
        this.ipPrefixLen = ipPrefixLen;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getBridge() {
        return bridge;
    }

    public void setBridge(String bridge) {
        this.bridge = bridge;
    }

    public Map<String, Map<String, String>> getPortMapping() {
        return portMapping;
    }

    public void setPortMapping(Map<String, Map<String, String>> portMapping) {
        this.portMapping = portMapping;
    }

    public Map<String, NetworkPort[]> getPorts() {
        return ports;
    }

    public void setPorts(Map<String, NetworkPort[]> ports) {
        this.ports = ports;
    }


    @Override
    public String toString() {
        return "NetworkSettings{" + "ipAddress=" + ipAddress + ", ipPrefixLen=" + ipPrefixLen + ", gateway=" + gateway + ", bridge=" + bridge + ", portMapping=" + portMapping + ", ports=" + ports + '}';
    }
}
