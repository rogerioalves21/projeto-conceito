package br.com.sicoob.sisbr.resource;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("rest")
public class Aplicacao extends Application {

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Class< ? >> getClasses() {
        Set<Class< ? >> classes = new HashSet<Class< ? >>();
        classes.add(HelloWorld.class);
        return classes;
    }
}
