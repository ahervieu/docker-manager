package org.kevoree.docker.containerDriver.rest.resource;

import org.kevoree.docker.containerDriver.core.model.CustomContainerDetail;
import org.kevoree.docker.containerDriver.rest.dao.CustomContainerDAO;
import org.kevoree.docker.containerDriver.rest.model.CustomContainerRest;

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
    @Produces(MediaType.APPLICATION_JSON)
    public CustomContainerRest getCustomContainerDetail(){
        CustomContainerDetail ccd = CustomContainerDAO.instance.getModel().get(id);
        if(ccd == null)
            throw new RuntimeException("Get: CustomContainerDetail with " + id +  " not found");
        return new CustomContainerRest(ccd);
    }


    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putCustomContainer(JAXBElement<CustomContainerRest> customContainerDetail) {
        CustomContainerRest c = customContainerDetail.getValue();
        return putAndGetResponse(c);
    }
    //We only handle update / not creation
    private Response putAndGetResponse(CustomContainerRest c) {

        System.out.println("Put");
        System.out.println(c.toString());
        Response res = null;

        if(CustomContainerDAO.instance.getModel().containsKey(c.getId())) {
            res = Response.noContent().build();
            CustomContainerDetail c2 =  CustomContainerDAO.instance.getModel().get(c.getId()) ;
           updateCustomContainerDetail(c, c2);

        } else {
            // do nothing, we only adapt existing containers
        }

        return res;
    }

    private void updateCustomContainerDetail(CustomContainerRest ccr, CustomContainerDetail ccd){
        ccd.setIncomingTraffic(ccr.getIncomingTraffic());
        ccd.setOutgoingTraffic(ccr.getOutgoingTraffic());
        ccd.setCorruptionRate(ccr.getCorruptionRate());
        ccd.setLossRate(ccr.getLossRate());
        ccd.setDelayRate(ccr.getDelayRate());
        ccd.setCpuNumber(ccr.getCpuNumber());
        ccd.setCpu_freq(ccr.getCpu_freq());
        ccd.setMax_mem(ccr.getMax_mem());
        ccd.setMax_swap(ccr.getMax_swap());
        ccd.setIo_write_speed(ccr.getIo_write_speed());
        ccd.setIo_read_speed(ccr.getIo_read_speed());
   }
}
