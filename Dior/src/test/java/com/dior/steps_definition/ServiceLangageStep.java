package com.dior.steps_definition;

import com.dior.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ServiceLangageStep {

    @Given("User is on hompage")
    public void user_is_on_hompage() throws InterruptedException {
        HomePage.navigateToHomePage_fr();
        HomePage.handleCookiesFrame();
        HomePage.handleAccessFrame();
    }

    @When("User plays with langage version")
    public void user_plays_with_langage_version() throws InterruptedException {
        HomePage.getLangageService();
    }

    @Then("User should see service header appear appear")
    public void user_should_see_service_header_appear_appear() {
        HomePage.verifyServiceLangageAppear();
    }


}
