package com.google.www.tasks;

import com.google.www.interactions.ClickJS;
import com.google.www.interactions.ScrollUp;
import com.google.www.util.RandomValue;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;

import static com.google.www.userinterfaces.Wongpage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

/**
 *
 * Tarea para ir al carro de compras.
 *
 */
public class BuyArticle implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickJS.clickJSTargetElement(CLOSE_BUTTON),
                Check.whether(Visibility.of(CLOSE_BUTTON).viewedBy(actor).asBoolean()).andIfSo(
                        Click.on(CLOSE_BUTTON)
                ),
                ScrollUp.toThePage(),
                Click.on(BUTTON_MINICARD),
                Click.on(BUTTON_SEE_CARD)
        );
    }

    public static BuyArticle andAddToCart() {
        return instrumented(BuyArticle.class);
    }
}

