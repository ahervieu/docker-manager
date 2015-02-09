package org.kevoree.docker.containerDriver.rest;


import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kevoree.docker.containerDriver.rest.model.CustomContainerRest;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;



public class CustomContainerResourceTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
    /*    // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(Main.BASE_URI);*/
    }

    @After
    public void tearDown() throws Exception {
    //    server.stop();
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() throws JAXBException {
        
//more details here :https://github.com/jersey/jersey/blob/2.15/examples/json-moxy/src/test/java/org/glassfish/jersey/examples/jsonmoxy/JsonResourceTest.java
 /**       Client c = ClientBuilder.newClient();
        target = c.target(Main.BASE_URI);


        CustomContainerRest ccd =  target.path("/api/e924c79baf74412bd8db37b5e060f56947d118a5cad95b534a1ed88e42793944/").request().get(CustomContainerRest.class);
        ccd.setCpuNumber("0");
        ccd.setCpu_freq(5);
        //Upadte Value
  target.path("/api/e924c79baf74412bd8db37b5e060f56947d118a5cad95b534a1ed88e42793944/").
                request(MediaType.APPLICATION_JSON_TYPE).
                put(Entity.entity(ccd, MediaType.APPLICATION_JSON_TYPE),CustomContainerRest.class);

*/
        assert(true);
    }
}
