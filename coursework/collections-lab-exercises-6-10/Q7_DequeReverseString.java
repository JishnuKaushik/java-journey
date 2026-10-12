/*
 * Exercise 7: Use a Deque as a stack to reverse the string "HELLO".
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class Q7_DequeReverseString {
    public static void main(String[] args) {
        String word = "HELLO";
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : word.toCharArray()) {
            stack.push(c);
        }
        System.out.println("Stack (top first): " + stack);

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        System.out.println("Original: " + word);
        System.out.println("Reversed: " + reversed);
    }
}
