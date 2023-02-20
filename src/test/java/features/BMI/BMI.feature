Feature: BMI calculator
  Calculate body mass index

  Scenario: BMI calculation
    Given Open app ICD
    And accept cookies
    When click on BMI tool
    Then page is BMI
    And input weight
    And input height
    Then BMI change colour in green
    And get index of BMI
