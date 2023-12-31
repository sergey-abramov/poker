package poker.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import poker.model.PokerHand;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PokerHandServiceTest {

    private static PokerHandService service;

    @BeforeAll
    public static void init() {
        Grade gradeService = new Grade();
        Parser parser = new Parser();
        HandRankAnalyze rankAnalyze = new HandRankAnalyze();
        service = new PokerHandService(gradeService, rankAnalyze, parser);
    }

    @Test
    void sortedThenTwoPokerHand() {
        PokerHand pair = new PokerHand("KS 2H 4C KD TD");
        PokerHand three = new PokerHand("KS KH 4C KD TD");
        List<PokerHand> handList = new ArrayList<>();
        handList.add(pair);
        handList.add(three);
        assertEquals(List.of(three, pair), service.sorted(handList));
    }

    @Test
    void sortedThenFourPokerHand() {
        PokerHand pair = new PokerHand("KS 2H 4C KD TD");
        PokerHand three = new PokerHand("KS KH 4C KD TD");
        PokerHand fullHouse = new PokerHand("KS 2H 2C KD KC");
        PokerHand street = new PokerHand("2D 3H 4C 5H 6H");
        List<PokerHand> handList = new ArrayList<>();
        handList.add(pair);
        handList.add(fullHouse);
        handList.add(street);
        handList.add(three);
        assertEquals(List.of(fullHouse, street, three, pair), service.sorted(handList));
    }
}