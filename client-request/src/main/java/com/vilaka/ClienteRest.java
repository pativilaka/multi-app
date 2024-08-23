package com.vilaka;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;


    @Path("/clientes")
    public class ClienteRest {

        @RestClient
        BankClient bankClient;

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public Response mandaRequest() {
            try {
                String result = bankClient.retorno();
                return Response.ok("Resultado: " + result).build();
            } catch (WebApplicationException e) {

                int statusCode = e.getResponse().getStatus();
                String errorMsg = e.getResponse().hasEntity() ?
                        e.getResponse().readEntity(String.class) :
                        "Mensagem de erro indisponível";

                if (statusCode == Response.Status.REQUEST_TIMEOUT.getStatusCode()){
                    return Response.status(Response.Status.REQUEST_TIMEOUT)
                            .entity("Erro: " + errorMsg).build();
                }

                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity("Erro: " + errorMsg).build();

            }
        }
    }
