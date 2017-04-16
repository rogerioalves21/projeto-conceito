package abdi.formulario.fachada;

import abdi.formulario.mensageria.vo.MensagemAuditoria;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Rogerio.Rodrigues
 */
@Local
public interface IMensagemMBean extends IAplicacaoMBean {

    List<MensagemAuditoria> listar();

}
