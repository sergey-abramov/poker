package poker.service;

import poker.model.Card;
import poker.model.Layout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Grade {

    public Layout getRank(List<Card> cardList, HandRankAnalyze rankAnalyze) {
        int countContains = 0;
        Map<String, Card> suits = new HashMap<>();
        List<Card> duplicates = new ArrayList<>();
        Map<String, Card> values = new HashMap<>();
        List<String> highCards = new ArrayList<>();
        List<String> integerCards = new ArrayList<>();
        for (Card card : cardList) {
            String cardValue = card.getValue();
            if (Character.isLetter(cardValue.charAt(0))) {
                highCards.add(cardValue);
            } else {
                integerCards.add(cardValue);
            }
            if (!values.containsKey(cardValue)) {
                values.put(cardValue, card);
            } else {
                if (countContains == 0 || !duplicates.contains(values.get(cardValue))) {
                    duplicates.add(values.get(cardValue));
                    countContains++;
                }
                values.put(cardValue, card);
                duplicates.add(card);
            }
            suits.put(card.getSuit(), card);
        }
        return rankAnalyze.analyze(values.size(), suits.size(),
                duplicates.size(), highCards.size(), integerCards.size());
    }
}
