class Point {
    public double x;
    public double y;
}

class ShowPoint {
    public static void main(String[] args) {
        Point point1 = new Point();
        point1.x = 3;
        point1.y = 4;
        
        Point point3 = new Point();
        point3.x = point1.x;
        point3.y = point1.y;

        Point point2 = point1;
        point2.y = 42;

        System.out.println("x = " + point1.x);
        System.out.println("y = " + point1.y);

        System.out.println("x = " + point2.x);
        System.out.println("y = " + point2.y);

        System.out.println("x = " + point3.x);
        System.out.println("y = " + point3.y);

    }
}