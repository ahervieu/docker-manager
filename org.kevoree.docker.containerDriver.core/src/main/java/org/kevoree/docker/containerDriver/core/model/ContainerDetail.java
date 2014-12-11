package org.kevoree.docker.containerDriver.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.Map;

/**
 *
 * @author expi
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContainerDetail {

    @JsonProperty("Id")              private String              id;
    @JsonProperty("Created")         private String              created;
    @JsonProperty("Path")            private String              path;
    @JsonProperty("Args")            private String[]            args;
    @JsonProperty("Config")          private ContainerConfig     config;
    @JsonProperty("State")           private ContainerState      state;
    @JsonProperty("Image")           private String              image;
    @JsonProperty("NetworkSettings") private NetworkSettings     networkSettings;
    @JsonProperty("ResolvConfPath")  private String              resolvConfPath;
    @JsonProperty("Volumes")         private Map<String, String> volumes;
    @JsonProperty("VolumesRW")       private Map<String, String> volumesRW;
    @JsonProperty("HostnamePath")    private String              hostnamePath;
    @JsonProperty("HostsPath")       private String              hostsPath;
    @JsonProperty("Name")            private String              name;
    @JsonProperty("Driver")          private String              drive;
    @JsonProperty("ExecDriver")      private String              execDriver;
    @JsonProperty("MountLabel")      private String              mountLabel;
    @JsonProperty("ProcessLabel")    private String              processLabel;
    @JsonProperty("HostConfig")      private HostConfig          hostConfig;
    @JsonProperty("AppArmorProfile") private String              appArmorProfile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public ContainerConfig getConfig() {
        return config;
    }

    public void setConfig(ContainerConfig config) {
        this.config = config;
    }

    public ContainerState getState() {
        return state;
    }

    public void setState(ContainerState state) {
        this.state = state;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public NetworkSettings getNetworkSettings() {
        return networkSettings;
    }

    public void setNetworkSettings(NetworkSettings networkSettings) {
        this.networkSettings = networkSettings;
    }

    public String getResolvConfPath() {
        return resolvConfPath;
    }

    public String getExecDriver() {
        return execDriver;
    }

    public void setExecDriver(String execDriver) {
        this.execDriver = execDriver;
    }

    public void setResolvConfPath(String resolvConfPath) {
        this.resolvConfPath = resolvConfPath;
    }

    public Map<String, String> getVolumes() {
        return volumes;
    }

    public void setVolumes(Map<String, String> volumes) {
        this.volumes = volumes;
    }

    public Map<String, String> getVolumesRW() {
        return volumesRW;
    }

    public void setVolumesRW(Map<String, String> volumesRW) {
        this.volumesRW = volumesRW;
    }

    public String getHostnamePath() {
        return hostnamePath;
    }

    public void setHostnamePath(String hostnamePath) {
        this.hostnamePath = hostnamePath;
    }

    public String getHostsPath() {
        return hostsPath;
    }

    public void setHostsPath(String hostsPath) {
        this.hostsPath = hostsPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public String getMountLabel() {
        return mountLabel;
    }

    public void setMountLabel(String mountLabel) {
        this.mountLabel = mountLabel;
    }

    public String getProcessLabel() {
        return processLabel;
    }

    public void setProcessLabel(String processLabel) {
        this.processLabel = processLabel;
    }

    public HostConfig getHostConfig() {
        return hostConfig;
    }

    public void setHostConfig(HostConfig hostConfig) {
        this.hostConfig = hostConfig;
    }

    public String getAppArmorProfile() {
        return appArmorProfile;
    }

    public void setAppArmorProfile(String appArmorProfile) {
        this.appArmorProfile = appArmorProfile;
    }


    @Override
    public String toString() {
        return "ContainerDetail{" + "id=" + id + ", created=" + created + ", path=" + path + ", args=" + args + ", config=" + config + ", state=" + state + ", image=" + image + ", networkSettings=" + networkSettings +  ", resolvConfPath=" + resolvConfPath + ", volumes=" + volumes + ", volumesRW=" + volumesRW +", hostnamePath=" + hostnamePath + ", hostsPath=" + hostsPath + ", name=" + name + ", drive=" + drive + ", execDriver="+execDriver+"}";
    }


}