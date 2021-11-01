@Test
Feature: Feature to test eggTimer site

  @Alert
  Scenario Outline: EggTimer To verify the Time elapsed shows the message of Time Expired
    Given open "<Browser>"
    And Read url from property file and navigate
    Then User validate page gets loaded
    When User enters "<Time>" in the website
    And User clicks on start
    Then User verifies if alert is present after "<Time>" in classic mode says
    |Time Expired!|
    Examples:
      | Browser | Time   |
      | chrome  | 25      |
      | chrome  | 25 sec  |

    @PerSec
  Scenario Outline: EggTimer time calculation to see if the timer reduces every second
    Given open "<Browser>"
    And Read url from property file and navigate
    Then User validate page gets loaded
    When User enters "<Time>" in the website
    And User clicks on start
    Then User verifies if timer is reduced by 1 sec for "<Time>" in classic mode
    Examples:
      | Browser | Time   |
      | chrome  | 25      |
      | chrome  | 25 sec  |