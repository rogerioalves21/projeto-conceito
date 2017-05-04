package br.com.sicoob.sisbr.cliente;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.moxy.json.MoxyJsonFeature;

import br.com.sicoob.sisbr.ReqRestDTO;

public class SicoobRestServico {

    public String consumir(ReqRestDTO requisicao) {
        Client client = ClientBuilder.newClient();
        client.register(MoxyJsonFeature.class);
        WebTarget target = client.target("http://localhost:8080/rest-cliente-web-1.0").path("rest/hello");
        return target.request(MediaType.TEXT_PLAIN_TYPE).post(Entity.entity(requisicao, MediaType.APPLICATION_JSON_TYPE), String.class);
    }

}
