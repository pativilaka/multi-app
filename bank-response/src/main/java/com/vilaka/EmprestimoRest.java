package com.vilaka;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.concurrent.TimeUnit;

@Path("/emprestimo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmprestimoRest {

    @POST
    @Path("/aprovado")
    public Response prontaResposta(){
        return Response.ok("Crédito aprovado!").build();
    }

    @POST
    @Path("/pensando")
    public Response toPensando() throws InterruptedException{
        TimeUnit.SECONDS.sleep(3);
        return Response.ok("Pensei... Liberado!").build();
    }

    @POST
    @Path("/esgotado")
    public Response esgotado() throws InterruptedException{
        TimeUnit.SECONDS.sleep(5);
        return Response.status(Response.Status.REQUEST_TIMEOUT)
                .entity("Tempo esgotado!").build();
    }

}
