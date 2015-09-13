package org.keycloak.example_iot_hub;

import java.util.List;

import org.jboss.ejb3.annotation.SecurityDomain;

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

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@SecurityDomain("keycloak")
@Stateless
@Path("/temperature")
@PermitAll
public class TemperatureRestApi
{
    @Inject
    DataHolder dataHolder;

    @POST
    @Path("/add/{temperature}")
    @RolesAllowed({"temperatureSensor"})
    public Response measureTemp(@PathParam("temperature") double temperature){
        dataHolder.addTemperature(temperature);
        return Response.status(201).build();
        
    }
    
    @GET
    @Path("/list")
    @Produces(APPLICATION_JSON)
    public List<DataEntry> getTemperatures(){
        return dataHolder.getTemperatures();
    }
    
}
