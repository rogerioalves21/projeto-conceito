package abdi.formulario.config;

import abdi.formulario.rs.IncluirAlunoResource;
import abdi.formulario.rs.ListaAuditoriaResource;
import abdi.formulario.rs.ListarAlunosResource;
import abdi.formulario.rs.ProcurarAlunosResource;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;



/**
 * Resources disponíveis.
 * 
 * @author Rogério Alves Rodrigues
 */
@ApplicationPath("escola")
public class Aplicacao extends Application {

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(ListarAlunosResource.class);
        classes.add(IncluirAlunoResource.class);
        classes.add(ProcurarAlunosResource.class);
        classes.add(ListaAuditoriaResource.class);
      
        return classes;
    }

}
