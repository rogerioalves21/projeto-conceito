package abdi.formulario.locator;

import abdi.formulario.mensagens.MensagemResourceBundle;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe responsável por localizar e devolver as mensagens.
 *
 * @author Rogerio.Rodrigues
 */
public class LocatorResourceBundle {

    private static final LocatorResourceBundle INSTANCIA = new LocatorResourceBundle();
    private final String arquivo = "locator.properties";
    private final Properties prop = new Properties();

    LocatorResourceBundle() {
    }

    public static LocatorResourceBundle get() {
        return INSTANCIA;
    }

    /**
     * Realiza a carga do arquivo de propriedades.
     */
    public void carregarArquivo() {
        if (prop.isEmpty()) {
            InputStream input = getClass().getClassLoader().getResourceAsStream(arquivo);
            try {
                prop.load(input);
            } catch (IOException ex) {
                Logger.getLogger(MensagemResourceBundle.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao carregar o arquivo de locator");
            }
        }
    }

    public String getJndi(String chave) {
        carregarArquivo();
        return this.prop.getProperty(chave);
    }
}
