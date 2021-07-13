package com.dior.steps_definition;

import com.dior.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ConnexionOnIntWebsiteStep {

    @Given("User is on website french version")
    public void user_is_on_website_french_version() throws InterruptedException {
        HomePage.navigateToHomePage_fr();
        HomePage.handleCookiesFrame();
        HomePage.handleAccessFrame();
    }

    @And("User should be able to connect")
    public void user_should_be_able_to_connect() {
        HomePage.getToFindConnexion();
    }

    @When("User move to international website")
    public void user_move_to_international_website() throws InterruptedException {
        HomePage.navigateToHomePage_Int();
        HomePage.getToFindConnexion();

    }

    @Then("User should be also able to connect")
    public void user_should_be_also_able_to_connect() {
        HomePage.verifyGetConnexionToInt_Website();
    }




}
