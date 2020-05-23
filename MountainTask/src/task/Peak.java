package task;

/**
 * Representation of a peak with loaded data from the dataset. The class is
 * immutable. If you wish, you could provide suitable equals() and hashCode()
 * implementations
 */
public class Peak {
    private static final int POSITION = 0;
    private static final int NAME = 1;
    private static final int HEIGHT = 2;
    private static final int PROMINENCE = 3;
    private static final int RANGE = 4;
    private static final int YEAR_OF_FIRST_ASCENT = 5;
    private static final int TOTAL_ASCENTS = 6;

    private final int pos;
    private final String name;
    private final double height;
    private final double prominence;
    private final String range;
    private final int firstAscent;
    private final int totalAscents;

    private Peak(int pos, String name, double height, double prominence, String range, int firstAscent,
                 int totalAscents) {
        this.pos = pos;
        this.name = name;
        this.height = height;
        this.prominence = prominence;
        this.range = range;
        this.firstAscent = firstAscent;
        this.totalAscents = totalAscents;
    }

    public static Peak createPeak(String line) {
        String[] tokens = line.split(",");

        int position = Integer.parseInt(tokens[POSITION]);
        String name = tokens[NAME];
        double height = Double.parseDouble(tokens[HEIGHT]);
        double prominence = Double.parseDouble(tokens[PROMINENCE]);
        String range = tokens[RANGE];
        int yearOfFirstAscent = Integer.parseInt(tokens[YEAR_OF_FIRST_ASCENT]);
        int totalAscents = Integer.parseInt(tokens[TOTAL_ASCENTS]);

        return new Peak(
                position,
                name,
                height,
                prominence,
                range,
                yearOfFirstAscent,
                totalAscents
        );
    }

    public int getPos() {
        return pos;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public double getProminence() {
        return prominence;
    }

    public String getRange() {
        return range;
    }

    public int getFirstAscent() {
        return firstAscent;
    }

    public int getTotalAscents() {
        return totalAscents;
    }
}
