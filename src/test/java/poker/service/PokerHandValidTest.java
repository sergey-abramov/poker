package poker.service;

import org.junit.jupiter.api.Test;
import poker.model.PokerHand;

import static org.junit.jupiter.api.Assertions.*;

public class PokerHandValidTest {

    @Test
    void validationThenTrue() {
        PokerHand hand = new PokerHand("KS 2H 5C JD TD");
        assertTrue(PokerHandValid.validation(hand));
    }

    @Test
    void validationThenThrowByCards() {
        PokerHand hand = new PokerHand("KS 2H 5C JD TE");
        assertThrowsExactly(IllegalArgumentException.class,
                () -> PokerHandValid.validation(hand),
                "Не существующее значение");
    }

    @Test
    void validationThenThrowByCards2() {
        PokerHand hand = new PokerHand("KS 49 5C JD TD");
        assertThrowsExactly(IllegalArgumentException.class,
                () -> PokerHandValid.validation(hand),
                "Не существующее значение");
    }

    @Test
    void validationThenThrowByCardsLength() {
        PokerHand hand = new PokerHand("KS 2H 5C JD");
        assertThrowsExactly(IllegalArgumentException.class,
                () -> PokerHandValid.validation(hand),
                "Количество карт должно быть не менее пяти");
    }
}