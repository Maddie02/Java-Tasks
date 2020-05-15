package task;

import java.util.ArrayList;
import java.util.Arrays;

class OuterClass {
    static int x = 0;
    int foo = 5;

    public OuterClass(int foo) {
        this.foo = foo;
    }

    static class NestedStaticClass {
        void f() {
            System.out.println(x);
            new OuterClass().g();
        }
    }

    class InnerClass {
        void bar() {
            System.out.println(foo);
        }
    }

    public void g() {

    }
}

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 43, 5, 6, 42, 33));
        Histogram<Integer> histogram = new Histogram<>(integers);
        for (var entry : histogram) {

        }
    }
}
