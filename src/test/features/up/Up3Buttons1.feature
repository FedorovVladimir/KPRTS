Feature: Работа с первой тройкой кнопок

  Scenario: Работа с первой тройкой кнопок 1
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "VOR"
    Then На панели "1" текст "  108,00"
    Then На панели "2" текст "  Аз   0"
    Then На панели "3" текст "СПАРЕН П"
    Then Не горит "APK"
    Then Горит "VOR"
    Then Горит "DME"

  Scenario: Работа с первой тройкой кнопок 2
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "VOR"
    When Я нажал кнопку "APK"
    Then На панели "1" текст "   150,0"
    Then На панели "2" текст "   150,0"
    Then На панели "3" текст "КОМП ТЛФ"
    Then Горит "APK"
    Then Не горит "VOR"
    Then Не горит "DME"

  Scenario: Работа с первой тройкой кнопок 3
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "VOR"
    When Я нажал кнопку "DME"
    Then На панели "1" текст "  108,00"
    Then На панели "2" текст "  108,00"
    Then На панели "3" текст "        "
    Then Не горит "APK"
    Then Не горит "VOR"
    Then Горит "DME"

  Scenario: Работа с первой тройкой кнопок 4
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "VOR"
    When Я нажал кнопку "VOR"
    Then На панели "1" текст "  108,00"
    Then На панели "2" текст "  Аз   0"
    Then На панели "3" текст "       П"
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
    Then На панели "1" текст "  108,00"
    Then На панели "2" текст "  Аз   0"
    Then На панели "3" текст "СПАРЕН П"
    Then Не горит "APK"
    Then Горит "VOR"
    Then Горит "DME"

  Scenario: Работа с первой тройкой кнопок 6
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "VOR"
    When Я нажал кнопку "VOR"
    When Я нажал кнопку "DME"
    Then На панели "1" текст "  108,00"
    Then На панели "2" текст "  108,00"
    Then На панели "3" текст "        "
    Then Не горит "APK"
    Then Не горит "VOR"
    Then Горит "DME"

  Scenario: Работа с первой тройкой кнопок 7
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "DME"
    When Я нажал кнопку "VOR"
    Then На панели "1" текст "  108,00"
    Then На панели "2" текст "  Аз   0"
    Then На панели "3" текст "СПАРЕН П"
    Then Не горит "APK"
    Then Горит "VOR"
    Then Горит "DME"