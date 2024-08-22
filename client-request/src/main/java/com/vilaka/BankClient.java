package com.vilaka;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/emprestimo")
@RegisterRestClient(configKey = "bank-api")
@ApplicationScoped
public interface BankClient {

    @POST
    @Path("/aprovado")
    String prontaResposta();

    @POST
    @Path("/pensando")
    String toPensando();

    @POST
    @Path("/esgotado")
    String esgotado();

}
