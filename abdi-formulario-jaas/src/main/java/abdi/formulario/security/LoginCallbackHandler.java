package abdi.formulario.security;

import java.io.IOException;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

/**
 *
 * @author Rogerio.Rodrigues
 */
public class LoginCallbackHandler implements CallbackHandler {

    private final String login;
    private final String senha;

    public LoginCallbackHandler(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        for (int i = 0; i < callbacks.length; i++) {
            if (callbacks[i] instanceof NameCallback) {
                ((NameCallback) callbacks[i]).setName(this.login);
            } else if (callbacks[i] instanceof PasswordCallback) {
                ((PasswordCallback) callbacks[i]).setPassword(this.senha.toCharArray());
            } else {
                throw new UnsupportedCallbackException(callbacks[i]);
            }
        }
    }

}
