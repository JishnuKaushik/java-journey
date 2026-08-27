/*
 * Scenario: sum the digits of a non-negative number, including the
 * edge case of 0, which has exactly one digit (itself).
 *
 * Concept link: A do-while fits best — a "while (n > 0)" loop would skip
 * its body entirely for n = 0 and report a wrong/empty sum, but a
 * do-while guarantees the digit-extraction body runs at least once, so
 * 0 is correctly handled as a one-digit number.
 */
class DigitSummer {
    public int sumDigits(int n) {
        int sum = 0;
        do {
            int digit = n % 10;
            sum += digit;
            n /= 10;
        } while (n > 0);
        return sum;
    }
}

public class Q4_SumDigitsAtLeastOnce {
    public static void main(String[] args) {
        DigitSummer summer = new DigitSummer();
        System.out.println("Input: 1234 -> Output: " + summer.sumDigits(1234));
        System.out.println("Input: 0    -> Output: " + summer.sumDigits(0));
    }
}
