package abdi.formulario.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rogerio.Rodrigues
 */
public class CriteriosConsultaDTO implements Serializable {

    private static final long serialVersionUID = -2729040982583930617L;

    private Map<String, Object> dados = new HashMap<>();

    /**
     * @return the dados
     */
    public Map<String, Object> getDados() {
        return dados;
    }

    /**
     * @param dados the dados to set
     */
    public void setDados(Map<String, Object> dados) {
        this.dados = dados;
    }

}
