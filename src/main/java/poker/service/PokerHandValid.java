package poker.service;

import poker.model.PokerHand;

public class PokerHandValid {

    public static boolean validation(PokerHand hand) {
        var arrCards = hand.getCards().split(" ");
        if (arrCards.length != 5) {
            throw new IllegalArgumentException("Количество карт должно быть не менее пяти");
        }
        for (String s : arrCards) {
            if (!(s.startsWith("2") || s.startsWith("3")
                    || s.startsWith("4") || s.startsWith("5")
                    || s.startsWith("6") || s.startsWith("7")
                    || s.startsWith("8") || s.startsWith("9")
                    || s.startsWith("T") || s.startsWith("J")
                    || s.startsWith("Q") || s.startsWith("K")
                    || s.startsWith("A")) || !(s.endsWith("S")
                    || s.endsWith("H") || s.endsWith("D")
                    || s.endsWith("C"))) {
                throw new IllegalArgumentException("Не существующее значение");
            }
        }
        return true;
    }
}
