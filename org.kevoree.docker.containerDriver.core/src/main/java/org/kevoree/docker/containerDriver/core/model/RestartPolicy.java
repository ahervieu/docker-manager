package org.kevoree.docker.containerDriver.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Created by aymeric on 26/11/14.
 */
public class RestartPolicy {


    @JsonProperty("MaximumRetryCount")    private int maximumRetryCount ;
    @JsonProperty("Name")                 private String name ;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaximumRetryCount() {
        return maximumRetryCount;
    }

    public void setMaximumRetryCount(int maximumRetryCount) {
        this.maximumRetryCount = maximumRetryCount;
    }


    @Override
    public String toString() {
        return "RestartPolicy{" +
                "maximumRetryCount=" + maximumRetryCount +
                ", name='" + name + '\'' +
                '}';
    }
}



