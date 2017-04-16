package abdi.formulario.rest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author Rogerio.Rodrigues
 */
public class LocalizaServicoRest {

    public void teste() {
        try {
            Logger.getLogger(LocalizaServicoRest.class.getName()).log(Level.INFO, "Tentando localizar o rest");
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet("http://localhost:8080/abdi-formulario-web/escola/alunos");
            HttpResponse response = client.execute(request);
            InputStream inputStream = response.getEntity().getContent();
            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception ex) {
            Logger.getLogger(LocalizaServicoRest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
