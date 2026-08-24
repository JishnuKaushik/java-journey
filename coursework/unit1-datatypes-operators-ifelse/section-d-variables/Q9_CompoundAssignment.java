/*
 * Q9. What are compound assignment operators? Show how x += 5; can behave
 * differently from x = x + 5; when types don't match exactly.
 *
 * Ans: Compound assignment operators (+=, -=, *=, /=, etc.) combine an
 * operation with assignment in one step. A subtle but important detail:
 * x += 5 implicitly casts the result back to x's original type, whereas
 * x = x + 5 does not — so it can fail to compile if the right-hand side
 * promotes to a wider type.
 *
 * The line below (b = b + 5;) is kept as a comment because it is the
 * documented compile error itself — int cannot be converted to byte without
 * an explicit cast — so it cannot appear as live code in a file that must
 * compile cleanly.
 */
public class Q9_CompoundAssignment {
    public static void main(String[] args) {
        byte b = 10;
        b += 5;         // compiles fine — implicit narrowing cast is inserted automatically
        // b = b + 5;   // ERROR: int cannot be converted to byte without an explicit cast
        b = (byte) (b + 5); // this works — explicit cast required
        System.out.println("b = " + b);
    }
}
