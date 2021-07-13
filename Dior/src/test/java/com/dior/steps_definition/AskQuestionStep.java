package com.dior.steps_definition;

import com.dior.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AskQuestionStep {

    @Given("User is on website french version on rubrique **contact-couture**")
    public void user_is_on_website_french_version_on_rubrique_contact_couture() throws InterruptedException {
        HomePage.navigateToContact_Couture();
        HomePage.handleCookiesFrame();
        HomePage.handleAccessFrame();
    }
    @When("User scroll-down")
    public void user_scroll_down() throws InterruptedException {
        HomePage.scroll(1050);
        HomePage.getAskQuestionEnability();
    }
    @Then("User should be able to click on ask question")
    public void user_should_be_able_to_click_on_ask_question() {
        HomePage.verifyAskQuestionEnability();
    }


}
