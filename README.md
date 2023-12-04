# POKER

## О проекте

---

Ранжировка покерных рук с помощью класса PokerHand, представляющего набор из 5 карт и их ранга в таблице старшинства 
комбинаций. Ранжировка происходит с помощью классов - сервисов. Используемый стек: Java 17, Lombok 1.18

PokerHandGradeService - определяет к какой комбинации принадлежит набор карт в руках.

PokerHandService - сортирует список из покерных рук так, чтобы первым стоял победитель.

PokerHandValid - проверяет на правильность вводимых данных в набор карт.