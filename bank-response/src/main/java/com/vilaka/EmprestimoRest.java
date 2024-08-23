package com.vilaka;

import com.vilaka.exceptions.FiveSecondsExcpetion;
import com.vilaka.exceptions.QualquerErroException;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Path("/randomico")
@Produces(MediaType.APPLICATION_JSON)
public class EmprestimoRest {

    private static final Random random = new Random();

    @GET
    public Response retorno(){

        try{
            int result = random.nextInt(3) + 1;

            if (result == 1){
                return Response.ok("Retorno imediato!").build();
            }

            if (result == 2){
                TimeUnit.SECONDS.sleep(3);
                return Response.ok("Esperei 3 segundos...").build();
            }

            TimeUnit.SECONDS.sleep(5);
            throw new FiveSecondsExcpetion("Esperei 5 segundos e lancei uma exceção.");

        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            throw  new QualquerErroException("A espera foi interrompida.");
        }

    }
}
