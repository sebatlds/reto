package com.google.www.tasks;

import com.google.www.interactions.ClickJS;
import com.google.www.util.RandomValue;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import java.util.List;
import static com.google.www.userinterfaces.Wongpage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 *
 * Tarea que selecciona de forma aleatoria uno de los primeros pruducto que se muestran en la pantalla.
 *
 */

public class SelectAnyArticle implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        RandomValue randomValue = new RandomValue();
        List<WebElementFacade> listButtonAdd =  BUTTON_ADD.resolveAllFor(actor);
        int index = randomValue.getRandomValue(listButtonAdd.size()+1);
        actor.attemptsTo(
                GetText.ofTheWongPage(index),
                ClickJS.clickJSWebElementFacade(listButtonAdd.get(index))
        );
    }

    public static SelectAnyArticle thatIsForSale() {
        return instrumented(SelectAnyArticle.class);
    }
}
