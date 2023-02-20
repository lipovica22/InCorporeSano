Feature: VascularAgeCalculator
  Calculate Vascular Age

  #Scenario: Check Vascular age

  #  Given open app ICD
   # And accept cookies
   # When click on AllTools
   # Then page is tools
   # And click on VascularAgeCalculator
   # Then page is VascularAgeVeryHigh
   # And set gender "Muško"
   # And set age "45"
   # And choose smokerNonsmoker "Nepušač"
   # And choose blood pressure "120-139"
   # And choose HDL "6,0–6,9 mmol/L (232–267 mg/dL)"
   # Then check vaslukar age "Vaskularna starost: 57 godina"
   # And check risk "Rizik SCORE: 9 %"

  #Scenario Outline: Check Vascular age

    #Given open app ICD and load data from "ICDTest" "VS" "<row>"
    #And accept cookies
    #When click on AllTools
    #Then page is tools
    #And click on VascularAgeCalculator
    #Then page is VascularAgeVeryHigh
    #And set gender "<Pol>"
    #And set age "<Starost>"
    #And choose smokerNonsmoker "<PusackiStatus>"
    #And choose blood pressure "<KrvniPritisak>"
    #And choose HDL "<HDLHolesterol>"
    #Then check vaslukar age "VaskularnaStarost"
    #And check risk "<Rizik"
    #Examples:
    #  | row | Pol | Starost | PusackiStatus | KrvniPritisak | HDLHolesterol |


  @Run
  Scenario Outline: Check Vascular age
    Given open app ICD and load data from "ICDTest" "VS" "<row>"
    And accept cookies
    When click on AllTools
    Then page is tools
    And click on VascularAgeCalculator
    Then page is VascularAgeVeryHigh
    And set gender
    And set age
    And choose smokerNonsmoker
    And choose blood pressure
    And choose HDL
    Then check vascular age
    And check risk
    Examples:
      | row   |
      | 1     |
      | 2     |
      | 3     |
      | 4     |
      | 5     |
      | 6     s|




