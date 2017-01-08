Feature: Search product

 Background:
   Given I am already in the home screen
@solo
 Scenario: Search for a product

    When I click on Search button
    Then Search TextBox should be displayed

