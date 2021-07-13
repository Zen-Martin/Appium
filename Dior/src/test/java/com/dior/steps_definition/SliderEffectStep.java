package com.dior.steps_definition;

import com.dior.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SliderEffectStep {

    @Given("User is on **dior maquillage** page")
    public void user_is_on_dior_maquillage_page() throws InterruptedException {
        HomePage.navigateToDiorMaquillage();
    }

    @When("User plays with slider")
    public void user_plays_with_slider() throws InterruptedException {
        HomePage.getPlayWithSlider();
    }

    @Then("User should see slider effects")
    public void user_should_see_slider_effects() {
        HomePage.verifySliderFeature();
    }

}
