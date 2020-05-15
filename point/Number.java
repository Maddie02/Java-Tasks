import java.io.PrintStream;

class NumberHelperService {
    public static String formatNumber(int value) {
        return String.format("%d", value);
    }

    public static String formatNumber(double value) {
        return String.format("%f", value);
    }

    public static String formatNumber(String value) {
        return String.format("%f", Double.parseDouble(value));
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println(NumberHelperService.formatNumber(1));
    }
}