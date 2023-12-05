package poker.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import poker.model.Card;
import poker.model.PokerHand;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    private static Parser parser;

    @BeforeAll
    public static void init() {
        parser = new Parser();
    }

    @Test
    void parse() {
        PokerHand pokerHand = new PokerHand("KS 2H 4C KD TD");
        assertEquals(List.of(new Card("K", "S"),
                new Card("2", "H"),
                new Card("4", "C"),
                new Card("K", "D"),
                new Card("T", "D")), parser.parse(pokerHand.getCards()));
    }
}