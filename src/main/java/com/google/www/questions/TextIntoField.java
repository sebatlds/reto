package com.google.www.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

/**
 *
 * Clase que compara que dos textos sean iguales.
 * y si no lo son arroja un error ilustrativo con los textos comparados.
 */


@Subject("the value obtained '#valueObtained' is compare with the value '#valueToCompare' from the field '#field'")
public class TextIntoField implements Question<Boolean> {
    private String valueToCompare;
    private String valueObtained;
    String field;

    private TextIntoField(String valueObtained) {
        this.valueObtained = valueObtained;
    }

    public TextIntoField isEqualsto(String valueToCompare) {
        this.valueToCompare = valueToCompare;
        return this;
    }

    public TextIntoField from(String field) {
        this.field = field;
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return valueObtained.equalsIgnoreCase(valueToCompare);
    }

    public static TextIntoField theTextInto(String valueObtained) {
        return new TextIntoField(valueObtained);
    }
}
