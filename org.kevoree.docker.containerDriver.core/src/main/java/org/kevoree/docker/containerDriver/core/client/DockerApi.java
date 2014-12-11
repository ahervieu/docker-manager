package org.kevoree.docker.containerDriver.core.client;

/**
 * Created by leiko on 22/05/14.
 */
public interface DockerApi {
    static final String CONTAINERS_LIST     = "/containers/json";
    static final String INSPECT_CONTAINER   = "/containers/%s/json";
    static final String CREATE_CONTAINER    = "/containers/create";
    static final String START_CONTAINER     = "/containers/%s/start";
    static final String STOP_CONTAINER      = "/containers/%s/stop";
    static final String ATTACH_CONTAINER    = "/containers/%s/attach";
    static final String DELETE_CONTAINER    = "/containers/%s";
    static final String EXEC_CONTAINER      = "/containers/%s/exec" ;

    static final String COMMIT_IMAGE        = "/commit";

    static final String IMAGES_LIST         = "/images/json";
    static final String CREATE_IMAGE        = "/images/create";
    static final String SEARCH_IMAGE        = "/images/search";
    static final String PUSH_IMAGE          = "/images/%s/push";


    static final byte ATTACH_STDIN           = 0;
    static final byte ATTACH_STDOUT          = 1;
    static final byte ATTACH_STDERR          = 2;
}
