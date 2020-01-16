package com.google.www.interactions;

import com.google.www.questions.ElementText;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WaitTextToAppear implements Interaction {

    private static final Logger LOGGER = Logger.getLogger(WaitTextToAppear.class.getName());
    Target elementTarget;
    int lessThanSeconds;

    public WaitTextToAppear(Target elementTarget, int lessThanSeconds) {
        this.elementTarget=elementTarget;
        this.lessThanSeconds=lessThanSeconds;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String text;
        int counter=0;

        do {
            counter++;
            text= actor.asksFor(ElementText.elementText(elementTarget)).trim();
            actor.attemptsTo(ImplicitWait.implicitWait(counter, TimeUnit.SECONDS));
            LOGGER.log(Level.INFO,"Wait for a while, for the item to get the text.");
        }while ("".equals(text) && counter <= lessThanSeconds);
    }

    public static WaitTextToAppear waitTextToAppear(Target elementTarget, int lessThanSeconds) {

        return Tasks.instrumented(WaitTextToAppear.class, elementTarget,null,lessThanSeconds);
    }
}
