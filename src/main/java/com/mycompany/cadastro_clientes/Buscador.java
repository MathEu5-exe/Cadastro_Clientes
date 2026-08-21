package util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.UnknownHostException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;


/**
 * Não mude o código desta classe. 
 */
public class Buscador {
    
    public Endereco buscar(String cep) throws IOException{
        // cep não está no formato 99999-999
        if (!cep.matches("\\d{5}-\\d{3}")) {
            throw new IllegalArgumentException("O formato não é válido");
        }
        HttpGet request = new HttpGet("https://viacep.com.br/ws/" + cep + "/json/");
        CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(request);
        } catch (UnknownHostException uhe) {
            // não foi possível conectar ao servidor de busca de Cep 
            throw new IOException("Erro ao conectar com o serviço ViaCep");
        }
        HttpEntity entity = response.getEntity();
        String retorno = EntityUtils.toString(entity);
        
        // se o CEP não foi encontrado
        if (retorno.contains("erro")) {
            response.close();
            httpClient.close();
            throw new IOException("O CEP não foi encontrado");
        }
        
        
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Endereco endereco = mapper.readValue(retorno, Endereco.class);
        return endereco;
    }
    
}
