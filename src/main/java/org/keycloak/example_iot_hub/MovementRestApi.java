package org.keycloak.example_iot_hub;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.jboss.ejb3.annotation.SecurityDomain;

@SecurityDomain("keycloak")
@Stateless
@Path("/movement")
@PermitAll
public class MovementRestApi {
    @Inject
    DataHolder dataHolder;
    
    @POST
    @Path("/add/{sensorID}")
    @RolesAllowed({"motionSensor"})
    public Response addMovement(@PathParam("sensorID") String sensorID){
        dataHolder.addMovement(sensorID);
        return Response.status(201).build();
    }
    
    @GET
    @Path("/list")
    @Produces(APPLICATION_JSON)
    public List<DataEntry> getTemperatures(){
        return dataHolder.getMovements();
    }
}
