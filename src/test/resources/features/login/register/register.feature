Feature: Register

  Background:
    Given User is on register page

  Scenario: Register user correctly
    When he submits form with unique e-mail
    And and with correct data
    Then new user is registered

  Scenario: User tries to register by typing empty e-mail
    When he submits form with empty e-mail
    Then he is moved to different page

  Scenario: User tries to register by typing not matching password
    When he submits form by typing not matching password
    Then error message is displayed with unsuccessful registration
