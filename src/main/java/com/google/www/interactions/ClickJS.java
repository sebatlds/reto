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

/**
 *
 * Interaction para dar click usando javaScript.
 * Dependiendo del tipo de elemento (Target o WebElement)
 *
 */
public class ClickJS implements Interaction {
    private Target element;
    private WebElementFacade elementFacade;
    private boolean isTarget;

    public ClickJS(Target element) {
        this.element = element;
        this.isTarget=true;
    }

    public ClickJS(WebElementFacade elementFacade) {
        this.elementFacade = elementFacade;
        this.isTarget=false;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if(isTarget) {
            actor.attemptsTo(
                    WaitUntil.the(element, isVisible()),
                    Scroll.to(element)
            );
            clickJSTarget(actor);
        }else{
            ScrollToWebElementFacadeJS.scrollToWebElementFacade(elementFacade);
            clickJSWebElementFacade();
        }
    }

    public static ClickJS clickJSTargetElement(Target element) {

        return Tasks.instrumented(ClickJS.class, element);
    }

    public static ClickJS clickJSWebElementFacade(WebElementFacade element) {

        return Tasks.instrumented(ClickJS.class, element);
    }

    private void clickJSTarget(Actor actor){
        JavascriptExecutor executor = (JavascriptExecutor) Serenity.getWebdriverManager().getCurrentDriver();
        executor.executeScript("arguments[0].click()", element.resolveFor(actor));
    }

    private void clickJSWebElementFacade(){
        JavascriptExecutor executor = (JavascriptExecutor) Serenity.getWebdriverManager().getCurrentDriver();
        executor.executeScript("arguments[0].click()", elementFacade);
    }
}
