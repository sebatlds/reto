package com.google.www.tasks;

import com.google.www.util.RandomValue;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import java.util.List;
import static com.google.www.userinterfaces.Wongpage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectAnyArticle implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        RandomValue randomValue = new RandomValue();
        List<WebElementFacade> listButtonAdd =  BUTTON_ADD.resolveAllFor(actor);
        int index = randomValue.getRandomValue(listButtonAdd.size()+1);
        actor.attemptsTo(
                //Scroll.to(listButtonAdd.get(index)),
                Click.on(listButtonAdd.get(index))
        );
    }

    public static SelectAnyArticle thatIsForSale() {
        return instrumented(SelectAnyArticle.class);
    }
}
