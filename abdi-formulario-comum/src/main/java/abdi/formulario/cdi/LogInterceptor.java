package abdi.formulario.cdi;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 * Classe responsavel por realizar o log de metodos e classes.
 * 
 * @author Rogerio.Rodrigues
 */
@Interceptor
@Logged
public class LogInterceptor {

    /**
     * 
     */
    @AroundInvoke
    public Object log(InvocationContext context) throws Exception {
        Logger
                .getLogger(getClass().getName())
                .log(
                        Level.INFO, "M\u00e9todo: {0} interceptado",
                        context.getMethod().getName()
                );
        return context.proceed();
    }
}
