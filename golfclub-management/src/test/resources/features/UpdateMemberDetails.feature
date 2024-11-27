Feature: Aktualisierung der Mitgliedsdaten
  As a club member,
  I want to update my contact information,
  So that the club has accurate records.

  Scenario: Erfolgreiches Update
    Given the user is logged in,
    And is on the profile page,
    When the user updates their email address,
    Then the system saves the new email.
