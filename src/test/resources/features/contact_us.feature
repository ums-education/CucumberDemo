Feature: Contact Us Page

  Scenario: Clicking on "Contact Us" link
    Given I navigate to the company website
    When I click on Contact Us link
    And I check the title
    Then I should see "Contact us - My Store"
    And I quit the driver in 3 seconds

  #Scenario: Sending a message to Customer Service
  #Given I navigate to the company website
  #When I click on Contact Us link
  #And I select "Customer service" from Subject Heading
  #And I add an email address
  #And I add an order reference
  #And I add a message
  #When I click "Send" button
  #Then I should get the following message
  #"""
  #Your message has been successfully sent to our team.
  #"""
  #And I quit the driver in 5 seconds
  Scenario Outline: Sending message to all subject headings
    Given I navigate to the company website
    When I click on Contact Us link
    And I select "<subject heading>" from Subject Heading
    And I add an email address
    And I add an order reference
    And I add a message
    When I click "Send" button
    Then I should get the following message
      """
      Your message has been successfully sent to our team.
      """
    And I quit the driver in 5 seconds

    Examples: 
      | subject heading  |
      | Customer service |
      | Webmaster        |
