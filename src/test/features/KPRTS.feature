Feature: Пульт
  Scenario: Включение пульта
    When Я повернул рычаг в положение "2"
    Then Горит "APK"
    Then На панели "1" текст "   150,0"
    Then На панели "2" текст "   150,0"
    Then На панели "3" текст "комп тлф"
    Then На панели "4" текст " 118,000"
    Then На панели "5" текст " 118,000"
    Then На панели "6" текст "пш      "
    Then Горит "MB1"

  Scenario: Выключение пульта
    When Я повернул рычаг в положение "0"
    Then Не горит "APK"
    Then На панели "1" текст "        "
    Then На панели "2" текст "        "
    Then На панели "3" текст "        "
    Then На панели "4" текст "        "
    Then На панели "5" текст "        "
    Then На панели "6" текст "        "
    Then Не горит "MB1"

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