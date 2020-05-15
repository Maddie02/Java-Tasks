class Point {
    private double x;
    private double y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(double x, double y1) {
        this.x = x;
        y = y1;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void print() {
        System.out.println(String.format("%.2f, %f", getX(), getY()));
        System.out.println("(" + getX() + " " + getY() + ")");
    }
}

class Main {
    public static void main(String[] args) {
        Point point = new Point(1, 2); /* референция на нова точка */
        point.print();
    }
}