package org.kevoree.docker.containerDriver.rest;



import org.kevoree.docker.containerDriver.core.model.CustomContainerDetail;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by aymeric on 12/12/14.
 */

@Path("/Containers")
public class CustomContainersResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    // Return the list of customContainerDetails for applications

    @GET
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

    @Path("{CustomContainerRest}")
    public CustomContainerResource getTodo(@PathParam("CustomContainerRest") String id) {
        return new CustomContainerResource(uriInfo, request, id);
    }




}
