Feature: Пульт
  Scenario: Включение пульта
    When Я поворачиваю рычаг в положение 2
    Then Загорается лампочка "APK"
    Then На панели "1" загораетя "   150,0"
    Then На панели "2" загораетя "   150,0"
    Then На панели "3" загораетя "комп тлф"
    Then На панели "4" загораетя " 118,000"
    Then На панели "5" загораетя " 118,000"
    Then На панели "5" загораетя "пш      "
    Then Загорается лампочка "MB1"