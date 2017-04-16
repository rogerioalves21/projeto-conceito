package abdi.formulario.dao;

import abdi.formulario.dto.CriteriosConsultaDTO;
import abdi.formulario.excecao.PersistenciaException;
import abdi.formulario.mensageria.vo.MensagemAuditoria;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.Document;

/**
 *
 * @author Rogerio.Rodrigues
 */
public class AuditoriaDaoImpl extends AplicacaoDaoImpl implements AuditoriaDao {

    @Override
    public void incluir(MensagemAuditoria mensagem) {
        MongoClient mongoClient = null;
        try {
            mongoClient = obterConexao();
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            format.format(new Date());

            Document dados = new Document();
            dados.put("login", mensagem.getConteudo());
            dados.put("dataHora", format.format(new Date()));
            MongoCollection<Document> auditorias = obterDatabase(mongoClient, "aplicacaoConceito").getCollection("auditoria");
            if (auditorias == null) {
                obterDatabase(mongoClient, "aplicacaoConceito").createCollection("auditoria");
                auditorias = obterDatabase(mongoClient, "aplicacaoConceito").getCollection("auditoria");
            }
            auditorias.insertOne(dados);
        } catch (Exception excecao) {
            throw new PersistenciaException(excecao);
        } finally {
            fecharConexao(mongoClient);
        }
    }

    @Override
    public List<MensagemAuditoria> listar() {
        MongoClient mongoClient = null;
        List<MensagemAuditoria> lista = new ArrayList<>();
        try {
            mongoClient = obterConexao();
            MongoCollection<Document> auditorias = obterDatabase(mongoClient, "aplicacaoConceito").getCollection("auditoria");
            MongoCursor<Document> cursor = auditorias.find().iterator();
            while (cursor.hasNext()) {
                Document documento = cursor.next();
                MensagemAuditoria mensagem = new MensagemAuditoria();
                mensagem.setConteudo(documento.toJson());
                lista.add(mensagem);
            }
            cursor.close();
        } catch (Exception excecao) {
            throw new PersistenciaException(excecao);
        } finally {
            fecharConexao(mongoClient);
        }
        return lista;
    }

    @Override
    public MensagemAuditoria obter(Serializable chave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MensagemAuditoria> procurar(CriteriosConsultaDTO criterios) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
