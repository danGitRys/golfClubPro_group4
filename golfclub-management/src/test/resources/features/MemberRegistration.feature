Feature: Member Registration (Mitgliederregistrierung)
  As a prospective club member,
  I want to register as a member,
  So that I can access club facilities.

  Scenario: Successful Registration (Erfolgreiche Registrierung)
    Given a new member gets created
    When the member details are correct
    Then the member is a part of the system
