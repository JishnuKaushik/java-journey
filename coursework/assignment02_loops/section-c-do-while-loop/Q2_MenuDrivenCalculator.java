/*
 * Scenario: a menu-driven calculator that must display the menu and run
 * at least one operation before it can even ask whether to exit.
 *
 * Concept link: A do-while fits best — the exit check comes after the
 * menu is displayed and acted on, never before, matching how a menu loop
 * actually needs to behave.
 */
class MenuCalculator {
    private final int a;
    private final int b;

    MenuCalculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void run(int[] simulatedChoices) {
        int index = 0;
        int choice;

        do {
            choice = simulatedChoices[index];
            index++;
            switch (choice) {
                case 1:
                    System.out.println("Add: " + a + " + " + b + " = " + (a + b));
                    break;
                case 2:
                    System.out.println("Subtract: " + a + " - " + b + " = " + (a - b));
                    break;
                case 3:
                    System.out.println("Multiply: " + a + " * " + b + " = " + (a * b));
                    break;
                case 4:
                    System.out.println("Exiting calculator.");
                    break;
                default:
                    System.out.println("Unknown choice.");
            }
        } while (choice != 4 && index < simulatedChoices.length);
    }
}

public class Q2_MenuDrivenCalculator {
    public static void main(String[] args) {
        MenuCalculator calc = new MenuCalculator(6, 3);
        int[] simulatedChoices = {1, 3, 4}; // 1=add 2=subtract 3=multiply 4=exit
        calc.run(simulatedChoices);
    }
}
