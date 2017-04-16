package abdi.formulario.delegate;

import abdi.entidades.Aluno;
import abdi.formulario.dto.CriteriosConsultaDTO;
import abdi.formulario.excecao.AplicacaoException;
import abdi.formulario.excecao.LocalizarObjetoException;
import abdi.formulario.fachada.IAlunoMBean;
import abdi.formulario.locator.EscolaServiceLocator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Rogerio.Rodrigues
 */
public class AlunoDelegate
        extends AplicacaoDelegate
        implements IAplicacaoDelegate<IAlunoMBean> {

    @Inject
    EscolaServiceLocator locator;

    public void incluir(Aluno aluno) throws AplicacaoException {
        try {
            locator
                    .localizarAlunoBean()
                    .incluir(aluno);
        } catch (LocalizarObjetoException ex) {
            Logger.getLogger(AlunoDelegate.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }

    public List<Aluno> listar() {
        try {
            return locator
                    .localizarAlunoBean()
                    .listar();
        } catch (LocalizarObjetoException ex) {
            Logger.getLogger(AlunoDelegate.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }

    public List<Aluno> procurar(CriteriosConsultaDTO criterios) {
        try {
            return locator
                    .localizarAlunoBean()
                    .procurar(criterios);
        } catch (LocalizarObjetoException ex) {
            Logger.getLogger(AlunoDelegate.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }

}
