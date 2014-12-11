package org.kevoree.docker.containerDriver.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Created by leiko on 22/05/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageConfig {

    @JsonProperty("fromImage")
    private String fromImage;

    @JsonProperty("fromSrc")
    private String fromSrc = "";

    @JsonProperty("repo")
    private String repo = "";

    @JsonProperty("tag")
    private String tag = "";

    @JsonProperty("registry")
    private String registry = "";

    public String getFromImage() {
        return fromImage;
    }

    public void setFromImage(String fromImage) {
        this.fromImage = fromImage;
    }

    public String getFromSrc() {
        return fromSrc;
    }

    public void setFromSrc(String fromSrc) {
        this.fromSrc = fromSrc;
    }

    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getRegistry() {
        return registry;
    }

    public void setRegistry(String registry) {
        this.registry = registry;
    }


    @Override
    public String toString() {
        return "ImageConfig {fromImage="+fromImage+", fromSrc="+fromSrc+", repo="+repo+", tag="+tag+", registry="+registry+"}";
    }
}
