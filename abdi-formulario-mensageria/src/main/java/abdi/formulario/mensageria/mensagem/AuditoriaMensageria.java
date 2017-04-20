package abdi.formulario.mensageria.mensagem;

import abdi.formulario.mensageria.vo.MensagemAuditoria;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Rogerio.Rodrigues
 */
public class AuditoriaMensageria implements Serializable {
    private static final long serialVersionUID = 9023492761239834551L;

    private ConnectionFactory connectionFactory;
    private Destination       destination;

    /**
     * Envia a mensagem de auditoria para a fila JMS.
     * 
     * @param mensagem Mensagem a ser enviada.
     */
    public void enviarMensagem(MensagemAuditoria mensagem) {
        try {
            Context ctx = new InitialContext();
            connectionFactory = (ConnectionFactory)ctx.lookup("java:/AutidoriaConnectionFactory");
            destination = (Destination)ctx.lookup("java:/jms/queue/Auditoria");
            QueueConnection connection = (QueueConnection)connectionFactory.createConnection();
            QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(destination);
            session.createObjectMessage(mensagem);
            producer.send(session.createObjectMessage(mensagem));
            producer.close();
            session.close();
            connection.close();
        } catch (NamingException | JMSException ex) {
            Logger.getLogger(AuditoriaMensageria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MensagemAuditoria criarMensagem(String descricao) {
        MensagemAuditoria mensagem = new MensagemAuditoria();
        mensagem.setConteudo(descricao);
        return mensagem;
    }

    public class Mensagem implements Serializable {
        private static final long serialVersionUID = 7046278335906061906L;

        private String            descricao;
        private String            id;

        /**
         * @return the descricao
         */
        public String getDescricao() {
            return descricao;
        }

        /**
         * @param descricao the descricao to set
         */
        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        /**
         * @return the id
         */
        public String getId() {
            return id;
        }

        /**
         * @param id the id to set
         */
        public void setId(String id) {
            this.id = id;
        }

        public String toString() {
            return this.descricao;
        }

    }

}
