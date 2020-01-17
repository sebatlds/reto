package com.google.www.questions;

import com.google.www.models.User;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

/**
 *
 * Question que valida los datos del usuario que se crea con el apiPost, y los datos
 * que se obtienen de la respuesta del apiGet la cual consulta el usuario creado.
 *
 */
public class VerifyConsumeApi implements Question<Boolean> {
    User user = Serenity.sessionVariableCalled("userModel");
    User userResponseApi = Serenity.sessionVariableCalled("userModelResponsApi");
    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThat(TextIntoField.theTextInto(user.getEmail()).from("Email del usuario.").isEqualsto(userResponseApi.getEmail())),
                seeThat(TextIntoField.theTextInto(user.getGender()).from("Genero del usuario").isEqualsto(userResponseApi.getGender())),
                seeThat(TextIntoField.theTextInto(user.getLastName()).from("Apellido del usuario").isEqualsto(userResponseApi.getLastName())),
                seeThat(TextIntoField.theTextInto(user.getName()).from("Nombre del usuario").isEqualsto(userResponseApi.getName())),
                seeThat(TextIntoField.theTextInto(user.getStatus()).from("Estado del usuario").isEqualsto(userResponseApi.getStatus()))
        );
        return true;
    }

    public static VerifyConsumeApi checkDataToResponse() {
        return new VerifyConsumeApi();
    }
}
