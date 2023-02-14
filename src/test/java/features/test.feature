Feature: Login
  Login test as registered user

 Scenario: Login with valid credentials

   Given Open app ICD
   When accept cookies
   And click on Login
   And enter email
   And enter password
   And click on Submit button
   Then Loged in
   And  click on AllTools
   Then page is tools
   And click on VascularAgeCalkulator
   Then set male gender
   And set age
   And choose nonsmoker
   And choose blood pressure
   And choose HDL
   Then check vaslukar age
   And check risk


