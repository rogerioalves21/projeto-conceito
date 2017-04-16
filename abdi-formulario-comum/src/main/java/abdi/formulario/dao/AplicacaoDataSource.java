package abdi.formulario.dao;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import java.net.URLEncoder;

/**
 *
 * @author Rogerio.Rodrigues
 */
public class AplicacaoDataSource {

    public MongoClient criarConexao() {
        MongoClient mongoClient;
        try {
            String arroba = URLEncoder.encode("@");
            MongoClientURI uri = new MongoClientURI(
                    "mongodb://rogeriorodrigues:" + arroba + "Loureiro3@cop-shard-00-00-3ivio.mongodb.net:27017,cop-shard-00-01-3ivio.mongodb.net:27017,cop-shard-00-02-3ivio.mongodb.net:27017/COP?ssl=true&replicaSet=COP-shard-0&authSource=admin");
            mongoClient = new MongoClient(uri);
            return mongoClient;
        } catch (Exception excecao) {
            throw new RuntimeException(excecao);
        }
    }

    public void fecharConexao(MongoClient client) {
        if (client != null) {
            client.close();
        }
    }

}
