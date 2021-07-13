@Web
Feature: Re-Test Cases for DIOR Website without account Access

  #------------------- Bug 381 -------------------------------------------------------
  @Bug381
  Scenario: Check that traduction is effective
    Given User is on international website homepage
    When User look all headers elements
    Then User should see elements in english

  #------------------- Bug 351 -------------------------------------------------------
  @Bug351
  Scenario: Check that frame have same size
    Given User is on website french version on rubrique **CGV**
    When User look at frames
    Then User should see same size

  #------------------- Bug 357 -------------------------------------------------------
  @Bug357
  Scenario: Check that **ask question button** is cliquable
    Given User is on website french version on rubrique **contact-couture**
    When User scroll-down
    Then User should be able to click on ask question

  #------------------- Bug 375 -------------------------------------------------------
  @Bug375
  Scenario: Check that require size for password is the same everywhere
    Given User is on login version page
    When User get login password size requirement
    And User is on inscription version page
    And User get inscription password size requirement
    Then User should have save size requirement

  #------------------- Bug 385 -------------------------------------------------------
  @Bug385
  Scenario: Check that link aren't same
    Given User is on **metier page**
    When User click on **horlogerie**
    Then User should be on another page

  #------------------- Bug 392 -------------------------------------------------------
  @Bug392
  Scenario: Check that we can connect on the international website
    Given User is on website french version
    And User should be able to connect
    When User move to international website
    Then User should be also able to connect

  #------------------- Bug 395 -------------------------------------------------------
  @Bug395
  Scenario: Check that slider effects is available
    Given User is on **dior maquillage** page
    When User plays with slider
    Then User should see slider effects

  #------------------- Bug 348 -------------------------------------------------------
  @Bug348
  Scenario: Check that text-area provides space with writing zone
    Given User is on contact_couture page
    When User write inside zone area
    Then User should see space between zone and writting

  #------------------- Bug 404 -------------------------------------------------------
  @Bug404
  Scenario: Check that langage service header appear everytime
    Given User is on hompage
    When User plays with langage version
    Then User should see service header appear appear




