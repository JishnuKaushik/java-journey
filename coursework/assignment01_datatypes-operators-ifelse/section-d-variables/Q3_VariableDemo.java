/*
 * Q3. Write a Java class demonstrating local, instance, and static
 * variables together.
 *
 * Ans:
 */
class VariableDemo {
    int instanceVar = 10;       // instance variable — one copy per object
    static int staticVar = 100; // static variable — shared by all objects

    void show() {
        int localVar = 5;       // local variable — must be initialized here
        System.out.println("Local: " + localVar);
        System.out.println("Instance: " + instanceVar);
        System.out.println("Static: " + staticVar);
    }

    public static void main(String[] args) {
        new VariableDemo().show();
    }
}

public class Q3_VariableDemo {
    public static void main(String[] args) {
        VariableDemo.main(args);
    }
}
