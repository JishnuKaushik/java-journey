/*
 * Scenario: keep re-prompting for a positive number until the user
 * enters a valid one.
 *
 * Concept link: A do-while fits best — the first attempt has to happen
 * before there's anything to validate, so the loop's exit check can only
 * run after the body, not before it.
 */
class RetryPrompt {
    public int readPositive(int[] simulatedInputs) {
        int index = 0;
        int value;
        boolean valid;

        do {
            value = simulatedInputs[index];
            index++;
            valid = value > 0;
            System.out.println("Attempt " + index + ": entered " + value
                    + " -> " + (valid ? "valid" : "invalid, retrying"));
        } while (!valid && index < simulatedInputs.length);

        return value;
    }
}

public class Q1_RetryUntilValidInput {
    public static void main(String[] args) {
        RetryPrompt prompt = new RetryPrompt();
        int[] simulatedInputs = {-3, 0, 7}; // pretend these arrive one per prompt
        int accepted = prompt.readPositive(simulatedInputs);
        System.out.println("Final accepted value: " + accepted);
    }
}
