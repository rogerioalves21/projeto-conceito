package abdi.formulario.locator;

import abdi.formulario.log.AplicacaoLogger;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Classe responsável por localizar e devolver as mensagens.
 *
 * @author Rogerio.Rodrigues
 */
public class LocatorResourceBundle {

    private static final LocatorResourceBundle INSTANCIA = new LocatorResourceBundle();
    private final String arquivo = "locator.properties";
    private final Properties prop = new Properties();
    private static final String ERRO = "Erro ao carregar o arquivo de locator";

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
            } catch (IOException excecao) {
                AplicacaoLogger.getLogger(getClass()).error(ERRO, excecao);
                throw new RuntimeException(ERRO);
            }
        }
    }

    public String getJndi(String chave) {
        carregarArquivo();
        return this.prop.getProperty(chave);
    }
}
