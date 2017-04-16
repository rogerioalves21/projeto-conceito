package abdi.formulario.locator;

import abdi.formulario.excecao.LocalizarObjetoException;
import abdi.formulario.fachada.IAplicacaoMBean;

/**
 *
 * @author Rogerio.Rodrigues
 */
public class EscolaServiceLocator extends AplicacaoServiceLocator {

    public IAplicacaoMBean localizarAlunoBean() throws LocalizarObjetoException {
        return (IAplicacaoMBean) localizar(
                LocatorResourceBundle
                .get()
                .getJndi(Jndi.ALUNOMBEAN.getJndiName())
        );
    }
    
     public IAplicacaoMBean localizarAuditoriaBean() throws LocalizarObjetoException {
        return (IAplicacaoMBean) localizar(
                LocatorResourceBundle
                .get()
                .getJndi(Jndi.AUDITORIAMBEAN.getJndiName())
        );
    }

}
