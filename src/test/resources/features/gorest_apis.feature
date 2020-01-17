@GOREST
Feature: Register user through api
  A user can Register using api

  @GorestApi @TestCase1
  Scenario Outline: Registration of a user by consuming an api.
  Narrative: Register user.

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