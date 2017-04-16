package abdi.formulario.rs;

import abdi.entidades.Aluno;
import abdi.formulario.delegate.AlunoDelegate;
import abdi.formulario.dto.CriteriosConsultaDTO;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Rogerio.Rodrigues
 */
@Path("/aluno/{nome}")
public class ProcurarAlunosResource {

    @Inject
    AlunoDelegate delegate;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.TEXT_PLAIN})
    public List<Aluno> procurar(@PathParam("nome") String nome) {
        CriteriosConsultaDTO dto = new CriteriosConsultaDTO();
        dto.getDados().put("nome", nome.toUpperCase());
        return delegate.procurar(dto);
    }

}
