package poker.sevice;

import poker.model.Layout;

import java.util.*;

public class PokerHandGradeService {

    public Layout getRank(String pokerHand) {
        String[] cards = pokerHand.split(" ");
        int countContains = 0;
        Map<String, String> suits = new HashMap<>();
        List<String> duplicates = new ArrayList<>();
        Map<String, String> values = new HashMap<>();
        List<String> highCards = new ArrayList<>();
        List<String> integerCards = new ArrayList<>();
        for (String s: cards) {
            if (Character.isLetter(s.charAt(0))) {
                highCards.add(s);
            } else {
                integerCards.add(s);
            }
            String[] card = s.split("");
            if (!values.containsKey(card[0])) {
                values.put(card[0], s);
            } else {
                if (countContains == 0 || !duplicates.contains(values.get(card[0]))) {
                    duplicates.add(values.get(card[0]));
                    countContains++;
                }
                values.put(card[0], s);
                duplicates.add(s);
            }
        }
        int sizeMap = values.size();
        int sizeDuplicates = duplicates.size();
        int integerCardsSize = integerCards.size();
        int highCardSize = highCards.size();
        if (sizeMap == 5 && sizeDuplicates == 0) {
            for (String s : values.keySet()) {
                String key = values.get(s).split("")[1];
                suits.put(key, s);
                if (highCardSize != 5 || integerCardsSize != 5) {
                    duplicates.add(values.get(s));
                }
            }
        }
        int sizeSuitsMap = suits.size();
        return sizeMap == 4 ? Layout.Pair
                : sizeMap == 3 && sizeDuplicates == 3 ? Layout.Three_of_a_kind
                : sizeMap == 3 && sizeDuplicates == 4 ? Layout.Two_Pairs
                : sizeMap == 2 && sizeDuplicates == 4 ? Layout.Four_of_a_kind
                : sizeMap == 2 && sizeDuplicates == 5 ? Layout.Full_house
                : sizeSuitsMap == 1 && duplicates.size() == 5
                                    && highCardSize != 5 && integerCardsSize != 5 ? Layout.Flash
                : sizeSuitsMap == 1 && highCardSize == 5 ? Layout.Royal_flash
                : sizeSuitsMap == 1 &&  integerCardsSize == 5 ? Layout.Street_flash
                : sizeMap == 5 &&  integerCardsSize == 5 && highCardSize == 0 ? Layout.Street
                : Layout.High_card;
    }
}
