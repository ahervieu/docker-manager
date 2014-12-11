package org.kevoree.docker.containerDriver.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Created by leiko on 22/05/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageInfo {


    @JsonProperty("description")
    private String description = "";

    @JsonProperty("is_official")
    private boolean isOfficial = false;

    @JsonProperty("is_trusted")
    private boolean isTrusted = false;


    @JsonProperty("name")
    private String name = "";

    @JsonProperty("star_count")
    private int starCount = 0;


    @Override
    public String toString() {
        return "ImageInfo {description="+description+", isOfficial="+isOfficial+", isTrusted="+isTrusted+", name="+name+", startCount="+starCount+"}";
    }
}
