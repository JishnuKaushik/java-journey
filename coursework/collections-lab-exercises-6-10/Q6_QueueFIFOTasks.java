/*
 * Exercise 6: Demonstrate a Queue (FIFO): add 4 tasks, then process
 * (remove) them in order.
 */
import java.util.LinkedList;
import java.util.Queue;

public class Q6_QueueFIFOTasks {
    public static void main(String[] args) {
        Queue<String> tasks = new LinkedList<>();

        tasks.offer("Write report");
        tasks.offer("Review code");
        tasks.offer("Fix bug #42");
        tasks.offer("Deploy build");

        System.out.println("Queue after adding tasks: " + tasks);
        System.out.println("Next task (peek): " + tasks.peek());

        System.out.println("Processing tasks in FIFO order:");
        while (!tasks.isEmpty()) {
            String task = tasks.poll();
            System.out.println("  Processed: " + task + "  | remaining: " + tasks);
        }

        System.out.println("Queue is empty: " + tasks.isEmpty());
    }
}
