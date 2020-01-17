Feature: Add a product to the shopping cart.
  A user can select a producer and add it to the shopping cart.

  @WongTest @TestCase1
  Scenario: Add a product to the shopping cart in wong.
  Narrative:Add product.

    Given I select the article
    When Add to shopping cart
    Then Check if the product was added to the cart


