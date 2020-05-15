public class Student {
    private String name;
    private int number;
    private double avrMark;

    public Student(String name, int number, double avrMark) {
        this.name = name;
        this.number = number;
        this.avrMark = avrMark;
    }

    public String getName() {
        return name;
    }

    public double getAvrMark() {
        return avrMark;
    }

    public int getNumber() {
        return number;
    }

    public String toString() {
        return getName() + ", " + getNumber() + ", " + getAvrMark();
    }
}
