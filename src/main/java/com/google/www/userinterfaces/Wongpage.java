package com.google.www.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://www.wong.pe/especiales/cyberwong")
public class Wongpage extends PageObject{

    public static final Target BUTTON_ADD=
            Target.the("").located(By.xpath("//*[@class='product-item__add-to-cart product-add-to-cart btn red add-to-cart']"));
    public static final Target CLOSE_ALERT=
            Target.the("").located(By.id("onesignal-popover-cancel-button"));
    public static final Target BUTTON_MINICARD=
            Target.the("").located(By.xpath("//*[@class='btn red minicart__action--toggle-open food-site']"));
    public static final Target BUTTON_SEE_CARD=
            Target.the("").located(By.xpath("//*[@id='minicart-navigation']/div[2]/div[2]/a"));
    public static final Target INPUT_EMAIL=
            Target.the("").located(By.id("delivery-email"));
    public static final Target BUTTON_DELIVERY_MODE=
            Target.the("").located(By.xpath("//*[@id='footer']/div[3]/div/div/div/div/div/div[2]/div[2]/button[2]"));
    public static final Target BUTTON_SELECT_SHOP=
            Target.the("").located(By.id("react-select-2--value"));
    public static final Target LIST_SHOPS=
            Target.the("").located(By.xpath("//*[@aria-activedescendant='react-select-2--option--2']"));
    public static final Target CLOSE_BUTTON=
            Target.the("").located(By.xpath("//*[@class=\"modal-address__close font-icn cross\"]"));


    public static Target getArticleCategory(String article){
        return Target.the("List of article types").located(By.xpath("//*[contains(text(),'"+article+"')]"));
    }

}