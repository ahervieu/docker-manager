package org.kevoree.docker.containerDriver.rest;

import org.kevoree.docker.containerDriver.core.model.CustomContainerDetail;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

/**
 * Created by aymeric on 12/12/14.
 */
public class CustomContainerResource {

    @Context
    private UriInfo uriInfo;
    @Context
    private Request request;

    private String id;

    public CustomContainerResource(UriInfo uriInfo, Request request, String id) {
        this.uriInfo = uriInfo;
        this.request = request;
        this.id = id;
    }

    //Application integration
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public CustomContainerDetail getCustomContainerDetail(){
        CustomContainerDetail ccd = CustomContainerDAO.instance.getModel().get(id);
        if(ccd == null)
            throw new RuntimeException("Get: CustomContainerDetail with " + id +  " not found");
        return ccd;
    }

    @GET
    @Produces(MediaType.TEXT_XML)
    public CustomContainerDetail getCustomContainerDetailHTML(){
        CustomContainerDetail ccd = CustomContainerDAO.instance.getModel().get(id);
        if(ccd == null)
            throw new RuntimeException("Get: CustomContainerDetail with " + id +  " not found");
        return ccd;
    }
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateContainer(){
        System.out.println(uriInfo.getAbsolutePath().toString());
        System.out.println(request.getMethod());
    }


}
