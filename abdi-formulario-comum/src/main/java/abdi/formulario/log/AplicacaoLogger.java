package abdi.formulario.log;

import org.jboss.logging.Logger;

/**
 * Classe responsável por realizar o log da aplicação.
 * 
 * @author Rogério Alves Rodrigues
 */
public class AplicacaoLogger {

    private final Class< ? > clazz;

    /**
     * Singleton.
     */
    AplicacaoLogger(Class< ? > clazz) {
        this.clazz = clazz;
    }
    
    public static AplicacaoLogger getLogger(Class< ? > clazz) {
        return new AplicacaoLogger(clazz);
    }
    

    /**
     * Log do tipo [INFO].
     * 
     * @param mensagem Mensagem do log.
     */
    public void info(String mensagem) {
        Logger.getLogger(this.clazz).info(mensagem);
    }

    /**
     * Log do tipo [DEBUG].
     * 
     * @param mensagem Mensagem do log.
     */
    public void debug(String mensagem) {
        Logger.getLogger(this.clazz).debug(mensagem);
    }

    /**
     * Log do tipo [DEBUG].
     * 
     * @param mensagem Mensagem do log.
     * @param excecao Erro.
     */
    public void error(String mensagem, Throwable excecao) {
        Logger.getLogger(this.clazz).error(mensagem, excecao);
    }

}
