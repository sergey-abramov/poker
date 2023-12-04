package poker.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PokerHand implements Comparable<PokerHand> {

    private final String cards;
    private int high;

    @Override
    public int compareTo(PokerHand o) {
        return Integer.compare(o.high, high);
    }
}
