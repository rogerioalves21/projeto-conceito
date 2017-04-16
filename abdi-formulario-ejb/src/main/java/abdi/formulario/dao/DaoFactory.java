package abdi.formulario.dao;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

/**
 *
 * @author Rogerio.Rodrigues
 */
public class DaoFactory {

    private static final DaoFactory INSTANCIA = new DaoFactory();

    DaoFactory() {

    }

    public static DaoFactory get() {
        return INSTANCIA;
    }

    @Produces
    @DaoProducer
    public AlunoDao getAlunoDao(InjectionPoint injectionPoint) {
        return new AlunoDaoImpl();
    }

}
