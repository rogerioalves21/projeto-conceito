package abdi.formulario.mensageria.consumer;

import abdi.formulario.dao.AuditoriaDao;
import abdi.formulario.mensageria.vo.MensagemAuditoria;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author Rogerio.Rodrigues
 */
/*
@MessageDriven(name = "Auditoria", activationConfig = {
    @ActivationConfigProperty(
            propertyName = "destination",
            propertyValue = "java:/jms/queue/Auditoria"
    )
    
})*/
public class AuditoriaConsumer implements MessageListener {

    @Inject
    private AuditoriaDao dao;

    @Override
    public void onMessage(Message message) {
        try {
            MensagemAuditoria login = (MensagemAuditoria) ((ObjectMessage) message).getObject();
            dao.incluir(login);
            dao.listar();
        } catch (JMSException ex) {
            Logger.getLogger(AuditoriaConsumer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
