Feature: Adding 2 number on the website marshu.com

  Background:
    Given open the website in chrome

  @adding
  Scenario:
    Given I type number 13 in the first box
    And I type number 7 in the second box
    When I click on the find addition button
    Then The result 20 is displayed

