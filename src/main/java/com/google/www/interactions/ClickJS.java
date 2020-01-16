package com.google.www.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.JavascriptExecutor;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClickJS implements Interaction {
    private Target element;

    public ClickJS(Target element) {
        this.element = element;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(element, isVisible()),
                Scroll.to(element)
        );
        clickJSTarget(actor);
    }

    public static ClickJS clickJSTargetElement(Target element) {

        return Tasks.instrumented(ClickJS.class, element);
    }

    private void clickJSTarget(Actor actor){
        JavascriptExecutor executor = (JavascriptExecutor) Serenity.getWebdriverManager().getCurrentDriver();
        executor.executeScript("arguments[0].click()", element.resolveFor(actor));
    }
}
