package com.google.www.util;

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
                article = "Electrohogar";
                break;
            case 7:
                article = "Hogar y Bazar";
                break;
            default:
                //exception
        }
        return article;
    }
}
