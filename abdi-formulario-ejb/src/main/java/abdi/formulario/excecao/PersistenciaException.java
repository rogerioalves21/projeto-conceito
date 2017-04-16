/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abdi.formulario.excecao;

/**
 *
 * @author Rogerio.Rodrigues
 */
public class PersistenciaException extends RuntimeException {

    private static final long serialVersionUID = -6173675879692155277L;

    public PersistenciaException(String mensagem) {
        super(mensagem);
    }
    public PersistenciaException(Throwable e) {
        super(e);
    }
}
