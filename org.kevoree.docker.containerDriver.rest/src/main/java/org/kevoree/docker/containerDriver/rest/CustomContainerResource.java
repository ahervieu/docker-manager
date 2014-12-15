package org.kevoree.docker.containerDriver.rest;

import org.kevoree.docker.containerDriver.core.model.CustomContainerDetail;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBElement;

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
    @Consumes(MediaType.APPLICATION_XML)
    public Response putCustomContainer(JAXBElement<CustomContainerDetail> customContainerDetail) {
        CustomContainerDetail c = customContainerDetail.getValue();
        return putAndGetResponse(c);
    }
    //We only handle update / not creation
    private Response putAndGetResponse(CustomContainerDetail c) {
        Response res = null;
        if(CustomContainerDAO.instance.getModel().containsKey(c.getId())) {
            res = Response.noContent().build();
            CustomContainerDetail c2 =  CustomContainerDAO.instance.getModel().get(c.getId()) ;
            c2.updateCustomContainerDetail(c);
        } else {
     ///       res = Response.created(uriInfo.getAbsolutePath()).build();
        }

        //Updating existing container


        return res;
    }


}
