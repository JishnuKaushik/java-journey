/*
 * Scenario: guess a target number; the player always gets at least one
 * guess before the game can check whether they've won.
 *
 * Concept link: A do-while fits best — a guessing game can't evaluate a
 * win/lose condition until after a guess is made, so the body must run
 * before the check.
 */
class GuessingGame {
    public void play(int target, int[] simulatedGuesses) {
        int index = 0;
        int guess;

        do {
            guess = simulatedGuesses[index];
            index++;
            if (guess < target) {
                System.out.println("Guess " + guess + " -> too low");
            } else if (guess > target) {
                System.out.println("Guess " + guess + " -> too high");
            } else {
                System.out.println("Guess " + guess + " -> correct!");
            }
        } while (guess != target && index < simulatedGuesses.length);
    }
}

public class Q3_NumberGuessingGame {
    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        int target = 42;
        int[] simulatedGuesses = {10, 60, 42};
        System.out.println("Target: " + target);
        game.play(target, simulatedGuesses);
    }
}
