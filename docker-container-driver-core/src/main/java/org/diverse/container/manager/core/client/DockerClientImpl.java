package org.diverse.container.manager.core.client;


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

    public static  DockerClient dockerClient ;
    
    public  DockerClientImpl(String s) {
        dockerClient = DockerClientBuilder.getInstance(s).build();

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
