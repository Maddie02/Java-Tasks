package task;

import java.util.Comparator;

public class AmountComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        return Double.compare(o1.getAmount(), o2.getAmount());
    }
}
