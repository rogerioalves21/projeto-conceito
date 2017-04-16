package abdi.formulario.security;

import java.security.Principal;

public class UsuarioLogado implements Principal {

    private String name;
    private String login;
    private String senha;

    /**
     * SimplePrincipal erzeugen.
     *
     * @param name Name
     */
    public UsuarioLogado(String name) {
        if (name == null) {
            throw new NullPointerException("principal name must not be null");
        }

        this.name = name;
    }

    /**
     * Namen des UsuarioLogado liefern.
     *
     * @return Name
     */
    public String getName() {
        return this.name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        UsuarioLogado other = (UsuarioLogado) obj;
        return name.equals(other.name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" + this.name + "}";
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

}
