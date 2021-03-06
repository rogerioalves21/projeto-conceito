package abdi.formulario.fachada;

import abdi.entidades.Aluno;
import abdi.formulario.dto.CriteriosConsultaDTO;
import abdi.formulario.excecao.AplicacaoException;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Rogerio.Rodrigues
 */
@Remote
public interface IAlunoMBean extends IAplicacaoMBean {

    String ola(String nome);

    List<Aluno> listar();

    void incluir(Aluno aluno) throws AplicacaoException;

    List<Aluno> procurar(CriteriosConsultaDTO criterios);
}
