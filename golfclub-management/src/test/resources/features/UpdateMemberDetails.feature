Feature: Update Contact Information (Aktualisierung der Mitgliedsdaten)
  As a club member,
  I want to update my contact information,
  So that the club has accurate records.

  Scenario: Successful Update (Erfolgreiches Update)
    Given a member exists
    When the user changes their name
    Then the new name should be saved
