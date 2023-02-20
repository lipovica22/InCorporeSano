Feature: Login
  Login on Mediately.rs
  @Run
  Scenario : Login ti ICD
    Given Open app ICD1
    And accept cookies1
    When click on Login
    And enter email "srdjanstech@gmail.com"
    And enter password "incorporesano"
    And click on Submit button
    Then Logged in