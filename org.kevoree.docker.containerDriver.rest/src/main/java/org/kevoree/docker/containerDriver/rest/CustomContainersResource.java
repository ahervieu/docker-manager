package org.kevoree.docker.containerDriver.rest;

import org.kevoree.docker.containerDriver.core.model.CustomContainerDetail;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
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


    @GET
    @Produces(MediaType.TEXT_XML)
    public List<CustomContainerDetail> getCustomContainerDetailsBrowser() {
        List<CustomContainerDetail> customContainerDetails = new ArrayList<CustomContainerDetail>();
        customContainerDetails.addAll(CustomContainerDAO.instance.getModel().values());
        return customContainerDetails;
    }


    // Return the list of customContainerDetails for applications
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<CustomContainerDetail> getCustomContainerDetails() {
        List<CustomContainerDetail> customContainerDetails = new ArrayList<CustomContainerDetail>();
        customContainerDetails.addAll(CustomContainerDAO.instance.getModel().values());
        return customContainerDetails;
    }

    @Path("{customContainerDetail}")
    public CustomContainerResource getTodo(@PathParam("customContainerDetail") String id) {
        return new CustomContainerResource(uriInfo, request, id);
    }



}
