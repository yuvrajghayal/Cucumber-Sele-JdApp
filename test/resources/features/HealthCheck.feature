@ui @healthcheck
Feature: Just Dial Application User stories Journeys

 Scenario: User is able to Sign up in the application
    Given User navigates to the application url
    When User clicks on Sign up link at the top right corner of the application
    And User enters name as "Akash" and Phone number as "9123456789" and clicks on Submit Button
    Then User is displayed with the message as "OTP is sent on number"
