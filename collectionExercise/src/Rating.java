import java.util.ArrayList;
import java.util.List;

public abstract class Rating {
    private List<String> dataSource;

    public Rating(List<String> candidates) {}

    public void setDataSource(List<String> candidates) {
        // prevent making modifications on the original list
        dataSource = new ArrayList<>(candidates);
    }

    public List<String> getDataSource() {
        return dataSource;
    }

    public abstract ArrayList<String> top(int n);
}
