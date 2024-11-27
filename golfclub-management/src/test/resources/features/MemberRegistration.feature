Feature: Mitgliederregistrierung
  As a prospective club member,
  I want to register as a member,
  So that I can access club facilities.

  Scenario: Erfolgreiche Registrierung
    Given the user is on the registration page,
    When the user enters valid details,
    And submits the form,
    Then the system confirms the registration.
