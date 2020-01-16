package com.google.www.tasks;

import com.google.www.interactions.ClickJS;
import com.google.www.interactions.ScrollUp;
import com.google.www.interactions.WaitTextToAppear;
import com.google.www.userinterfaces.Wongpage;
import com.google.www.util.RandomValue;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;
import org.mockito.internal.util.Checks;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.google.www.userinterfaces.Wongpage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BuyArticle implements Task {
    RandomValue randomValue = new RandomValue();

    @Override
    public <T extends Actor> void performAs(T actor) {
      /* actor.attemptsTo(
               Enter.theValue("os@mal.com").into(INPUT_EMAIL),
               Click.on(Wongpage.getArticleCategory("Aceptar")),
               Click.on(BUTTON_DELIVERY_MODE),
               Click.on(BUTTON_SELECT_SHOP),
               Hit.the(Keys.ENTER).into(LIST_SHOPS));
       /*List<WebElementFacade> a = LIST_SHOPS.resolveAllFor(actor);
       for (WebElementFacade item : a){
           System.out.println(a);
       }*/
       /*actor.attemptsTo(
               Click.on(LIST_SHOPS),
               Click.on(Wongpage.getArticleCategory("Recojo aquí"))
       );*/

        actor.attemptsTo(
                ClickJS.clickJSTargetElement(CLOSE_BUTTON));
        actor.attemptsTo(
                Check.whether(Visibility.of(CLOSE_BUTTON).viewedBy(actor).asBoolean())
                .andIfSo(
                        Click.on(CLOSE_BUTTON)
                ));
        actor.attemptsTo(
                ScrollUp.toThePage());
        actor.attemptsTo(
                Click.on(BUTTON_MINICARD));
        actor.attemptsTo(
                Click.on(BUTTON_SEE_CARD)
        );
    }

    public static BuyArticle andAddToCart() {
        return instrumented(BuyArticle.class);
    }
}

