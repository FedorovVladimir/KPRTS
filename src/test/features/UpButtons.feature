Feature: Работа с верхними кнопками

  Scenario: Работа с верхними кнопками 1
    When Я повернул рычаг в положение "2"
    Then На панели "3" текст "КОМП ТЛФ"

  Scenario: Работа с верхними кнопками 2
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "MFK"
    Then На панели "3" текст "КОМП ТЛГ"

  Scenario: Работа с верхними кнопками 3
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "MFK"
    When Я нажал кнопку "MFK"
    Then На панели "3" текст "АНТ  ТЛФ"

  Scenario: Работа с верхними кнопками 4
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "MFK"
    When Я нажал кнопку "MFK"
    When Я нажал кнопку "MFK"
    Then На панели "3" текст "АНТ  ТЛГ"

  Scenario: Работа с верхними кнопками 5
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "MPR"
    Then Горит "MPR"

  Scenario: Работа с верхними кнопками 6
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "MPR"
    When Я нажал кнопку "MPR"
    Then Не горит "MPR"

