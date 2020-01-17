package com.google.www.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import org.openqa.selenium.JavascriptExecutor;

/**
 * Interaccion que hace scroll hasta el webElement indicado.
 */
public class ScrollToWebElementFacadeJS implements Interaction {
    private WebElementFacade elementFacade;

    public ScrollToWebElementFacadeJS(WebElementFacade elementFacade) {
        this.elementFacade=elementFacade;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {

        JavascriptExecutor executor = (JavascriptExecutor) Serenity.getWebdriverManager().getCurrentDriver();
        executor.executeScript("arguments[0].scrollIntoView(arguments[1]);", elementFacade, true);
    }

    public static ScrollToWebElementFacadeJS scrollToWebElementFacade(WebElementFacade elementFacade) {
        return Tasks.instrumented(ScrollToWebElementFacadeJS.class,elementFacade);
    }
}
