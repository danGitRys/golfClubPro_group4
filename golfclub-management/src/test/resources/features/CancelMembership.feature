Feature: Kündigung der Mitgliedschaft
  As a club member,
  I want to cancel my membership,
  So that I am no longer charged.

  Scenario: Erfolgreiche Kündigung
    Given the user is logged in,
    And is on the membership page,
    When the user clicks "Cancel Membership",
    Then the system confirms the cancellation.
