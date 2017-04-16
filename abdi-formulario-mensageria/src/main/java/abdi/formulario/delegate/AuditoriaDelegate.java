package abdi.formulario.delegate;

import abdi.formulario.excecao.LocalizarObjetoException;
import abdi.formulario.fachada.IMensagemMBean;
import abdi.formulario.locator.EscolaServiceLocator;
import abdi.formulario.locator.Locator;
import abdi.formulario.mensageria.vo.MensagemAuditoria;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Rogerio.Rodrigues
 */
public class AuditoriaDelegate
        extends AplicacaoDelegate
        implements IAplicacaoDelegate<IMensagemMBean> {

    @Inject
    @Locator
    private EscolaServiceLocator locator;

    public List<MensagemAuditoria> listar() {
        try {
            return IMensagemMBean.class.cast(locator
                    .localizarAuditoriaBean())
                    .listar();
        } catch (LocalizarObjetoException ex) {
            Logger.getLogger(AuditoriaDelegate.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }

}
