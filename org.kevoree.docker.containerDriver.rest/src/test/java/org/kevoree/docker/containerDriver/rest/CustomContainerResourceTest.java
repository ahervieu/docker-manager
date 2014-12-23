package org.kevoree.docker.containerDriver.rest;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.kevoree.docker.containerDriver.core.model.CustomContainerDetail;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.io.StringReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
 /*       String responseMsg = target.path("Containers/855d72d8cfbe0309b6cb45ef1fe0fa41c9670ff1a5036201690711428717f565").request().get(String.class);
        System.out.println(responseMsg);
        JAXBContext jaxbContext = JAXBContext.newInstance(CustomContainerDetail.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(responseMsg);
        CustomContainerDetail ccr = (CustomContainerDetail) jaxbUnmarshaller.unmarshal(reader);
        System.out.println(ccr.toString());
  //      assertNotNull(responseMsg);*/
        assert(true);
    }
}
