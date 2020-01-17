package com.google.www.stepdefinitions;

import com.google.www.questions.VerifyAddProductoToCart;
import com.google.www.tasks.BuyArticle;
import com.google.www.tasks.SelectAnyArticle;
import com.google.www.tasks.SelectArticleType;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import com.google.www.userinterfaces.Wongpage;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class WongStepDefinitions {

    @Managed(driver = "chrome")
    private WebDriver herBrowser;


    private Actor wongUser = Actor.named("wongUser");
    Wongpage wongpage = new Wongpage();


    @Given("^I select the article$")
    public void iSelectTheArticle(){
        wongUser.can(BrowseTheWeb.with(herBrowser));
        wongUser.wasAbleTo(
                Open.browserOn(wongpage)
        );
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

    @Then("Check if the product was added to the cart$")
    public void chechIfTheProductWasAddedToTheCart(){
        wongUser.should(
                seeThat(VerifyAddProductoToCart.checkProductData())
        );
    }
}
