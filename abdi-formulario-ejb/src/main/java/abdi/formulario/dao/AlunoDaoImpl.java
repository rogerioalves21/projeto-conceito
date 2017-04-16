package abdi.formulario.dao;

import abdi.entidades.Aluno;
import abdi.formulario.dto.CriteriosConsultaDTO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author Rogerio.Rodrigues
 */
public class AlunoDaoImpl extends AplicacaoDaoImpl
        implements AlunoDao {

    public AlunoDaoImpl() {
    }

    @Override
    public List<Aluno> listar() {
        Query query = getEntityManager().createNamedQuery("LISTAR");
        return query.getResultList();
    }

    @Override
    public void incluir(Aluno aluno) {
        getEntityManager().persist(aluno);
        getEntityManager().flush();
    }

    @Override
    public Aluno obter(Serializable chave) {
        return getEntityManager().find(Aluno.class, chave);
    }

    @Override
    public List<Aluno> procurar(CriteriosConsultaDTO criterios) {
        String hql = "select aluno from abdi.formulario.entidades.Aluno aluno where aluno.nome like :nome";
        Query query = getEntityManager().createQuery(hql);
        query.setParameter("nome", criterios.getDados().get("nome").toString().concat("%"));
        return query.getResultList();
    }

}
