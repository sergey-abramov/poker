package poker.sevice;

import lombok.RequiredArgsConstructor;
import poker.model.Layout;
import poker.model.PokerHand;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class PokerHandService {

    private final PokerHandGradeService gradeService;

    public List<PokerHand> sorted(List<PokerHand> hands) {
        for (PokerHand hand : hands) {
            Layout grade = gradeService.getRank(hand.getCards());
            hand.setHigh(grade.ordinal());
        }
        Collections.sort(hands);
        return hands;
    }
}
