package org.kevoree.docker.containerDriver.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.Arrays;
import java.util.Map;

/**
 * Created by leiko on 22/05/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HostConfig {

    @JsonProperty("Binds")           private String[]      binds;
    @JsonProperty("CapAdd")          private String[]      capAdd;
    @JsonProperty("CapDrop")         private String[]      capDrop;
    @JsonProperty("ContainerIDFile") private String        containerIDFile;
    @JsonProperty("Devices")         private Device[]      devices;
    @JsonProperty("Dns")             private Object        dns;
    @JsonProperty("DnsSearch")       private Object        dnsSearch;
    @JsonProperty("ExtraHosts")      private Object        extraHosts;
    @JsonProperty("Links")           private Object        links;
    @JsonProperty("LxcConf")         private Object        lxcConf;
    @JsonProperty("NetworkMode")     private Object        networkMode;
    @JsonProperty("PortBindings")    private Map<String,String[]> portBinding;
    @JsonProperty("Privileged")      private boolean       privileged;
    @JsonProperty("RestartPolicy")   private RestartPolicy restartPolicy;
    @JsonProperty("SecurityOpt")     private Object        securityOpt;
    @JsonProperty("VolumesFrom")     private String[]      volumesFrom;

    public Device[] getDevices() {
        return devices;
    }

    public void setDevices(Device[] devices) {
        this.devices = devices;
    }

    public String[] getBinds() {
        return binds;
    }

    public void setBinds(String[] binds) {
        this.binds = binds;
    }

    public Object getLxcConf() {
        return lxcConf;
    }

    public void setLxcConf(Object lxcConf) {
        this.lxcConf = lxcConf;
    }

    public boolean isPrivileged() {
        return privileged;
    }

    public void setPrivileged(boolean privileged) {
        this.privileged = privileged;
    }

    public Object getLinks() {
        return links;
    }

    public void setLinks(Object links) {
        this.links = links;
    }

    public Object getDns() {
        return dns;
    }

    public void setDns(Object dns) {
        this.dns = dns;
    }

    public Object getVolumesFrom() {
        return volumesFrom;
    }

    public void setVolumesFrom(String[] volumesFrom) {
        this.volumesFrom = volumesFrom;
    }

    public String[] getCapAdd() {
        return capAdd;
    }

    public void setCapAdd(String[] capAdd) {
        this.capAdd = capAdd;
    }

    public String[] getCapDrop() {
        return capDrop;
    }

    public void setCapDrop(String[] capDrop) {
        this.capDrop = capDrop;
    }

    public String getContainerIDFile() {
        return containerIDFile;
    }


    public Object getDnsSearch() {
        return dnsSearch;
    }

    public void setDnsSearch(Object dnsSearch) {
        this.dnsSearch = dnsSearch;
    }

    public Object getExtraHosts() {
        return extraHosts;
    }

    public void setExtraHosts(Object extraHosts) {
        this.extraHosts = extraHosts;
    }

    public Object getNetworkMode() {
        return networkMode;
    }

    public void setNetworkMode(Object networkMode) {
        this.networkMode = networkMode;
    }

    public RestartPolicy getRestartPolicy() {
        return restartPolicy;
    }

    public void setRestartPolicy(RestartPolicy restartPolicy) {
        this.restartPolicy = restartPolicy;
    }


    public void setContainerIDFile(String containerIDFile) {
        this.containerIDFile = containerIDFile;
    }

    public Object getSecurityOpt() {
        return securityOpt;
    }

    public void setSecurityOpt(Object securityOpt) {
        this.securityOpt = securityOpt;
    }

    public Map<String, String[]> getPortBinding() {
        return portBinding;
    }

    public void setPortBinding(Map<String, String[]> portBinding) {
        this.portBinding = portBinding;
    }


    @Override
    public String toString() {
        return "HostConfig{" +
                "binds=" + Arrays.toString(binds) +
                ", capAdd=" + Arrays.toString(capAdd) +
                ", capDrop=" + Arrays.toString(capDrop) +
                ", containerIDFile='" + containerIDFile + '\'' +
                ", devices=" + Arrays.toString(devices) +
                ", dns=" + dns +
                ", dnsSearch=" + dnsSearch +
                ", extraHosts=" + extraHosts +
                ", links=" + links +
                ", lxcConf=" + lxcConf +
                ", networkMode=" + networkMode +
                ", portBinding=" + portBinding +
                ", privileged=" + privileged +
                ", restartPolicy=" + restartPolicy +
                ", securityOpt=" + securityOpt +
                ", volumesFrom=" + Arrays.toString(volumesFrom) +
                '}';
    }
}