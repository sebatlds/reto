Feature: basic registration Nominapp SVPyme
  A user can register his company in nominapp by SVPyme

  @GorestApi @TestCase1
  Scenario Outline: Basic register TC1, Successful case
  Narrative: Register a company in nominapp

    Given I create a user with the post method
    | first_name | <first_name>|
    | last_name  | <last_name> |
    |  gender    | <gender>    |
    |  email     | <email>     |
    |  status    | <status>    |
    Then I verify the creation of this user with the get method
    Examples:
      | first_name | last_name | gender | email | status |
      | Sebastian  | Osorio    | male   | @mail.com| active|