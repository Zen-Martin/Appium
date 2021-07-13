package com.dior.steps_definition;

import com.dior.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MetierSameLinkStep {

    @Given("User is on **metier page**")
    public void user_is_on_metier_page() throws InterruptedException {
        HomePage.navigateToMetier();
    }

    @When("User click on **horlogerie**")
    public void user_click_on_horlogerie() throws InterruptedException {
        HomePage.getHorlogerielink();
    }

    @Then("User should be on another page")
    public void user_should_be_on_another_page() {
        HomePage.verifyNewsDefileSameLink();
    }


   /* @Given("User get to **news defiles** and choose **savoir faire**")
    public void user_get_to_news_defiles_and_choose_savoir_faire() throws InterruptedException {
        HomePage.navigateToHomePage_Int();
    }

    @Then("User get to a default new page **metier**")
    public void user_get_to_a_default_new_page_metier() throws InterruptedException {
        HomePage.navigateToSavoirFaire();

    }

    @And("User click on **horlogerie**")
    public void user_click_on_horlogerie() throws InterruptedException {
        HomePage.getHorlogerielink();
    }

    @Then("User should be on another page")
    public void user_should_be_on_another_page() {
        HomePage.verifyNewsDefileSameLink();
    }*/


}
