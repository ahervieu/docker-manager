package org.diverse.container.manager.rest.dao ;

import com.github.dockerjava.api.model.Container;
import org.diverse.container.manager.core.ContainerDriverFactory;
import org.diverse.container.manager.core.client.DockerClientImpl;
import org.diverse.container.manager.core.model.CustomContainerDetail;


import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by aymeric on 12/12/14.
 */
public enum CustomContainerDAO {
    instance ;

    private DockerClientImpl dci;

    private ContainerDriverFactory factory;

    private Map<String, CustomContainerDetail> contentProvider = new HashMap<String, CustomContainerDetail>();

    private CustomContainerDAO() {

        factory = new ContainerDriverFactory();
        String host = System.getenv().get("DOCKER_HOST") ;
        if(host == null){
            dci = new DockerClientImpl("http://127.0.0.1:2375");
        }else
        {
            dci = new DockerClientImpl("http://"+host+":2375");
        }
        updateContainerMap();
    }

    public Map<String, CustomContainerDetail> getModel(){
        updateContainerMap();
        return contentProvider;
    }

    private void updateContainerMap(){
        List<String> container_to_rm = new ArrayList<String>();
        List<String> container_to_add = new ArrayList<String>();

            List<Container> lstCon = dci.getContainers();
            // Check that all current container in the app are still active
            for (String id : contentProvider.keySet()) {
                boolean stop = false;
                for (int i = 0; i < lstCon.size() && !stop; i++) {
                    Container currContain = lstCon.get(i);
                    if (currContain.getId().equals(id)) {
                        stop = true;
                    }
                }
                if (!stop) {

                    container_to_rm.add(id);
                }
            }
            // Check if there are new container
            // adding new container
            for (Container container : lstCon) {
                boolean found = false;
                for (String s : contentProvider.keySet()) {
                    if (container.getId().equals(s)) {
                        found = true;
                    }
                }
                if (!found) {
                    container_to_add.add(container.getId());
                }
            }




            // Resolving
            //Removing containers :
            container_to_rm.forEach(s -> contentProvider.remove(s));

            for (String s : container_to_add) {
                contentProvider.put(s, factory.createCustomContainerDetail(dci.getContainer(s)));
            }
        }
 }
