package abdi.formulario.locator;

import abdi.formulario.excecao.LocalizarObjetoException;
import abdi.formulario.fachada.IAplicacaoMBean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Classe responsável por localizar objetos e serviços.
 *
 * @author Rogerio.Rodrigues
 */
public class AplicacaoServiceLocator {

    protected static final String EJB = "ejb:";
    protected static final String REST = "rest:";

    /**
     * Localiza um serviço.
     *
     * @param jndi Nome do serviço.
     * @return Interface do serviço.
     * @throws LocalizarObjetoException Erro ao localizar o objeto.
     */
    public IAplicacaoMBean localizar(String jndi) throws LocalizarObjetoException {
        String prefixo = jndi.substring(0, 4);
        if (prefixo.equals(EJB)) {
            return localizarEjb(jndi);
        } else if (prefixo.equals(REST)) {
            return localizarRest(jndi);            
        }
        return null;
    }
    
    /**
     * Localiza um servico rest.
     * 
     * @param jndi Nome do servico.
     * @return Interface para consumo.
     * @throws LocalizarObjetoException Erro ao localizar o objeto.
     */
    private IAplicacaoMBean localizarRest(String jndi)
        throws LocalizarObjetoException {
        return null;
    }

    /**
     * Localiza um serviço ejb.
     *
     * @param jndi Nome do serviço.
     * @return Interface.
     * @throws LocalizarObjetoException Erro ao localizar o serviço.
     */
    private IAplicacaoMBean localizarEjb(String jndi)
        throws LocalizarObjetoException {
        InitialContext ctx;
        try {
            ctx = new InitialContext();
            Logger.getLogger(getClass().getName())
                .log(Level.INFO, "Localizando o objeto {0}", jndi);
            return (IAplicacaoMBean) ctx.lookup(jndi.replaceAll(EJB, ""));
        } catch (NamingException excecao) {
            throw new LocalizarObjetoException(excecao);
        }
    }

}
