package com.google.www.tasks;

import com.google.www.models.Product;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import static com.google.www.userinterfaces.Wongpage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import net.serenitybdd.core.Serenity;
import java.util.List;

/**
 *
 * Tarea para obtener el nombre y valor del producto.
 *
 */
public class GetText implements Task {

    private int index;
    private Product product = new Product();

    public GetText(int index) {
        this.index = index;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> name = NAME_PRUDUCT.resolveAllFor(actor);
        List<WebElementFacade> value = VALUE_PRUDUCT.resolveAllFor(actor);
        product.setName(name.get(index).getText());
        product.setValue(value.get(index).getText());
        Serenity.setSessionVariable("productModel").to(product);
    }

    public static GetText ofTheWongPage(int index) {
        return instrumented(GetText.class,index);
    }
}
