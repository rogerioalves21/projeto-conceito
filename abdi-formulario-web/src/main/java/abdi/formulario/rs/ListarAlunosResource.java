package abdi.formulario.rs;

import abdi.entidades.Aluno;
import abdi.formulario.delegate.AlunoDelegate;
import abdi.formulario.dto.RequisicaoRestDTO;
import abdi.formulario.excecao.LocalizarObjetoException;
import abdi.formulario.locator.AplicacaoServiceLocator;
import abdi.formulario.rest.IRestServico;

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

    @Inject
    private AlunoDelegate alunoDelegate;

    @GET
    public List<Aluno> listar() {
        try {
            AplicacaoServiceLocator locator = new AplicacaoServiceLocator();
            IRestServico restServico = locator.localizarRest("rest:http://localhost:8080::/abdi-formulario-web/escola/auditoria");
            RequisicaoRestDTO requisicao = new RequisicaoRestDTO();
            restServico.consumir(requisicao, List.class);
        } catch (LocalizarObjetoException excecao) {
            excecao.printStackTrace();
        }
        return alunoDelegate.listar();
    }

}
