package abdi.formulario.rs;

import abdi.formulario.delegate.AuditoriaDelegate;
import abdi.formulario.mensageria.vo.MensagemAuditoria;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Rogerio.Rodrigues
 */
@Path("/auditoria")
@Produces({MediaType.APPLICATION_JSON})
public class ListaAuditoriaResource {
    
    @Inject
    private AuditoriaDelegate delegate;
    
    public List<MensagemAuditoria> listar() {
        return delegate.listar();
    }
    
}
