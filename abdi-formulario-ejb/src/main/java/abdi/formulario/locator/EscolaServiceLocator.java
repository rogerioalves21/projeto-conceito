/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abdi.formulario.locator;

import abdi.formulario.excecao.LocalizarObjetoException;
import abdi.formulario.fachada.IAlunoMBean;

/**
 *
 * @author Rogerio.Rodrigues
 */
public class EscolaServiceLocator extends AplicacaoServiceLocator {

    public IAlunoMBean localizarAlunoBean() throws LocalizarObjetoException {
        return (IAlunoMBean) localizar(
                LocatorResourceBundle
                .get()
                .getJndi(Jndi.ALUNOMBEAN.getJndiName())
        );
    }

}
