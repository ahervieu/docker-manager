package org.kevoree.docker.containerDriver.core.client.test;

import org.junit.Test;
import org.kevoree.docker.containerDriver.core.client.DockerClientImpl_old;
import org.kevoree.docker.containerDriver.core.model.Container;
import org.kevoree.docker.containerDriver.core.model.ExecConfig;


import java.util.List;


public class DockerClientImplTest {

    @Test
    public void testGetContainers() throws Exception {
        DockerClientImpl_old dci = new DockerClientImpl_old() ;
        List<Container> lstCon = dci.getContainers() ;
        String[] tab= {"mkdir  jjjj"};
        ExecConfig execConf = new ExecConfig(true,true,true,true,tab,lstCon.get(0).getId());
        dci.exec(lstCon.get(0).getId(),execConf);
        System.out.println(lstCon.get(0).getNames()[0]);

    }
}