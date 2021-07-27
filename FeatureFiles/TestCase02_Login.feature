Feature: User is able to Login in the Lumens application

Scenario: Verify user is able to Login Lumens  application

    Given launch the Lumens website using property file
    When Go to Account and Select signin 
    Then Enter the username and password the input field and click login button
   Then  navigate to Account and click on signout
 
 