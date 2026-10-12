/*
 * Q10. Write a program that declares one instance variable of each primitive
 * data type (without initializing them) and prints their default values.
 *
 * Ans: This demonstrates that instance variables always receive a
 * JVM-assigned default value, unlike local variables.
 */
class DefaultValues {
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    char c;
    boolean bool;

    void printDefaults() {
        System.out.println("byte: " + b);       // 0
        System.out.println("short: " + s);      // 0
        System.out.println("int: " + i);        // 0
        System.out.println("long: " + l);       // 0
        System.out.println("float: " + f);      // 0.0
        System.out.println("double: " + d);     // 0.0
        System.out.println("char: [" + c + "]"); // prints a null character (invisible)
        System.out.println("boolean: " + bool); // false
    }

    public static void main(String[] args) {
        new DefaultValues().printDefaults();
    }
}

public class Q10_DefaultValuesDemo {
    public static void main(String[] args) {
        DefaultValues.main(args);
    }
}
