Feature: Everyone should be greeted
  Even unknown people

  Scenario Outline: Sunday isn't Friday
    Given name is '<name>'
    When the user is greeted
    Then the welcome message is '<greeting>'

    Examples:
      | name   | greeting                |
      | kitty  | Welcome Kitty Enschede  |
      | yvette | Welcome Yvette Enschede |
      | marc   | Welcome Marc Enschede   |
      | herman | Welcome Unknown         |

