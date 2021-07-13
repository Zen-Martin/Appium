@Web
Feature: Re-Test Cases for DIOR Website with account Access

  Background:
    Given User access to his account

  #------------------- Bug 391 -------------------------------------------------------
  @Bug391
  Scenario: Check that after deconnexion user favoris don't appear
    When User click on favoris
    Then User should see favoris element appear
    And User click get disconnected
    Then User should see favoris element disappear