package abdi.formulario.locator;

import abdi.formulario.excecao.LocalizarObjetoException;
import abdi.formulario.fachada.IAlunoMBean;

/**
 *
 * @author Rogerio.Rodrigues
 */
public class EscolaServiceLocator extends AplicacaoServiceLocator {

    public IAlunoMBean localizarAlunoBean() throws LocalizarObjetoException {
        return (IAlunoMBean) localizar(
                LocatorResourceBundle
                .get()
                .getJndi(Jndi.ALUNOMBEAN.getJndiName())
        );
    }

}
