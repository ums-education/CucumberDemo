
Feature: Home Page Navigation

 
  Scenario: Navigating to the home page
    Given I navigate to the company website
    When I check the title
    Then I should see "My Store"
    And I quit the driver in 5 seconds
    

