package abdi.formulario.security;

import abdi.formulario.mensageria.mensagem.AuditoriaMensageria;
import java.io.IOException;
import java.security.Principal;
import java.security.acl.Group;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

/**
 *
 * @author Rogerio.Rodrigues
 */
public class AplicacaoLoginModule implements LoginModule {

    private Subject subject;
    private CallbackHandler callbackHandler;
    private Map sharedState;
    private Map options;
    protected UsuarioLogado identity;
    private boolean succeeded = false;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        this.subject = subject;
        this.callbackHandler = callbackHandler;
        this.sharedState = sharedState;
        this.options = options;
    }

    @Override
    public boolean login() throws LoginException {
        if (callbackHandler == null) {
            throw new LoginException("Oops, callbackHandler is null");
        }

        Callback[] callbacks = new Callback[2];
        callbacks[0] = new NameCallback("name:");
        callbacks[1] = new PasswordCallback("password:", false);

        try {
            callbackHandler.handle(callbacks);
        } catch (IOException e) {
            throw new LoginException("Oops, IOException calling handle on callbackHandler");
        } catch (UnsupportedCallbackException e) {
            throw new LoginException("Oops, UnsupportedCallbackException calling handle on callbackHandler");
        }

        NameCallback nameCallback = (NameCallback) callbacks[0];
        PasswordCallback passwordCallback = (PasswordCallback) callbacks[1];

        String name = nameCallback.getName();
        String password = new String(passwordCallback.getPassword());

        if ("rogerio.rodrigues".equals(name) && "Sicoob123".equals(password)) {
            try {
                AuditoriaMensageria mensageria = new AuditoriaMensageria();
                mensageria.enviarMensagem(mensageria.criarMensagem(name));
            } catch (Exception excecao) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Usuário logado", excecao);
            }
            succeeded = true;
            identity = new UsuarioLogado(name);
            identity.setLogin(name);
            identity.setSenha(password);
            subject.getPrincipals().add(identity);
            subject.getPublicCredentials().add(identity);
            return succeeded;
        } else {
            succeeded = false;
            throw new FailedLoginException("Sorry! No login for you.");
        }
    }

    @Override
    public boolean commit() throws LoginException {
        Group group = new AplicacaoGrupo("Roles");
        Principal role = new UsuarioLogado("super-user");
        Principal role2 = new UsuarioLogado("user");
        group.addMember(role);
        group.addMember(role2);
        subject.getPrincipals().add(group);
        return true;
    }

    @Override
    public boolean abort() throws LoginException {
        subject = null;
        return true;
    }

    @Override
    public boolean logout() throws LoginException {
        return true;
    }

}
