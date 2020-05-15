package task;

public class Utils {
    public static <K, V> boolean areEqual(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getValue().equals(p2.getValue()) && p1.getKey().equals(p2.getKey());
    }
}
