import com.sun.source.tree.Tree;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    private static ArrayList<Student> findGrade(ArrayList<ArrayList<Student>> school, int grade) {
        for (ArrayList<Student> group : school) {
            if (group.get(0).getGrade() == grade) {
                return group;
            }
        }
        return null;
    }

    private static TreeMap<Integer, TreeSet<Student>> groupByGrade(List<Student> students) {
//        ArrayList<ArrayList<Student>> grades = new ArrayList<>();

        TreeMap<Integer, TreeSet<Student>> grades = new TreeMap<>();

        for (Student student : students) {
//            ArrayList<Student> grade = findGrade(grades, student.getGrade());
            TreeSet<Student> grade = grades.get(student.getGrade());
            if (grade == null) {
                var newGrade = new TreeSet<>(new SortByAvrMark());
                newGrade.add(student);
                grades.put(student.getGrade(), newGrade);
            } else {
                grade.add(student);
            }
        }

        return grades;
    }
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("a1");
        strings.add("mtel");
        strings.add("telenor");
        strings.add(2, "vivacom");

        // Обхождане на списъци
        // Първи начин: стандартно обхождане с for цикъл по дължината на списъка
        for (int i = 0; i < strings.size(); ++i) {
            System.out.println(strings.get(i));
        }

        // Втори начин: чрез for цикъл с итератор
        for (Iterator<String> stringsIterator = strings.iterator();
             stringsIterator.hasNext();) {
            System.out.println(stringsIterator.next());
        }

        // Трети начин: чрез while цикъл с итератор - като горното, но по-четимо
        Iterator<String> stringsIterator = strings.iterator();
        while (stringsIterator.hasNext()) {
            System.out.println(stringsIterator.next());
        }

        // Четвърти начин: с добре познатата ни "for-each" конструкция
        for (String string : strings) {
            System.out.println(string);
        }

        // Тук използваме wrapper типа Integer вместо примитивния тип int, тъй
        // като Java не позволява да подаваме примитивни типове като типови
        // аргументи
        LinkedList<Integer> ints = new LinkedList<>();
        int x = 42;
        ints.add(x);
        ints.add(21);
        ints.add(33);

        // Имаме и специален итератор за списъци - ListIterator<T>, който ни
        // дава повече възможности за обхождане и модифициране на списъка (можем
        // да обхождаме и в двете посоки, можем да вмъкваме и елементи в
        // списъка)
        ListIterator<Integer> intsIterator = ints.listIterator();

        // Модифицирането на списъка чрез методи на списъка, след като сме взели
        // итератор към елементите на списъка, води то хвърлянето на
        // ConcurrentModificationException, за да се предотврати неочаквано
        // поведение при работата със списъка
        // ints.add(32); // тази модификация ще предизвика горното изключение
        // при следващото използване на итератора

        // Добавяме 1 след всеки елемент на списъка
        while (intsIterator.hasNext()) {
            System.out.println(intsIterator.next());
            intsIterator.add(1);
        }

        // Обхождаме списъка от края към началото му
        while (intsIterator.hasPrevious()) {
            System.out.println(intsIterator.previous());
        }

        Collections.sort(strings);
        for (String string : strings) {
            System.out.println(string);
        }

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Yoan", 15, 11));
        students.add(new Student("Ivan", 13, 11));
        students.add(new Student("Petar", 10, 9));

        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student.getName());
        }

        TreeMap<Integer, TreeSet<Student>> grades = groupByGrade(students);
        for (var grade : grades.entrySet()) {
            System.out.println("Grade " + grade.getKey() + ": ");
            for (var student: grade.getValue()) {
                System.out.println(student.getName() + ", " + student.getAverageMark());
            }
        }
    }
}