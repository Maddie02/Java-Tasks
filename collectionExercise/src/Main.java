import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String[] operators = {"a1", "telenor", "mtel", "vivavom"};

        List<String> operatorsList = Arrays.asList(operators);

        LengthRating lengthRating = new LengthRating(operatorsList);
        var top3 = lengthRating.top(3);
        for (var candidate : top3) {
            System.out.println(candidate);
        }
    }
}
