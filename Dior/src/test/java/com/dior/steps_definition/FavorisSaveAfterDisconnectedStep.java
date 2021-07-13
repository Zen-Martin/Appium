package com.dior.steps_definition;

import com.dior.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FavorisSaveAfterDisconnectedStep {


    @Given("User access to his account")
    public void user_access_to_his_account() throws InterruptedException {
        HomePage.navigateToHomePage_fr();
        HomePage.handleCookiesFrame();
        HomePage.handleAccessFrame();
        HomePage.connexion();
    }

    @When("User click on favoris")
    public void user_click_on_favoris() throws InterruptedException {
        Thread.sleep(2000);

    }

    @Then("User should see favoris element appear")
    public void user_should_see_favoris_element_appear() throws InterruptedException {
        HomePage.getFavorisElement1();
    }

    @And("User click get disconnected")
    public void user_click_get_disconnected() throws InterruptedException {
        HomePage.getFavorisElement2();
    }

    @Then("User should see favoris element disappear")
    public void user_should_see_favoris_element_disappear() {
        HomePage.verifyFavorisElementState();
    }

}
