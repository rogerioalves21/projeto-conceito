package br.com.sicoob.sisbr.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.moxy.json.MoxyJsonFeature;

@Stateless
public class RestClientServicoEJB implements IRestClientServico {

    private static final String PROVIDER = "http://localhost:8080/rest-cliente-web";
    private static final String PATH = "rest/hello";
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public String consumir(ReqRestDTO requisicao) {
      System.out.println("Entrei no ejb!");
        Client client = ClientBuilder.newClient();
        client.register(MoxyJsonFeature.class);
        WebTarget target = client.target(PROVIDER).path(PATH);
        return target.request(MediaType.TEXT_PLAIN_TYPE).post(Entity.entity(requisicao, MediaType.APPLICATION_JSON_TYPE), String.class);
    }

}
