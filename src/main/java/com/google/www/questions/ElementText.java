package com.google.www.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import java.text.Normalizer;

public class ElementText implements Question<String> {

    private Target element;

    private ElementText(Target element) {
        this.element = element;
    }

    @Override
    public String answeredBy(Actor actor) {
        String text = element.resolveFor(actor).getText();
        text = Normalizer.normalize(text, Normalizer.Form.NFD);
        text = text.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return text;
    }

    public static ElementText elementText(Target element) {
        return new ElementText(element);
    }

}
