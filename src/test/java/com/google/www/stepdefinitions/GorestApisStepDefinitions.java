package com.google.www.stepdefinitions;

import com.google.www.questions.VerifyConsumeApi;
import com.google.www.tasks.GetApi;
import com.google.www.tasks.PostApi;
import com.google.www.util.Utilities;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import java.util.Map;

public class GorestApisStepDefinitions {

    private Actor gorestUser = Actor.named("gorestUser");

    @Given("^I create a user with the post method$")
    public void iCreateAUserWithThePostMethod(Map<String, String> dataTable){
        gorestUser.attemptsTo(
                PostApi.method(Utilities.getRequestToCreateAnEmployee(dataTable)),
                GetApi.method()
        );
    }

    @Then("^I verify the creation of this user with the get method$")
    public void iVerifyTheCreationOfThisUserWithTheGetMethod(){
        gorestUser.should(
                seeThat(VerifyConsumeApi.checkDataToResponse())
        );
    }
}
