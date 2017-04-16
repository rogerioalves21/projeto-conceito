package abdi.formulario.fachada;

import abdi.formulario.cdi.Logged;
import abdi.formulario.dao.AuditoriaDao;
import abdi.formulario.mensageria.vo.MensagemAuditoria;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

/**
 *
 * @author Rogerio.Rodrigues
 */
@Stateless
public class MensagemMBean extends AplicacaoMBean
        implements IMensagemMBean {

    @Inject
    private AuditoriaDao dao;

    @Logged
    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<MensagemAuditoria> listar() {
        return dao.listar();
    }

}
