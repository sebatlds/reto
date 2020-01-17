package com.google.www.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/gorest_apis.feature",
        glue = "com.google.www.stepdefinitions",
        snippets = SnippetType.CAMELCASE)
public class GorestApiRunner {
}
