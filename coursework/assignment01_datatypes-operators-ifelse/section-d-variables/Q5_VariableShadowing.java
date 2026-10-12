/*
 * Q5. What is variable shadowing? Give an example where a local variable
 * shadows an instance variable, and show how to access the shadowed
 * instance variable using 'this'.
 *
 * Ans: Shadowing happens when a local variable (or parameter) has the same
 * name as an instance variable — inside that method, the local name takes
 * priority and "hides" the instance variable. The instance variable can
 * still be reached explicitly using this.variableName.
 */
class ShadowDemo {
    int x = 10;   // instance variable

    void setX(int x) {   // parameter 'x' shadows instance variable 'x'
        this.x = x;      // 'this.x' refers to the instance variable explicitly
    }
}

public class Q5_VariableShadowing {
    public static void main(String[] args) {
        ShadowDemo demo = new ShadowDemo();
        System.out.println("Before: " + demo.x);  // 10
        demo.setX(42);
        System.out.println("After: " + demo.x);   // 42
    }
}
