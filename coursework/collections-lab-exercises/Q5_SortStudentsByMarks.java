/*
 * Exercise 5: Sort a list of Student objects by marks (descending) using
 * a Comparator. */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return name + " (" + marks + ")";
    }
}

class MarksDescendingComparator implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        return Integer.compare(b.getMarks(), a.getMarks());
    }
}

public class Q5_SortStudentsByMarks {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Aarav", 78));
        students.add(new Student("Diya", 92));
        students.add(new Student("Rohan", 65));
        students.add(new Student("Isha", 88));
        students.add(new Student("Kabir", 92));

        System.out.println("Before sorting:");
        for (Student s : students) {
            System.out.println("  " + s);
        }

        Collections.sort(students, new MarksDescendingComparator());
        // Same thing with a lambda:
        // students.sort((a, b) -> b.getMarks() - a.getMarks());

        System.out.println("After sorting by marks (descending):");
        for (Student s : students) {
            System.out.println("  " + s);
        }
    }
}
