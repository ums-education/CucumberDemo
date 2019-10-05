Feature: This is just to demo the power of scenario outline
  via the Web Orders webpage login interface

  Scenario Outline: All login scenarios
    Given I go to "http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx"
    When I pass in "<username>" as username
    And I pass in "<password>" as password
    And I click on Login button
    Then I should be on "<page>" page

    Examples: 
      | username | password | page             |
      | Tester   | test     | Web Orders       |
      | Tester   |          | Web Orders Login |
      | Tester   | random   | Web Orders Login |
      |          | test     | Web Orders Login |
      | fake     | test     | Web Orders Login |
      | admin    | webadmin | Web Orders Login |

# DATA DRIVEN TESTING Example using Cucumber
#	 Scenario Outline and Examples 
# Data Driven Testing is simply a type of testing
#	 where multiple variety of data is used to test
#  against the system.