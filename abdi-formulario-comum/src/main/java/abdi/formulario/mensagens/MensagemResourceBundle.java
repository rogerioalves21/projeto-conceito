package abdi.formulario.mensagens;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rogerio.Rodrigues
 */
public class MensagemResourceBundle {

    private static final MensagemResourceBundle INSTANCIA = new MensagemResourceBundle();
    private final String arquivo = "mensagens.properties";
    private final Properties prop = new Properties();

    MensagemResourceBundle() {
    }
    
    public static MensagemResourceBundle get() {
        return INSTANCIA;
    }
    
    public void carregarArquivo() {
        if (prop.isEmpty()) {
            InputStream input = getClass().getClassLoader().getResourceAsStream(arquivo);
            try {
                prop.load(input);
            } catch (IOException ex) {
                Logger.getLogger(MensagemResourceBundle.class.getName()).log(Level.SEVERE, null, ex);
                throw new RuntimeException("Erro ao carregar o arquivo de mensagens");
            }
        }
    }

    public String getMensagem(String chave) {
        carregarArquivo();
        return this.prop.getProperty(chave);
    }

}
