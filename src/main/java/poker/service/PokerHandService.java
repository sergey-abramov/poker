package poker.service;

import lombok.RequiredArgsConstructor;
import poker.model.Layout;
import poker.model.PokerHand;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class PokerHandService {

    private final Grade gradeService;
    private final HandRankAnalyze rankAnalyze;
    private final Parser parser;

    public List<PokerHand> sorted(List<PokerHand> hands) {
        for (PokerHand hand : hands) {
            var listCards = parser.parse(hand.getCards());
            Layout grade = gradeService.getRank(listCards, rankAnalyze);
            hand.setHigh(grade.ordinal());
        }
        Collections.sort(hands);
        return hands;
    }
}
