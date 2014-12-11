package org.kevoree.docker.containerDriver.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by leiko on 22/05/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProgressDetail {

    @JsonProperty("current")
    private Integer current;

    @JsonProperty("total")
    private Integer total;
}
