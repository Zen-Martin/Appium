package com.dior.steps_definition;

import com.dior.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PasswordFieldRequirementsStep {

    @Given("User is on login version page")
    public void user_is_on_login_version_page() throws InterruptedException {
        HomePage.navigateToAccountLogin();
    }

    @When("User get login password size requirement")
    public void user_get_login_password_size_requirement() throws InterruptedException {
        HomePage.getLoginPasswordFieldSize();
    }

    @And("User is on inscription version page")
    public void user_is_on_inscription_version_page() throws InterruptedException {
        HomePage.navigateToAccountInscription();
    }

    @And("User get inscription password size requirement")
    public void user_get_inscription_password_size_requirement() throws InterruptedException {
        HomePage.getInscriptionPasswordFieldSize();
    }

    @Then("User should have save size requirement")
    public void user_should_have_save_size_requirement() {
        HomePage.verifyPasswordFieldSize();
    }

}
