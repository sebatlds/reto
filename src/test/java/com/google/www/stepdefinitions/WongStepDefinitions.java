package com.google.www.stepdefinitions;

import com.google.www.tasks.BuyArticle;
import com.google.www.tasks.SelectAnyArticle;
import com.google.www.tasks.SelectArticleType;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import com.google.www.userinterfaces.Wongpage;

public class WongStepDefinitions {

    @Managed(driver = "chrome")
    private WebDriver herBrowser;

    private Actor wongUser = Actor.named("wongUser");
    Wongpage wongpage = new Wongpage();

    @Before
    public void setUp() {
        wongUser.can(BrowseTheWeb.with(herBrowser));
        wongUser.wasAbleTo(
                Open.browserOn(wongpage)
        );
    }

    @Given("^I select the article$")
    public void iSelectTheArticle(){
        wongUser.attemptsTo(
                SelectArticleType.ofTheWongPage(),
                SelectAnyArticle.thatIsForSale()
        );
    }

    @When("^Add to shopping cart$")
    public void addToShoppingCart(){
        wongUser.attemptsTo(
                BuyArticle.andAddToCart()
        );
    }
}
