@runloginFeature
Feature: GreenKart adding vegtables

  @tag1
  Scenario: 
    Given Go to Greenkart page
    When I add Vegetables "1" Kg "Cucumber" and click on Add to cart button
    When I add Vegetables "1" Kg "Tomato" and click on Add to cart button
    When I add Vegetables "1" Kg "Brinjal" and click on Add to cart button
    And I Click on Bag icon 
    And I click on "PROCEED TO CHECKOUT" button
    And I navigate to "greenkart" and validate page title
    And I enter the promo code "rahulshettyacademy"
    And I click on "Apply" button
    And I verified code apply successfully 
    And I verified "No. of Items     : " is "3"
    And I verified "Total Amount     :" is "99"
    And I verified "Discount          : " is "10%"
    And I verified "Total After Discount : " is "89.1" 