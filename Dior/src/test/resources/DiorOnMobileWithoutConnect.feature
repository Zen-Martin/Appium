@Mobile
Feature: Re-Test Cases for DIOR Mobile without account Access

  #------------------- Bug 384 -------------------------------------------------------
  @Bug384
  Scenario: Check that mobile page appear
    Given User is on mobile french website
    When User get on faq_Page
    And User make click to access to dior house
    Then User should see dior house page effective content