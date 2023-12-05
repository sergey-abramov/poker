package poker.service;

import poker.model.Layout;

public class HandRankAnalyze {

    public Layout analyze(int sizeOriginalValues, int sizeOriginalSuits,
                          int sizeDuplicates, int sizeHighCards, int sizeIntegerCards) {
        if (sizeOriginalValues == 4 && sizeDuplicates == 2) {
            return Layout.PAIR;
        }
        if (sizeOriginalValues == 3 && sizeDuplicates == 4) {
            return Layout.TWO_PAIRS;
        }
        if (sizeOriginalValues == 3 && sizeDuplicates == 3) {
            return Layout.THREE_OF_A_KIND;
        }
        if (sizeOriginalValues == 5 && sizeDuplicates == 0
                && sizeHighCards == 0 && sizeIntegerCards == 5
                && sizeOriginalSuits != 1) {
            return Layout.STREET;
        }
        if (sizeOriginalSuits == 1 && sizeOriginalValues == 5
                && sizeIntegerCards != 5 && sizeHighCards != 5) {
            return Layout.FLASH;
        }
        if (sizeOriginalValues == 2 && sizeDuplicates == 5) {
            return Layout.FULL_HOUSE;
        }
        if (sizeOriginalValues == 2 && sizeDuplicates == 4) {
            return Layout.FOUR_OF_A_KIND;
        }
        if (sizeOriginalValues == 5 && sizeDuplicates == 0
                && sizeIntegerCards == 5 && sizeOriginalSuits == 1) {
            return Layout.STREET_FLASH;
        }
        if (sizeOriginalValues == 5 && sizeDuplicates == 0
                && sizeHighCards == 5 && sizeOriginalSuits == 1) {
            return Layout.ROYAL_FLASH;
        }
        return Layout.HIGH_CARD;
    }
}
