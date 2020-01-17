package com.google.www.tasks;

import com.google.gson.Gson;
import com.google.www.exceptions.MyBusinessException;
import com.google.www.models.User;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.Map;
import static com.google.www.exceptions.ExceptionsMessages.*;
import static com.google.www.util.GorestConstant.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 *
 * Tarea para el consumo del metodo GET, con el cual se realiza la consulta del usuario especifico
 * con el id que se obtubo desde el apiPost.
 *
 */
public class GetApi implements Task {


    private CloseableHttpClient clienteHTTP = HttpClients.createDefault();

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            HttpGet httpGet = setGetAuthorization();
            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
                @Override
                public String handleResponse(
                        final HttpResponse response) throws IOException {
                    if (response.getStatusLine().getStatusCode()>=400){
                        throw new MyBusinessException(EXCEPTIONS_ERROR_API_RESPONSE_USER_QUERY.getMessage());
                    }
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                }
            };
            String responseBody = this.clienteHTTP.execute(httpGet,responseHandler);
            responseHttpMethod(responseBody);
        }catch (IOException ex){
            throw new MyBusinessException(EXCEPTIONS_ERROR_API_RESPONSE.getMessage());
        }
    }

    public static GetApi method() {
        return instrumented(GetApi.class);
    }

    /**
     *
     * Metodo que configura la autorizacion de acceso a la api.
     * @return Retorna un metodo httpGet.
     */
    private HttpGet setGetAuthorization(){
        String id= Serenity.sessionVariableCalled("id");
        HttpGet httpGet = new HttpGet(BASE_URL +PATH_GET+id);
        httpGet.setHeader("Authorization", "Bearer " + TOKEN_ACCES);
        httpGet.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        return httpGet;
    }

    /**
     * Metodo donde se captura los valores de la respuesta del apiGet.
     * @param responseBody
     */
    private void responseHttpMethod(String responseBody){
        User user = new User();
        Gson gson = new Gson();
        Map<String, Object> mapResponse =  gson.fromJson(responseBody, Map.class);
        Map<String,Object> result=  (Map<String,Object>) mapResponse.get("result");
        user.setName(result.get("first_name").toString());
        user.setLastName(result.get( "last_name").toString());
        user.setStatus(result.get("status").toString());
        user.setGender(result.get("gender").toString());
        user.setEmail(result.get("email").toString());
        Serenity.setSessionVariable("userModelResponsApi").to(user);
    }
}
