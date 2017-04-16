package abdi.formulario.rs;

import abdi.entidades.Aluno;
import abdi.formulario.delegate.AlunoDelegate;
import abdi.formulario.rest.LocalizaServicoRest;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Rogerio.Rodrigues
 */
@Path("/alunos")
@Produces({MediaType.APPLICATION_JSON})
public class ListarAlunosResource {
    private static final long serialVersionUID = -1903885930512660931L;

    @Inject
    private AlunoDelegate alunoDelegate;

    @GET
    public List<Aluno> listar() {
        LocalizaServicoRest rest = new LocalizaServicoRest();
        rest.teste();
        return alunoDelegate.listar();
    }

}
