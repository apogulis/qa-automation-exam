Feature: Web store checkout
  This feature verifies that user can add item to the cart, choose preferred payment option and checkout at the web store

  Scenario:
    Given web store page is open
    And item is added to the cart
    And payment option had been chosen
    And  customer information had been entered
    Then verify that added item and price is correct