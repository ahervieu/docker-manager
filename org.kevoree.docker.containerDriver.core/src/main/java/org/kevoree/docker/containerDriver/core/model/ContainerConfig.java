package org.kevoree.docker.containerDriver.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.Arrays;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContainerConfig {

    @JsonProperty("AttachStderr")    private boolean       attachStderr = false;
    @JsonProperty("AttachStdin")     private boolean       attachStdin = false;
    @JsonProperty("AttachStdout")    private boolean       attachStdout = false;
    @JsonProperty("Cmd")             private String[]      cmd;
    @JsonProperty("CpuShares")       private int           cpuShares = 0;
    @JsonProperty("Cpuset")          private String        cpuset = "";
    @JsonProperty("Dns")             private String[]      dns;
    @JsonProperty("Domainname")      public String         domainName = "";
    @JsonProperty("Entrypoint")      private String[]      entrypoint = new String[]{};
    @JsonProperty("Env")             private String[]      env;
    @JsonProperty("ExposedPorts")    public Map<String, ?> exposedPorts;
    @JsonProperty("Hostname")        private String        hostName = "";
    @JsonProperty("Image")           private String        image;
    @JsonProperty("Memory")          private long          memoryLimit = 0;
    @JsonProperty("MemorySwap")      private long          memorySwap = 0;
    @JsonProperty("NetworkDisabled") private boolean       networkDisabled = false;
    @JsonProperty("OnBuild")         private int[]         onBuild;
    @JsonProperty("OpenStdin")       private boolean       stdinOpen = false;
    @JsonProperty("StdinOnce")       private boolean       stdInOnce = false;
    @JsonProperty("PortSpecs")       private String[]      portSpecs;
    @JsonProperty("Tty")             private boolean       tty = false;
    @JsonProperty("User")            private String        user = "";
    @JsonProperty("Volumes")         private Object        volumes;
    @JsonProperty("WorkingDir")      private String        workingDir = "";


    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String[] getPortSpecs() {
        return portSpecs;
    }

    public void setPortSpecs(String[] portSpecs) {
        this.portSpecs = portSpecs;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public boolean isTty() {
        return tty;
    }

    public void setTty(boolean tty) {
        this.tty = tty;
    }

    public boolean isStdinOpen() {
        return stdinOpen;
    }

    public void setStdinOpen(boolean stdinOpen) {
        this.stdinOpen = stdinOpen;
    }

    public boolean isStdInOnce() {
        return stdInOnce;
    }

    public void setStdInOnce(boolean stdInOnce) {
        this.stdInOnce = stdInOnce;
    }

    public long getMemoryLimit() {
        return memoryLimit;
    }

    public void setMemoryLimit(long memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public long getMemorySwap() {
        return memorySwap;
    }

    public void setMemorySwap(long memorySwap) {
        this.memorySwap = memorySwap;
    }

    public int getCpuShares() {
        return cpuShares;
    }

    public void setCpuShares(int cpuShares) {
        this.cpuShares = cpuShares;
    }

    public boolean isAttachStdin() {
        return attachStdin;
    }

    public void setAttachStdin(boolean attachStdin) {
        this.attachStdin = attachStdin;
    }

    public boolean isAttachStdout() {
        return attachStdout;
    }

    public void setAttachStdout(boolean attachStdout) {
        this.attachStdout = attachStdout;
    }

    public boolean isAttachStderr() {
        return attachStderr;
    }

    public void setAttachStderr(boolean attachStderr) {
        this.attachStderr = attachStderr;
    }

    public String[] getEnv() {
        return env;
    }

    public void setEnv(String[] env) {
        this.env = env;
    }

    public String[] getCmd() {
        return cmd;
    }

    public void setCmd(String[] cmd) {
        this.cmd = cmd;
    }

    public String[] getDns() {
        return dns;
    }

    public void setDns(String[] dns) {
        this.dns = dns;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Object getVolumes() {
        return volumes;
    }

    public void setVolumes(Object volumes) {
        this.volumes = volumes;
    }

    public String[] getEntrypoint() {
        return entrypoint;
    }

    public void setEntrypoint(String[] entrypoint) {
        this.entrypoint = entrypoint;
    }

    public boolean isNetworkDisabled() {
        return networkDisabled;
    }

    public void setNetworkDisabled(boolean networkDisabled) {
        this.networkDisabled = networkDisabled;
    }

    public String getWorkingDir() {
        return workingDir;
    }

    public void setWorkingDir(String workingDir) {
        this.workingDir = workingDir;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public Map<String, ?> getExposedPorts() {
        return exposedPorts;
    }

    public void setExposedPorts(Map<String, ?> exposedPorts) {
        this.exposedPorts = exposedPorts;
    }

    public String getCpuset() {
        return cpuset;
    }

    public void setCpuset(String cpuset) {
        this.cpuset = cpuset;
    }

    public int[] getOnBuild() {
        return onBuild;
    }

    public void setOnBuild(int[] onBuild) {
        this.onBuild = onBuild;
    }


    @Override
    public String toString() {
        return "ContainerConfig{" +
                "attachStderr=" + attachStderr +
                ", attachStdin=" + attachStdin +
                ", attachStdout=" + attachStdout +
                ", cmd=" + Arrays.toString(cmd) +
                ", cpuShares=" + cpuShares +
                ", cpuset='" + cpuset + '\'' +
                ", dns=" + Arrays.toString(dns) +
                ", domainName='" + domainName + '\'' +
                ", entrypoint=" + Arrays.toString(entrypoint) +
                ", env=" + Arrays.toString(env) +
                ", exposedPorts=" + exposedPorts +
                ", hostName='" + hostName + '\'' +
                ", image='" + image + '\'' +
                ", memoryLimit=" + memoryLimit +
                ", memorySwap=" + memorySwap +
                ", networkDisabled=" + networkDisabled +
                ", onBuild=" + Arrays.toString(onBuild) +
                ", stdinOpen=" + stdinOpen +
                ", stdInOnce=" + stdInOnce +
                ", portSpecs=" + Arrays.toString(portSpecs) +
                ", tty=" + tty +
                ", user='" + user + '\'' +
                ", volumes=" + volumes +
                ", workingDir='" + workingDir + '\'' +
                '}';
    }
}
