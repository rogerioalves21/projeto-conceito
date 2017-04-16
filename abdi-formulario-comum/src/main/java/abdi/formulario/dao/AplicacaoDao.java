package abdi.formulario.dao;

import abdi.formulario.entidades.AplicacaoEntidade;
import abdi.formulario.dto.CriteriosConsultaDTO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Rogerio.Rodrigues
 * @param <T>
 */
public interface AplicacaoDao<T extends AplicacaoEntidade> {

    void setEntityManager(EntityManager manager);

    List<T> listar();

    void incluir(T entidade);
    
    T obter(Serializable chave);
    
    List<T> procurar(CriteriosConsultaDTO criterios);

}
