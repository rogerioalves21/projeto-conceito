package abdi.formulario.fachada;

import abdi.entidades.Aluno;
import abdi.formulario.cdi.Logged;
import abdi.formulario.dao.AlunoDao;
import abdi.formulario.dao.DaoProducer;
import abdi.formulario.dto.CriteriosConsultaDTO;
import abdi.formulario.excecao.AplicacaoException;
import abdi.formulario.log.AplicacaoLogger;
import abdi.formulario.mensagens.MensagemResourceBundle;
import abdi.formulario.mensagens.Mensagens;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rogerio.Rodrigues
 */
@Stateless(name = "AlunoMBean", mappedName = "AlunoMBean")
public class AlunoMBean extends AplicacaoMBean
        implements IAlunoMBean {

    @Inject
    @DaoProducer
    private AlunoDao alunoDao;

    @PersistenceContext(unitName = "abdi.formulario")
    private EntityManager manager;

    @Resource
    private SessionContext context;

    public AlunoDao getAlunoDao() {
        this.alunoDao.setEntityManager(this.manager);
        return this.alunoDao;
    }

    @Logged
    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Aluno> listar() {
        AplicacaoLogger.getLogger(getClass())
                .info(
                    "Usu\u00e1rio logado:"
                    .concat(
                        context.getCallerPrincipal().getName()
                    )
                );
        return getAlunoDao().listar();
    }

    @Override
    @Logged
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void incluir(Aluno aluno) throws AplicacaoException {
        validar(aluno);
        getAlunoDao().incluir(aluno);
    }

    private void validar(Aluno aluno) throws AplicacaoException {
        if (aluno == null || aluno.getNome() == null || aluno.getNome().trim().equals("")) {
            throw new AplicacaoException(
                    MensagemResourceBundle
                    .get()
                    .getMensagem(
                            Mensagens.MSG02.name()
                    )
            );
        }
        List<Aluno> alunos = getAlunoDao().listar();
        for (Aluno alunoBanco : alunos) {
            if (alunoBanco.getNome().toUpperCase().equals(
                    aluno.getNome().toUpperCase().trim())) {
                throw new AplicacaoException(
                        MensagemResourceBundle
                        .get()
                        .getMensagem(
                                Mensagens.MSG01.name()
                        )
                );
            }
        }
    }

    @Logged
    @Override
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public List<Aluno> procurar(CriteriosConsultaDTO criterios) {
        return getAlunoDao().procurar(criterios);
    }

}
