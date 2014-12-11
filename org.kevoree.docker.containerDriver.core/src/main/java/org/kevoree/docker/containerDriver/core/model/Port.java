package org.kevoree.docker.containerDriver.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 *
 * @author expi
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Port {
    @JsonProperty("PrivatePort")
    public int privatePort;

    @JsonProperty("PublicPort")
    public int publicPort;

    @JsonProperty("Type")
    public String type;

    @JsonProperty("IP")
    public String ip;


    @Override
    public String toString() {
        return "Port{" + "privatePort=" + privatePort + ", publicPort=" + publicPort + ", type=" + type + ", ip=" + ip + '}';
    }
}
