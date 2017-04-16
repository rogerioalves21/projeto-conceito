/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abdi.formulario.locator;

import abdi.formulario.excecao.LocalizarObjetoException;
import abdi.formulario.fachada.IAplicacaoMBean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Rogerio.Rodrigues
 */
public class AplicacaoServiceLocator {

    private static final String EJB = "ejb:";
    
    public IAplicacaoMBean localizar(String jndi) throws LocalizarObjetoException {
        String prefixo = jndi.substring(0, 4);
        if (prefixo.equals(EJB)) {
            return localizarEjb(jndi);
        }
        return null;
    }

    private IAplicacaoMBean localizarEjb(String jndi) throws LocalizarObjetoException {
        InitialContext ctx;
        try {
            ctx = new InitialContext();
            Logger.getLogger(getClass().getName()).log(Level.INFO, "Localizando o objeto {0}", jndi);
            return (IAplicacaoMBean) ctx.lookup(jndi.replaceAll(EJB, ""));
        } catch (NamingException excecao) {
            throw new LocalizarObjetoException(excecao);
        }
    }

}
