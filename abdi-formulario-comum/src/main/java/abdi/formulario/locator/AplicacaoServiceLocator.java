package abdi.formulario.locator;

import abdi.formulario.excecao.LocalizarObjetoException;
import abdi.formulario.fachada.IAplicacaoMBean;
import abdi.formulario.rest.IRestServico;
import abdi.formulario.rest.LocalizaServicoRest;
import abdi.formulario.rmi.LocalizaServicoEjb;

/**
 * Classe responsável por localizar objetos e serviços.
 *
 * @author Rogerio.Rodrigues
 */
public class AplicacaoServiceLocator {

    public static final String EJB = "ejb:";
    public static final String REST = "rest:";

    /**
     * Localiza um servico rest.
     * 
     * @param jndi Nome do servico.
     * @return Interface para consumo.
     * @throws LocalizarObjetoException Erro ao localizar o objeto.
     */
    public IRestServico localizarRest(String jndi)
        throws LocalizarObjetoException {
        String providerPath = jndi.replaceAll(AplicacaoServiceLocator.REST, "");
        String[] caminho = providerPath.split("::");
        IRestServico servico = new LocalizaServicoRest(caminho[0], caminho[1]);
        return servico;
    }

    /**
     * Localiza um serviço ejb.
     *
     * @param jndi Nome do serviço.
     * @return Interface.
     * @throws LocalizarObjetoException Erro ao localizar o serviço.
     */
    public IAplicacaoMBean localizarEjb(String jndi)
        throws LocalizarObjetoException {
        LocalizaServicoEjb locator = new LocalizaServicoEjb();
        return locator.localizar(jndi);
    }

}
