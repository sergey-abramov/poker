package poker.sevice;

import org.junit.jupiter.api.Test;
import poker.model.Layout;
import poker.model.PokerHand;

import static org.junit.jupiter.api.Assertions.*;

class PokerHandGradeServiceTest {

    private final PokerHandGradeService service = new PokerHandGradeService();

    @Test
    void getRankThenOnePair() {
        PokerHand pokerHand = new PokerHand("KS 2H 4C KD TD");
        var result = service.getRank(pokerHand.getCards());
        assertEquals(Layout.Pair, result);
    }

    @Test
    void getRankThenOnePair2() {
        PokerHand pokerHand = new PokerHand("TS 2H 4C KD KS");
        var result = service.getRank(pokerHand.getCards());
        assertEquals(Layout.Pair, result);
    }

    @Test
    void getRankThenThree() {
        PokerHand pokerHand = new PokerHand("KS 2H 4C KD KC");
        var result = service.getRank(pokerHand.getCards());
        assertEquals(Layout.Three_of_a_kind, result);
    }

    @Test
    void getRankThenFour() {
        PokerHand pokerHand = new PokerHand("KS KH 4C KC KD");
        var result = service.getRank(pokerHand.getCards());
        assertEquals(Layout.Four_of_a_kind, result);
    }

    @Test
    void getRankThenTwoPair() {
        PokerHand pokerHand = new PokerHand("KS TH 4C KD TD");
        var result = service.getRank(pokerHand.getCards());
        assertEquals(Layout.Two_Pairs, result);
    }

    @Test
    void getRankThenFullHouse() {
        PokerHand pokerHand = new PokerHand("KS 2H 2C KD KC");
        var result = service.getRank(pokerHand.getCards());
        assertEquals(Layout.Full_house, result);
    }

    @Test
    void getRankThenFlash() {
        PokerHand pokerHand = new PokerHand("9H 2H 5H KH TH");
        var result = service.getRank(pokerHand.getCards());
        assertEquals(Layout.Flash, result);
    }

    @Test
    void getRankThenRoyalFlash() {
        PokerHand pokerHand = new PokerHand("AH KH QH JH TH");
        var result = service.getRank(pokerHand.getCards());
        assertEquals(Layout.Royal_flash, result);
    }

    @Test
    void getRankThenStreetFlash() {
        PokerHand pokerHand = new PokerHand("2H 3H 4H 5H 6H");
        var result = service.getRank(pokerHand.getCards());
        assertEquals(Layout.Street_flash, result);
    }

    @Test
    void getRankThenStreet() {
        PokerHand pokerHand = new PokerHand("2D 3H 4C 5H 6H");
        var result = service.getRank(pokerHand.getCards());
        assertEquals(Layout.Street, result);
    }

    @Test
    void getRankThenHighCard() {
        PokerHand pokerHand = new PokerHand("AD 3H 4C 5H 6H");
        var result = service.getRank(pokerHand.getCards());
        assertEquals(Layout.High_card, result);
    }
}