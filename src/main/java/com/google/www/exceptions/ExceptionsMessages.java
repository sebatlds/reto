package com.google.www.exceptions;
/**
 * enum para manejar los mensajes que se mostraran en caso que falle en una ejecucion
 */
public enum ExceptionsMessages {

    EXCEPTION_ERROR_PRODUCT_TYPE_NOT_EXIST("The type of product is not available."),
    EXCEPTIONS_ERROR_API_RESPONSE_USER_QUERY("User query failed."),
    EXCEPTIONS_ERROR_API_RESPONSE_USER_CREATE( "User creation failed."),
    EXCEPTIONS_ERROR_API_RESPONSE("Api execution failed.");

    private final String mensaje;

    ExceptionsMessages(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMessage() {
        return this.mensaje;
    }

}
