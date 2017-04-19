package abdi.formulario.mensagens;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import abdi.formulario.log.AplicacaoLogger;

/**
 * Classe responsável por obter as mensagens do sistema.
 * 
 * @author Rogerio.Rodrigues
 */
public class MensagemResourceBundle {

    private static final MensagemResourceBundle INSTANCIA = new MensagemResourceBundle();
    private static final String                        ARQUIVO   = "mensagens.properties";
    private static final Properties                    PROP      = new Properties();
    private static final String                 ERRO      = "Erro ao carregar o arquivo de mensagens";

    /**
     * Singleton.
     */
    MensagemResourceBundle() {
    }
    
    /**
     * Retorna a instância.
     * 
     * @return {@code MensagemResourceBundle}.
     */
    public static MensagemResourceBundle get() {
        return INSTANCIA;
    }

    public void carregarArquivo() {
        if (PROP.isEmpty()) {
            InputStream input = getClass().getClassLoader().getResourceAsStream(ARQUIVO);
            try {
                PROP.load(input);
            } catch (IOException excecao) {
                AplicacaoLogger.getLogger(getClass()).error(ERRO, excecao);
                throw new RuntimeException(ERRO);
            }
        }
    }

    public String getMensagem(String chave) {
        carregarArquivo();
        return this.PROP.getProperty(chave);
    }

}
