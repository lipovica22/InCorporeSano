Feature: VascularAgeCalculator
  Calculate Vascular Age

  Scenario: Check Vascular age

    Given open app ICD
    And accept cookies
    When click on AllTools
    Then page is tools
    And click on VascularAgeCalculator
    Then page is VascularAgeVeryHigh
    And set gender "Muško"
    And set age "45"
    And choose smokerNonsmoker "Nepušač"
    And choose blood pressure "120-139"
    And choose HDL "6,0–6,9 mmol/L (232–267 mg/dL)"
    Then check vaslukar age "Vaskularna starost: 57 godina"
    And check risk "Rizik SCORE: 9 %"


