package org.diverse.container.manager.rest.resource ;



import org.diverse.container.manager.core.model.CustomContainerDetail;
import org.diverse.container.manager.rest.dao.CustomContainerDAO;
import org.diverse.container.manager.rest.model.CustomContainerRest;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBElement;
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
