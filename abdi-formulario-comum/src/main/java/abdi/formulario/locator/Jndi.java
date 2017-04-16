package abdi.formulario.locator;

/**
 *
 * @author Rogerio.Rodrigues
 */
public enum Jndi {

    ALUNOMBEAN("alunombean");

    private final String jndi;

    Jndi(String jndi) {
        this.jndi = jndi;
    }

    public String getJndiName() {
        return this.jndi;
    }
}
