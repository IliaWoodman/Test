Feature: yandex picture

  Scenario: Add image and check tags
    Given Open yandex picture
    When click search picture button
    And add picture link
    Then check that tags have word