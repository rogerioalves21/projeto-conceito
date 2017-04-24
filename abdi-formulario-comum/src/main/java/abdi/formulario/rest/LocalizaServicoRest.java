package abdi.formulario.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import abdi.formulario.dto.RequisicaoRestDTO;
import abdi.formulario.excecao.LocalizarObjetoException;
import abdi.formulario.log.AplicacaoLogger;

/**
 * Localiza serviços rest.
 * 
 * @author Rogerio.Rodrigues
 */
public class LocalizaServicoRest implements IRestServico {

    private static final String ERRO = "Erro ao obter o serviço rest";
    private final String provider;
    private final String path;

    /**
     * Construtor.
     * @param provider Provedor do resource.
     * 
     * @param path Nome do resource.
     */
    public LocalizaServicoRest(String provider, String path) {
        this.provider = provider;
        this.path = path;
    }

    /**
     * {@inheritDoc}
     */
    public Object consumir(RequisicaoRestDTO requisicao, Class< ? > tipoRetorno) throws LocalizarObjetoException {
        try {
            AplicacaoLogger.getLogger(getClass()).info( "Tentando localizar o rest");
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(this.provider).path(this.path);
            return target.request(MediaType.APPLICATION_JSON).post(Entity.entity(requisicao, MediaType.APPLICATION_JSON), tipoRetorno);
        } catch (Exception excecao) {
            AplicacaoLogger.getLogger(getClass()).error(ERRO, excecao);
            throw new LocalizarObjetoException(ERRO);
        }
    }

}
