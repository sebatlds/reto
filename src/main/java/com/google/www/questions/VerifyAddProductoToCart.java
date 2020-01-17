package com.google.www.questions;

import com.google.www.models.Product;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static com.google.www.userinterfaces.Wongpage.*;

/**
 *
 * Question que valida que el producto se encuentre en el carro de compras,
 * validando que el nombre y valor del producto coincidan.
 *
 */
public class VerifyAddProductoToCart implements Question<Boolean> {


    @Override
    public Boolean answeredBy(Actor actor) {
        Product product = Serenity.sessionVariableCalled("productModel");
        List<WebElementFacade> listValues = VALUE_PRODUCT_TO_CART.resolveAllFor(actor);
        String name=NAME_PRODUCT_TO_CART.resolveFor(actor).getText();
        String value=VALUE_PRODUCT_TO_CART.resolveFor(actor).getText();

        if(listValues.size()==2){
            actor.should(
                    seeThat(TextIntoField.theTextInto(name).from("Nombre del producto.").isEqualsto(product.getName())),
                    seeThat(TextIntoField.theTextInto(listValues.get(2).getText()).from("Valor del producto.").isEqualsto(product.getValue()))
            );
        }else {
            actor.should(
                    seeThat(TextIntoField.theTextInto(name).from("Nombre del producto.").isEqualsto(product.getName())),
                    seeThat(TextIntoField.theTextInto(value).from("Valor del producto.").isEqualsto(product.getValue()))
            );
        }
        return true;
    }
    public static VerifyAddProductoToCart checkProductData() {
        return new VerifyAddProductoToCart();
    }
}
