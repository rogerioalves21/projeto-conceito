/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abdi.formulario.excecao;

import javax.naming.NamingException;

/**
 *
 * @author Rogerio.Rodrigues
 */
public class LocalizarObjetoException extends Exception {
    private static final long serialVersionUID = -7833532467941638260L;

    public LocalizarObjetoException(String mensagem) {
        super(mensagem);
    }

    public LocalizarObjetoException(NamingException excecao) {
        super(excecao);
    }
    
}
