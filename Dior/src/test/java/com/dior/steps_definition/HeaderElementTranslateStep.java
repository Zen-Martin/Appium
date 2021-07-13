package com.dior.steps_definition;


import com.dior.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HeaderElementTranslateStep {

    @Given("User is on international website homepage")
    public void user_is_on_international_website_homepage() throws InterruptedException {
        HomePage.navigateToHomePage_Int();
    }

    @When("User look all headers elements")
    public void user_look_all_headers_elements() throws InterruptedException {
        HomePage.getHeaderElementMaison();
    }

    @Then("User should see elements in english")
    public void user_should_see_elements_in_english() {
        HomePage.verifyHeaderElementTranslate();
    }

}
