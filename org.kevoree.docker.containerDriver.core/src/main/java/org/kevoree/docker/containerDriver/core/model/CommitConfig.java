package org.kevoree.docker.containerDriver.core.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * Created by leiko on 22/05/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommitConfig {


    private String container = "";

    private String repo = "";

    private String tag = "";

    private String message = "";

    private String author = "";


    public String getContainer() {
        return container;
    }

    public void setContainer( String container) {
        if (container != null) {
            this.container = container;
        }
    }


    public String getRepo() {
        return repo;
    }

    public void setRepo( String repo) {
        if (repo != null) {
            this.repo = repo;
        }
    }


    public String getTag() {
        return tag;
    }

    public void setTag( String tag) {
        if (tag != null) {
            this.tag = tag;
        }
    }


    public String getMessage() {
        return message;
    }

    public void setMessage( String m) {
        if (m != null) {
            this.message = m;
        }
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor( String author) {
        if (author != null) {
            this.author = author;
        }
    }
}
