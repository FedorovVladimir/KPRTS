Feature: Работа с первой тройкой кнопок

  Scenario: Работа с первой тройкой кнопок 1
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "VOR"
    Then Не горит "APK"
    Then Горит "VOR"
    Then Горит "DME"

  Scenario: Работа с первой тройкой кнопок 2
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "VOR"
    When Я нажал кнопку "APK"
    Then Горит "APK"
    Then Не горит "VOR"
    Then Не горит "DME"

  Scenario: Работа с первой тройкой кнопок 3
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "VOR"
    When Я нажал кнопку "DME"
    Then Не горит "APK"
    Then Не горит "VOR"
    Then Горит "DME"

  Scenario: Работа с первой тройкой кнопок 4
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "VOR"
    When Я нажал кнопку "VOR"
    Then Не горит "APK"
    Then Горит "VOR"
    Then Не горит "DME"

  Scenario: Работа с первой тройкой кнопок 5
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "VOR"
    When Я нажал кнопку "VOR"
    When Я нажал кнопку "APK"
    When Я нажал кнопку "VOR"
    When Я нажал кнопку "DME"
    Then Не горит "APK"
    Then Горит "VOR"
    Then Горит "DME"

  Scenario: Работа с первой тройкой кнопок 6
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "VOR"
    When Я нажал кнопку "VOR"
    When Я нажал кнопку "DME"
    Then Не горит "APK"
    Then Не горит "VOR"
    Then Горит "DME"