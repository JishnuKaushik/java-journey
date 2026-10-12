/*
 * Q4. Can a static variable be accessed without creating an object of the
 * class? Justify your answer with an example.
 *
 * Ans: Yes. A static variable belongs to the class itself, not to any
 * individual object, so it can be accessed directly using the class name
 * (ClassName.variable) even before any object is created. All objects of the
 * class also share the same copy — changing it through one object changes it
 * for all.
 */
class Counter {
    static int count = 0;
}

class Test {
    public static void main(String[] args) {
        Counter.count = 5;          // accessed without any object
        System.out.println(Counter.count); // 5
    }
}

public class Q4_StaticAccess {
    public static void main(String[] args) {
        Test.main(args);
    }
}
