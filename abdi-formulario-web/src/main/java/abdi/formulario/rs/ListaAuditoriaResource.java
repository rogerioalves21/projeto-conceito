package abdi.formulario.rs;

import abdi.formulario.delegate.AuditoriaDelegate;
import abdi.formulario.dto.RequisicaoRestDTO;
import abdi.formulario.mensageria.vo.MensagemAuditoria;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Rogerio.Rodrigues
 */
@Path("")
public class ListaAuditoriaResource {

    @Inject
    private AuditoriaDelegate delegate;

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
    public List<MensagemAuditoria> listar() {
        return delegate.listar();
    }

}
