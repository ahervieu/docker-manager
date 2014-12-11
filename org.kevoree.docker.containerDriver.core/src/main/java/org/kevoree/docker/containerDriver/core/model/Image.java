package org.kevoree.docker.containerDriver.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 *
 * @author Konstantin Pelykh (kpelykh@gmail.com)
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Image {

    @JsonProperty("Created")
    private long created;

    @JsonProperty("Id")
    private String id;

    @JsonProperty("ParentId")
    private String parentId;

    @JsonProperty("RepoTags")
    private String[] repoTags;

    @JsonProperty("Size")
    private long size;

    @JsonProperty("VirtualSize")
    private long virtualSize;

    public String getId() {
        return id;
    }

    public String[] getRepoTags() {
        return repoTags;
    }

    public String getParentId() {
        return parentId;
    }

    public long getCreated() {
        return created;
    }

    public long getSize() {
        return size;
    }

    public long getVirtualSize() {
        return virtualSize;
    }

    public String getRepo() {
        String repo = "";
        if (repoTags.length > 0) {
            repo = repoTags[0].split(":")[0];
        }
        return repo;
    }


    public String[] getTags() {
        String[] tags = new String[repoTags.length];
        for (int i=0; i < tags.length; i++) {
            tags[i] = repoTags[i].split(":")[1];
        }
        return tags;
    }


    @Override
    public String toString() {
        return "Image {id="+id+", repo="+getRepo()+", nbTags="+getTags().length+", created="+created+", parentId="+parentId+", size="+size+", virtualSize="+virtualSize+"}";
    }
}
