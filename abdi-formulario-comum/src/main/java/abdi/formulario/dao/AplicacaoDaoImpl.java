package abdi.formulario.dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import javax.persistence.EntityManager;

/**
 *
 * @author Rogerio.Rodrigues
 */
public abstract class AplicacaoDaoImpl  {

    private EntityManager manager;
    
    public AplicacaoDaoImpl() {
    }
    
    public MongoClient obterConexao() {
        AplicacaoDataSource dataSource = new AplicacaoDataSource();
        return dataSource.criarConexao();
    }
    
    public MongoDatabase obterDatabase(MongoClient client, String database) {
        return client.getDatabase(database);
    }
    
    public void fecharConexao(MongoClient client) {
        AplicacaoDataSource dataSource = new AplicacaoDataSource();
        dataSource.fecharConexao(client);
    }
    
    public EntityManager getEntityManager() {
        return this.manager;
    }

     public void setEntityManager(EntityManager manager) {
         this.manager = manager;
     }
    
}
