import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var next = scanner.next();
        while(!next.equals("stop")) {
             var student = readStudent(next);
             System.out.println(student.toString());
             next = scanner.next();
        }
    }

    private static Student readStudent(String studentInput) {
        Scanner scanner = new Scanner(studentInput);
        scanner.useDelimiter(",");
        String name = scanner.next();
        int number = scanner.nextInt();
        double avrMark = scanner.nextDouble();
        return new Student(name, number, avrMark);
    }
}
