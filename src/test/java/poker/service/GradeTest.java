package poker.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import poker.model.Layout;
import poker.model.PokerHand;

import static org.junit.jupiter.api.Assertions.*;

class GradeTest {

    private static Grade service;
    private static Parser parser;
    private static HandRankAnalyze rankAnalyze;

    @BeforeAll
    public static void init() {
        service = new Grade();
        parser = new Parser();
        rankAnalyze = new HandRankAnalyze();
    }

    @Test
    void getRankThenOnePair() {
        PokerHand pokerHand = new PokerHand("KS 2H 4C KD TD");
        var result = service.getRank(parser.parse(pokerHand.getCards()), rankAnalyze);
        assertEquals(Layout.PAIR, result);
    }

    @Test
    void getRankThenOnePair2() {
        PokerHand pokerHand = new PokerHand("TS 2H 4C KD KS");
        var result = service.getRank(parser.parse(pokerHand.getCards()), rankAnalyze);
        assertEquals(Layout.PAIR, result);
    }

    @Test
    void getRankThenThree() {
        PokerHand pokerHand = new PokerHand("KS 2H 4C KD KC");
        var result = service.getRank(parser.parse(pokerHand.getCards()), rankAnalyze);
        assertEquals(Layout.THREE_OF_A_KIND, result);
    }

    @Test
    void getRankThenFour() {
        PokerHand pokerHand = new PokerHand("KS KH 4C KC KD");
        var result = service.getRank(parser.parse(pokerHand.getCards()), rankAnalyze);
        assertEquals(Layout.FOUR_OF_A_KIND, result);
    }

    @Test
    void getRankThenTwoPair() {
        PokerHand pokerHand = new PokerHand("KS TH 4C KD TD");
        var result = service.getRank(parser.parse(pokerHand.getCards()), rankAnalyze);
        assertEquals(Layout.TWO_PAIRS, result);
    }

    @Test
    void getRankThenFullHouse() {
        PokerHand pokerHand = new PokerHand("KS 2H 2C KD KC");
        var result = service.getRank(parser.parse(pokerHand.getCards()), rankAnalyze);
        assertEquals(Layout.FULL_HOUSE, result);
    }

    @Test
    void getRankThenFlash() {
        PokerHand pokerHand = new PokerHand("9H 2H 5H KH TH");
        var result = service.getRank(parser.parse(pokerHand.getCards()), rankAnalyze);
        assertEquals(Layout.FLASH, result);
    }

    @Test
    void getRankThenRoyalFlash() {
        PokerHand pokerHand = new PokerHand("AH KH QH JH TH");
        var result = service.getRank(parser.parse(pokerHand.getCards()), rankAnalyze);
        assertEquals(Layout.ROYAL_FLASH, result);
    }

    @Test
    void getRankThenStreetFlash() {
        PokerHand pokerHand = new PokerHand("2H 3H 4H 5H 6H");
        var result = service.getRank(parser.parse(pokerHand.getCards()), rankAnalyze);
        assertEquals(Layout.STREET_FLASH, result);
    }

    @Test
    void getRankThenStreet() {
        PokerHand pokerHand = new PokerHand("2D 3H 4C 5H 6H");
        var result = service.getRank(parser.parse(pokerHand.getCards()), rankAnalyze);
        assertEquals(Layout.STREET, result);
    }

    @Test
    void getRankThenHighCard() {
        PokerHand pokerHand = new PokerHand("AD 3H 4C 5H 6H");
        var result = service.getRank(parser.parse(pokerHand.getCards()), rankAnalyze);
        assertEquals(Layout.HIGH_CARD, result);
    }
}