package com.dior.steps_definition;

import com.dior.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FrameSizeStep {

    @Given("User is on website french version on rubrique **CGV**")
    public void user_is_on_website_french_version_on_rubrique_cgv() throws InterruptedException {
        HomePage.navigateToCGVPage();
        HomePage.handleCookiesFrame();
        HomePage.handleAccessFrame();
    }

    @When("User look at frames")
    public void user_look_at_frames() throws InterruptedException {
        HomePage.getElementCGVSize();
    }

    @Then("User should see same size")
    public void user_should_see_same_size() {
        HomePage.verifyCGVElementSize();
    }

}
