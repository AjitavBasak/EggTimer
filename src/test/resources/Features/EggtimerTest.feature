@Test
Feature: Feature to test loading

  Scenario Outline: EggTimer time calculation
    Given open "<Browser>"
    And Read url from property file and navigate
    Then User validate page gets loaded
    When User enters "<Time>" in the website
    And User clicks on start
    Then User verifies if timer is reduced by 1 sec for "<Time>"
    Then User verifies if alert is present after "<Time>"
    Examples:
      | Browser | Time  |
      | chrome  | 1     |
      | chrome  | 1 sec |