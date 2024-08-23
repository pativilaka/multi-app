package com.vilaka.exceptions;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ExceptionMapperProvider implements ExceptionMapper<RuntimeException> {
    @Override
    public Response toResponse(RuntimeException e) {

        if (e instanceof FiveSecondsExcpetion){
            return Response.status(Response.Status.REQUEST_TIMEOUT)
                    .entity(e.getMessage()).build();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(e.getMessage()).build();
    }
}
