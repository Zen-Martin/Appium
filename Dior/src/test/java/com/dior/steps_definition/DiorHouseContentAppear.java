package com.dior.steps_definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.dior.M_Homepage;

public class DiorHouseContentAppear {

    @Given("User is on mobile french website")
    public void user_is_on_mobile_french_website() throws InterruptedException {
        M_Homepage.gotoHomepage();
    }

    @When("User get on faq_Page")
    public void user_get_on_faq_page() throws InterruptedException {
        M_Homepage.getOnFaqPage();
    }

    @And("User make click to access to dior house")
    public void user_make_click_to_access_to_dior_house() throws InterruptedException {
        M_Homepage.getOnDiorHouse();
    }

    @Then("User should see dior house page effective content")
    public void user_should_see_dior_house_page_effective_content() {
        M_Homepage.verifyDiorHouseContentAppear();
    }

}
