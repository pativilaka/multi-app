package com.vilaka;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.concurrent.TimeoutException;


@Path("/clientes")
public class ClienteRest {

    @RestClient
    BankClient bankClient;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response mandaRequest() {
        try {
            String result = bankClient.prontaResposta();
            return Response.ok("Retorno: " + result).build();
        } catch (ProcessingException e) {
            if (e.getCause() instanceof TimeoutException) {
                return Response.status(Response.Status.REQUEST_TIMEOUT)
                        .entity("Tempo excedido!")
                        .build();
            } else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity("Ocorreu um erro no processador.")
                        .build();
            }
        }
    }
}
