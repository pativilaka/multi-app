package com.vilaka;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/randomico")
@RegisterRestClient(configKey = "bank-api")
@Produces(MediaType.APPLICATION_JSON)
@ApplicationScoped
public interface BankClient {

    @GET
    String retorno();


}
