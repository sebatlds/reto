package com.google.www.exceptions;


/**
 * Clase para manejar las excepciones
 *
 */
public class MyBusinessException extends RuntimeException{
    public MyBusinessException(String message, Throwable testErrorException) {
        super(message, testErrorException);
    }

    public MyBusinessException(String message) {
        super(message);
    }

}
