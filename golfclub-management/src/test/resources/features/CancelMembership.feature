Feature: Membership Cancellation (Kündigung der Mitgliedschaft)
  As a club member,
  I want to cancel my membership,
  So that I am no longer charged.

  Scenario: Successful Cancellation (Erfolgreiche Kündigung)
    Given user is a member
    When the user cancels his membership
    Then the user should be no member anymore
