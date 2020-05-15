import java.util.ArrayList;
import java.util.List;

public class LengthRating extends Rating {

    public LengthRating(List<String> candidates) {
        super(candidates);
    }

    @Override
    public void setDataSource(List<String> candidates) {
        super.setDataSource(candidates);
        getDataSource().sort(new LengthComparator());
    }

    @Override
    public ArrayList<String> top(int n) {
        return new ArrayList<>(getDataSource().subList(0, n));
    }
}
