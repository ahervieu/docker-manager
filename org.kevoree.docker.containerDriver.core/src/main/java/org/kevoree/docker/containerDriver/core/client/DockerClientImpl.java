package org.kevoree.docker.containerDriver.core.client;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.core.DockerClientBuilder;


import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by aymeric on 21/01/15.
 */
public class  DockerClientImpl {

    public static  DockerClient  dockerClient = DockerClientBuilder.getInstance("http://localhost:2375").build();

    public  DockerClientImpl(String s) {
        
    }

    public static List<Container> getContainers() {

        return dockerClient.listContainersCmd().exec() ;
    }

    public Container getContainer(String s) {
        List<Container> lst = getContainers() ;
        Container c2 = lst.stream().filter(c -> c.getId().equals(s)).collect(Collectors.toList()).get(0) ;

        return c2 ;
    }
}
