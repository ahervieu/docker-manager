package org.kevoree.docker.containerDriver.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.Arrays;

/**
 *
 * @author expi
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Container {

    @JsonProperty("Id")
    private String id;

    @JsonProperty("Command")
    private String command;

    @JsonProperty("Image")
    private String image;

    @JsonProperty("Created")
    private long created;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("Ports")
    private Port[] ports;   //Example value "49164->6900, 49165->7100"

    @JsonProperty("Names")
    private String[] names;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String getStatus() {
        return status;
    }


    @Override
    public String toString() {
        return "Container{" +
                "id='" + id + '\'' +
                ", command='" + command + '\'' +
                ", image='" + image + '\'' +
                ", created=" + created +
                ", status='" + status + '\'' +
                ", ports=" + Arrays.toString(ports) +
                ", names=" + Arrays.toString(names) +
                '}';
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Port[] getPorts() {
        return ports;
    }

    public void setPorts(Port[] ports) {
        this.ports = ports;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

}