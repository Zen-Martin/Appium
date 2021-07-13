package com.dior.steps_definition;

import com.dior.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TextAreaSpaceStep {

    @Given("User is on contact_couture page")
    public void user_is_on_contact_couture_page() throws InterruptedException {
        HomePage.navigateToContact_Couture();
        HomePage.handleCookiesFrame();
        HomePage.handleAccessFrame();
    }

    @When("User write inside zone area")
    public void user_write_inside_zone_area() throws InterruptedException {
        HomePage.getTextAreaSpace();
    }

    @Then("User should see space between zone and writting")
    public void user_should_see_space_between_zone_and_writting() {
        HomePage.verifyTextAreaSpace();
    }

}
