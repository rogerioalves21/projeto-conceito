package abdi.formulario.rmi;

import abdi.formulario.excecao.LocalizarObjetoException;
import abdi.formulario.fachada.IAplicacaoMBean;
import abdi.formulario.locator.AplicacaoServiceLocator;
import abdi.formulario.log.AplicacaoLogger;

import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Classe responsavel por fazer o lookup de ejbs.
 * 
 * @author Rogerio Alves Rodrigues
 */
public class LocalizaServicoEjb {

    /**
     * Localiza um serviço ejb.
     *
     * @param jndi Nome do serviço.
     * @return Interface.
     * @throws LocalizarObjetoException Erro ao localizar o serviço.
     */
    public IAplicacaoMBean localizar(String jndi)
        throws LocalizarObjetoException {
        InitialContext ctx;
        try {
            ctx = new InitialContext();
            AplicacaoLogger.getLogger(getClass())
                .info("Localizando o objeto ".concat(jndi));
            return (IAplicacaoMBean) ctx.lookup(jndi.replaceAll(AplicacaoServiceLocator.EJB, ""));
        } catch (NamingException excecao) {
            throw new LocalizarObjetoException(excecao);
        }
    }

    
}
