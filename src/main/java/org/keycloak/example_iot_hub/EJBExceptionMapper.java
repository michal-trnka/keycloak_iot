package org.keycloak.example_iot_hub;

import javax.ejb.EJBAccessException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EJBExceptionMapper implements ExceptionMapper<EJBAccessException>{

    public Response toResponse(EJBAccessException exception) {
        return Response.status(403).build();
    }
}
