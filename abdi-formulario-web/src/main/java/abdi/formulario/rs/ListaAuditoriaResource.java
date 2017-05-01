package abdi.formulario.rs;

import abdi.formulario.delegate.AuditoriaDelegate;
import abdi.formulario.dto.RequisicaoRestDTO;
import abdi.formulario.log.AplicacaoLogger;
import abdi.formulario.mensageria.vo.MensagemAuditoria;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Rogerio.Rodrigues
 */
@Path("")
public class ListaAuditoriaResource {

    @Inject
    private AuditoriaDelegate delegate;
    
    @Context
    private HttpServletRequest request;
    
    @Context
    private HttpServletResponse response;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/auditorias")
    public List<MensagemAuditoria> obter(RequisicaoRestDTO requisicao) {
        return delegate.listar();
    }

    @Path("/auditoria")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Dados> listar() {
        List<Dados> dadosList = new ArrayList<Dados>();

        try {
            if (request != null) {
                AplicacaoLogger.getLogger(getClass()).info(request.getUserPrincipal().toString());
                request.authenticate(response);
            }
        } catch (Exception excecao) {
            AplicacaoLogger.getLogger(getClass()).error("Erro ao autenticar o usuario", excecao);
        }


        List<MensagemAuditoria> mensagens = delegate.listar();

        for (MensagemAuditoria mensagem : mensagens) {
            Dados dados = new Gson().fromJson(mensagem.getConteudo(), Dados.class);
            dadosList.add(dados);
        }

        return dadosList;
    }

    public class Dados {

        private String login;
        private String dataHora;

        public Dados(String login, String dataHora) {
            this.login = login;
            this.dataHora = dataHora;
        }

        /**
         * @return the login
         */
        public String getLogin() {
            return login;
        }

        /**
         * @return the dataHora
         */
        public String getDataHora() {
            return dataHora;
        }

        /**
         * @param login the login to set
         */
        public void setLogin(String login) {
            this.login = login;
        }

        /**
         * @param dataHora the dataHora to set
         */
        public void setDataHora(String dataHora) {
            this.dataHora = dataHora;
        }

    }

}
