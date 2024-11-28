Feature: Mitgliederregistrierung
  As a prospective club member,
  I want to register as a member,
  So that I can access club facilities.

  Scenario: Erfolgreiche Registrierung
    Given when a new member gets created
    When the memeber details are correct
    Then the member is a part of the system
