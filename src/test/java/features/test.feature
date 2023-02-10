Feature: Login
  login test as agent

 Scenario: BA TEST credential

   Given login on app BA Test
   When enter Agent username
   And enter Agent password
   And click on Submit button
   Then Loged in
   And  page is Products

