Feature: Включение и выключение пульта

  Scenario: Включение и выключение пульта 1
    When Я повернул рычаг в положение "1"
    Then Горит "MB1"
    Then Не горит "MB2"
    Then Не горит "MB3"
    Then Не горит "B833"
    Then Не горит "DKMB1"
    Then Не горит "DKMB2"
    Then На панели "4" текст " 118,000"
    Then На панели "5" текст " 118,000"
    Then На панели "6" текст "ПШ      "

  Scenario: Включение и выключение пульта 2
    When Я повернул рычаг в положение "2"
    Then Горит "MB1"
    Then Не горит "MB2"
    Then Не горит "MB3"
    Then Не горит "B833"
    Then Не горит "DKMB1"
    Then Не горит "DKMB2"
    Then На панели "4" текст " 118,000"
    Then На панели "5" текст " 118,000"
    Then На панели "6" текст "ПШ      "

  Scenario: Включение и выключение пульта 3
    When Я повернул рычаг в положение "0"
    Then Не горит "MB1"
    Then Не горит "MB2"
    Then Не горит "MB3"
    Then Не горит "B833"
    Then Не горит "DKMB1"
    Then Не горит "DKMB2"
    Then На панели "4" текст "        "
    Then На панели "5" текст "        "
    Then На панели "6" текст "        "