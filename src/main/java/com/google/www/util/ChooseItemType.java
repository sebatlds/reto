package com.google.www.util;

import com.google.www.exceptions.MyBusinessException;
import static com.google.www.exceptions.ExceptionsMessages.EXCEPTION_ERROR_PRODUCT_TYPE_NOT_EXIST;

/**
 *
 * Clase que retorna el tipo de producto a seleccionar.
 *
 */
public class ChooseItemType {

    public String getArticle(int value){
        String article = null;
        switch (value){
            case 0:
                article = "Frutas y Verduras";
                break;
            case 1:
                article = "Carnes y Aves";
                break;
            case 2:
                article = "Abarrotes";
                break;
            case 3:
                article = "Vinos y Licores";
                break;
            case 4:
                article = "Limpieza";
                break;
            case 5:
                article = "Televisores";
                break;
            case 6:
                article = "Hogar y Bazar";
                break;
            default:
                throw new MyBusinessException(EXCEPTION_ERROR_PRODUCT_TYPE_NOT_EXIST.getMessage());
        }
        return article;
    }
}
