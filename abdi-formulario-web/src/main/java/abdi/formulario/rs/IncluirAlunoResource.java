package abdi.formulario.rs;

import abdi.formulario.cdi.Logged;
import abdi.formulario.delegate.AlunoDelegate;
import abdi.formulario.excecao.AplicacaoException;
import abdi.formulario.log.AplicacaoLogger;
import abdi.formulario.mensagens.MensagemResourceBundle;
import abdi.formulario.mensagens.Mensagens;
import abdi.formulario.vo.AlunoVO;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Rest api para a inclusão de aluno.
 * 
 * @author Rogério Alves Rodrigues
 */
@Path("aluno/incluir")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class IncluirAlunoResource {

    @Inject
    private AlunoDelegate delegate;

    /**
     * Inclui o aluno.
     * 
     * @param aluno Dados do aluno.
     * @return Mensagem de retorno para a tela.
     */
    @POST
    @Logged
    public Mensagem incluir(AlunoVO aluno) {
        try {
            validar(aluno);
            abdi.entidades.Aluno novo = new abdi.entidades.Aluno();
            novo.setNome(aluno.getNome());
            delegate.incluir(novo);
            return new Mensagem("Sucesso!");
        } catch (AplicacaoException excecao) {
            AplicacaoLogger.getLogger(getClass()).error("Erro ao incluir o aluno", excecao);
            return new Mensagem(excecao.getMessage());
        }
    }

    /**
     * Valida se os dados obrigatórios foram preenchidos.
     * 
     * @param aluno Dados do aluno.
     * @throws AplicacaoException Erro.
     */
    private void validar(AlunoVO aluno) throws AplicacaoException {
        if (aluno == null || aluno.getNome() == null || aluno.getNome().trim().equals("")) {
            throw new AplicacaoException(MensagemResourceBundle.get().getMensagem(Mensagens.MSG02.name()));
        }
    }

}
