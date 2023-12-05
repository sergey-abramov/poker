package poker.service;

import poker.model.Card;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public List<Card> parse(String pokerHandCards) {
        String[] cards = pokerHandCards.split(" ");
        List<Card> result = new ArrayList<>();
        for (String s : cards) {
            result.add(new Card(s.split("")[0], s.split("")[1]));
        }
        return result;
    }
}
