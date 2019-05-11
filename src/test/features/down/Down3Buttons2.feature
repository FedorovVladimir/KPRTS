Feature: Работа с второй тройкой (парой) кнопок нижней панели

  Scenario: Работа с первой тройкой (парой) кнопок 1
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "DKMB1"
    Then На панели "4" текст "2000,000"
    Then На панели "5" текст "2000,000"
    Then На панели "6" текст "ПШ      "
    Then Не горит "MB1"
    Then Не горит "MB2"
    Then Не горит "MB3"
    Then Не горит "L833"
    Then Горит "DKMB1"
    Then Не горит "DKMB2"

  Scenario: Работа с первой тройкой (парой) кнопок 2
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "DKMB2"
    Then На панели "4" текст "2000,000"
    Then На панели "5" текст "2000,000"
    Then На панели "6" текст "ПШ      "
    Then Не горит "MB1"
    Then Не горит "MB2"
    Then Не горит "MB3"
    Then Не горит "L833"
    Then Не горит "DKMB1"
    Then Горит "DKMB2"

  Scenario: Работа с первой тройкой (парой) кнопок 3
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "PS"
    Then На панели "4" текст " 118,000"
    Then На панели "5" текст " 118,000"
    Then На панели "6" текст "        "
    Then Горит "MB1"
    Then Не горит "MB2"
    Then Не горит "MB3"
    Then Не горит "L833"
    Then Не горит "DKMB1"
    Then Не горит "DKMB2"

  Scenario: Работа с первой тройкой (парой) кнопок 4
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "PS"
    When Я нажал кнопку "PS"
    Then На панели "4" текст " 118,000"
    Then На панели "5" текст " 118,000"
    Then На панели "6" текст "ПШ      "
    Then Горит "MB1"
    Then Не горит "MB2"
    Then Не горит "MB3"
    Then Не горит "L833"
    Then Не горит "DKMB1"
    Then Не горит "DKMB2"

  Scenario: Работа с первой тройкой (парой) кнопок 5
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "PS"
    When Я нажал кнопку "MB2"
    Then На панели "4" текст " 118,000"
    Then На панели "5" текст " 118,000"
    Then На панели "6" текст "ПШ      "
    Then Не горит "MB1"
    Then Горит "MB2"
    Then Не горит "MB3"
    Then Не горит "L833"
    Then Не горит "DKMB1"
    Then Не горит "DKMB2"

  Scenario: Работа с первой тройкой (парой) кнопок 6
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "PS"
    When Я нажал кнопку "DKMB1"
    Then На панели "4" текст "2000,000"
    Then На панели "5" текст "2000,000"
    Then На панели "6" текст "ПШ      "
    Then Не горит "MB1"
    Then Не горит "MB2"
    Then Не горит "MB3"
    Then Не горит "L833"
    Then Горит "DKMB1"
    Then Не горит "DKMB2"

  Scenario: Работа с первой тройкой (парой) кнопок 7
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "DKMB1"
    When Я нажал кнопку "AM"
    Then На панели "4" текст "2000,000"
    Then На панели "5" текст "2000,000"
    Then На панели "6" текст "ПШ    AM"
    Then Не горит "MB1"
    Then Не горит "MB2"
    Then Не горит "MB3"
    Then Не горит "L833"
    Then Горит "DKMB1"
    Then Не горит "DKMB2"

  Scenario: Работа с первой тройкой (парой) кнопок 8
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "DKMB1"
    When Я нажал кнопку "AM"
    When Я нажал кнопку "AM"
    Then На панели "4" текст "2000,000"
    Then На панели "5" текст "2000,000"
    Then На панели "6" текст "ПШ      "
    Then Не горит "MB1"
    Then Не горит "MB2"
    Then Не горит "MB3"
    Then Не горит "L833"
    Then Горит "DKMB1"
    Then Не горит "DKMB2"

  Scenario: Работа с первой тройкой (парой) кнопок 9
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "DKMB1"
    When Я нажал кнопку "PS"
    When Я нажал кнопку "AM"
    Then На панели "4" текст "2000,000"
    Then На панели "5" текст "2000,000"
    Then На панели "6" текст "      AM"
    Then Не горит "MB1"
    Then Не горит "MB2"
    Then Не горит "MB3"
    Then Не горит "L833"
    Then Горит "DKMB1"
    Then Не горит "DKMB2"


  Scenario: Работа с первой тройкой (парой) кнопок 10
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "DKMB1"
    When Я нажал кнопку "PS"
    When Я нажал кнопку "AM"
    When Я нажал кнопку "DKMB2"
    Then На панели "4" текст "2000,000"
    Then На панели "5" текст "2000,000"
    Then На панели "6" текст "ПШ      "
    Then Не горит "MB1"
    Then Не горит "MB2"
    Then Не горит "MB3"
    Then Не горит "L833"
    Then Не горит "DKMB1"
    Then Горит "DKMB2"

  Scenario: Работа с первой тройкой (парой) кнопок 11
    When Я повернул рычаг в положение "2"
    When Я нажал кнопку "B833"
    Then На панели "4" текст " 118,000"
    Then На панели "5" текст " 118,000"
    Then На панели "6" текст "ПШ      "
    Then Горит "MB1"
    Then Не горит "MB2"
    Then Не горит "MB3"
    Then Горит "B833"
    Then Не горит "DKMB1"
    Then Не горит "DKMB2"
