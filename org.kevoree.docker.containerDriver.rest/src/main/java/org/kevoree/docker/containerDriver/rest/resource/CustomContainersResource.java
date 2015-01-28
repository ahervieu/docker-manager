package org.kevoree.docker.containerDriver.rest.resource;



import org.kevoree.docker.containerDriver.core.model.CustomContainerDetail;
import org.kevoree.docker.containerDriver.rest.dao.CustomContainerDAO;
import org.kevoree.docker.containerDriver.rest.model.CustomContainerRest;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by aymeric on 12/12/14.
 */

@Path("/api")
public class CustomContainersResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    // Return the list of customContainerDetails for applications

    @GET
    @Path("/containers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CustomContainerRest> getCustomContainerDetails() {

        List<CustomContainerRest> customContainerDetails = new ArrayList<CustomContainerRest>();
        Collection<CustomContainerDetail> Lccd = CustomContainerDAO.instance.getModel().values() ;
        for (CustomContainerDetail customContainerDetail : Lccd) {
            CustomContainerRest   ccr = new CustomContainerRest(customContainerDetail);
            customContainerDetails.add(ccr);


            }

        return customContainerDetails;
    }

    @Path("/{id}")
    public CustomContainerResource getTodo(@PathParam("id") String id) {
        return new CustomContainerResource(uriInfo, request, id);
    }


    @GET
    @Path("/test")
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHello() {
        return "it works" ;
    }



}
