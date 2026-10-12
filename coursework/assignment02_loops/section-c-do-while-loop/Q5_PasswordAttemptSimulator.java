/*
 * Scenario: simulate a limited number of password attempts, where the
 * first attempt always has to happen before the attempt count can even
 * be checked against the limit.
 *
 * Concept link: A do-while fits best — you can't know an attempt failed
 * until after it's made, so the failure/limit check necessarily comes
 * after the body runs, not before.
 */
class PasswordAttempts {
    public boolean attemptLogin(String correctPassword, String[] simulatedAttempts, int maxAttempts) {
        int tries = 0;
        String attempt;
        boolean success;

        do {
            attempt = simulatedAttempts[tries];
            tries++;
            success = attempt.equals(correctPassword);
            System.out.println("Attempt " + tries + ": \"" + attempt + "\" -> "
                    + (success ? "correct" : "incorrect"));
        } while (!success && tries < maxAttempts && tries < simulatedAttempts.length);

        return success;
    }
}

public class Q5_PasswordAttemptSimulator {
    public static void main(String[] args) {
        PasswordAttempts login = new PasswordAttempts();
        String[] simulatedAttempts = {"letmein", "password1", "java123"};
        boolean result = login.attemptLogin("java123", simulatedAttempts, 3);
        System.out.println("Login result: " + (result ? "granted" : "denied"));
    }
}
