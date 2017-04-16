package abdi.formulario.locator;

import javax.enterprise.inject.Produces;

/**
 *
 * @author Rogerio.Rodrigues
 */
public class FabricaLocator {
    
    FabricaLocator() {
        
    }
    
    @Produces
    @Locator
    public EscolaServiceLocator obter() {
        return new EscolaServiceLocator();
    }
    
}
