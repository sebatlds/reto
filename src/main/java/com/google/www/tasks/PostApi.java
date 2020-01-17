package com.google.www.tasks;

import com.google.gson.Gson;
import com.google.www.exceptions.MyBusinessException;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import static com.google.www.exceptions.ExceptionsMessages.*;
import static com.google.www.util.GorestConstant.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 *
 * Tarea para el consumo del metodo POST. El cual crea un nuevo usuario.
 *
 */
public class PostApi implements Task {

    private String json;
    private CloseableHttpClient clienteHTTP = HttpClients.createDefault();

    public PostApi(String json) {
        this.json = json;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            HttpPost httpPost = setPostAuthorization(json);
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(
                        final HttpResponse response) throws IOException {
                    if (response.getStatusLine().getStatusCode()>=400){
                        throw new MyBusinessException(EXCEPTIONS_ERROR_API_RESPONSE_USER_CREATE.getMessage());
                    }
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                }
            };
            String responseBody = this.clienteHTTP.execute(httpPost,responseHandler);
            responseHttpMethod(responseBody);
        }catch (IOException ex){
            throw new MyBusinessException(EXCEPTIONS_ERROR_API_RESPONSE.getMessage());
        }
    }

    public static PostApi method(String json) {
        return instrumented(PostApi.class,json);
    }

    /**
     * Metodo que setea los header y la autorizacion para el consumo de la api.
     * @param json = cuerpo del mansaje.
     * @return Retorna un metodo httpPost.
     */
    private HttpPost setPostAuthorization(String json) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost();
        httpPost = new HttpPost(BASE_URL +PATH_POST);
        httpPost.setHeader("Authorization", "Bearer " + TOKEN_ACCES);
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        return httpPost;
    }

    /**
     * Metodo que mapea la respuesta de la api, guardando el id del usuario creado.
     */
    private void responseHttpMethod(String responseBody){
        Gson gson = new Gson();
        Map<String, Object> mapResponse =  gson.fromJson(responseBody, Map.class);
        Map<String,Object> result=  (Map<String,Object>) mapResponse.get("result");
        String id = result.get("id").toString();
        Serenity.setSessionVariable("id").to(id);
    }
}
