import java.util.ArrayList;
import java.util.List;

public class BiasedRating extends Rating {
    List<String> preferredCandidates;

    public BiasedRating(List<String> candidates, List<String> preferredCandidates) {
        super(candidates);
        this.preferredCandidates = preferredCandidates;
    }

    public List<String> getPreferredCandidates() {
        return preferredCandidates;
    }

    @Override
    public ArrayList<String> top(int n) {
        if (n <= getPreferredCandidates().size()) {
            return new ArrayList<>(getPreferredCandidates().subList(0, n));
        } else {
            ArrayList<String> results = new ArrayList<>();
            var dataSourceCopy = new ArrayList<>(getDataSource());
            dataSourceCopy.removeAll(getPreferredCandidates());
            results.addAll(dataSourceCopy.subList(0, n - getPreferredCandidates().size()));
            return results;
        }
    }
}
