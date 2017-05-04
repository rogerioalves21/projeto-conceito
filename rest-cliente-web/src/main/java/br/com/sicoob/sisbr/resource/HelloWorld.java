package br.com.sicoob.sisbr.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.sicoob.sisbr.ReqRestDTO;

@Path("/hello")
public class HelloWorld {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String ola(MeuNome nome) {
        return "ola ".concat(nome.getNome());
    }
    
}
