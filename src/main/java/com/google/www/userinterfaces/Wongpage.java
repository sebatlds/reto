package com.google.www.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

/**
 *
 * Clase que contiene los elementos de la pagina web.
 *
 */
@DefaultUrl("https://www.wong.pe/especiales/cyberwong")
public class Wongpage extends PageObject{

    public static final Target BUTTON_ADD=
            Target.the("Button to add to the shopping cart.").located(By.xpath("//*[@class='product-item__add-to-cart product-add-to-cart btn red add-to-cart']"));
    public static final Target NAME_PRUDUCT=
            Target.the("Label indicating the name of the product.").located(By.xpath("//*[@class='product-item__bottom']/div/a"));
    public static final Target VALUE_PRUDUCT=
            Target.the( "Label that indicates the value of the product.").located(By.xpath("//*[@class='product-prices__value product-prices__value--best-price']"));
    public static final Target CLOSE_ALERT=
            Target.the("Button to close the main alert.").located(By.id("onesignal-popover-cancel-button"));
    public static final Target BUTTON_MINICARD=
            Target.the("Button that displays the list where the shopping cart button is.").located(By.xpath("//*[@class='btn red minicart__action--toggle-open food-site']"));
    public static final Target BUTTON_SEE_CARD=
            Target.the("Button to go to the shopping cart.").located(By.xpath("//*[@id='minicart-navigation']/div[2]/div[2]/a"));
    public static final Target CLOSE_BUTTON=
            Target.the("Button to close the modal, when a product is added to the shopping cart.").located(By.xpath("//*[@class=\"modal-address__close font-icn cross\"]"));
    public static final Target NAME_PRODUCT_TO_CART=
            Target.the("Product name in the shopping cart.").located(By.xpath("//*[@class='product-item__name']"));
    public static final Target VALUE_PRODUCT_TO_CART=
            Target.the("Value of the product in the shopping cart.").located(By.xpath("//*[@class='product-prices__value']"));


    public static Target getArticleCategory(String article){
        return Target.the("List of article types").located(By.xpath("//*[contains(text(),'"+article+"')]"));
    }


}