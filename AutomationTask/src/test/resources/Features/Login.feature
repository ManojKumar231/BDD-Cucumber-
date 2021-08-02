Feature: Sauce Demo page scenarios


  Scenario: Verify the product details whether you are added the correct product
    Given I login with standard_user and secret_sauce
    When Add the product to cart
    And Checkout the product
    And I fill the checkout details Manoj and R and 517167
    Then Validate the product details whether you are ordered the correct product

  Scenario: Verify user invalid login error messages
    Given I login with abcd and abcd
    When I see the error message
    Then Validate the error message
      | Epic sadface: Username and password do not match any user in this service |

  Scenario: Verify Sauce Labs Bolt T-Shirt is available in list
    Given I login with standard_user and secret_sauce
    When I get the list of all products
    Then I verify Sauce Labs Bolt T-Shirt is in the list
      | Sauce Labs Bolt T-Shirt |

  Scenario: Verify Price of all products
    Given I login with standard_user and secret_sauce
    When Get the price of all products and remove the dollar symbol
    Then Validate the price with product listing with product individual page


