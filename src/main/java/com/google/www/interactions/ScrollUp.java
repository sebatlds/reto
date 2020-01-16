package com.google.www.interactions;

import com.google.www.tasks.BuyArticle;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.openqa.selenium.JavascriptExecutor;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ScrollUp implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {

        JavascriptExecutor js = (JavascriptExecutor) Serenity.getWebdriverManager().getCurrentDriver();
        js.executeScript("window.scrollTo(0,-Math.max(document.documentElement.scrollHeight,"
                    + "document.body.scrollHeight,document.documentElement.clientHeight));");
    }

    public static ScrollUp toThePage() {
        return instrumented(ScrollUp.class);
    }
}
