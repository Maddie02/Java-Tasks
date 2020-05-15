import java.util.Comparator;

public class SortByAvrMark implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
//        Double o1Mark = o1.getAverageMark();
//        return o1Mark.compareTo(o2.getAverageMark());
        return Double.compare(o1.getAverageMark(), o2.getAverageMark());
    }
}
