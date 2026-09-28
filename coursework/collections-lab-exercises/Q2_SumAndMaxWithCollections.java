/*
 * Exercise 2: Read 6 integers into a List and print the sum and the
 * maximum using the Collections class.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q2_SumAndMaxWithCollections {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.println("Enter 6 integers:");
        for (int i = 0; i < 6; i++) {
            numbers.add(sc.nextInt());
        }

        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }

        System.out.println("List: " + numbers);
        System.out.println("Sum: " + sum);
        System.out.println("Maximum: " + Collections.max(numbers));

        sc.close();
    }
}
