Feature: ICD search

  Scenario: search diagnoses by index

    Given Open app ICD
    And accept cookies
    And click on MKB10
    Then page is ICD
    Then input a diagnose index
    And check diagnose
    Then get description


