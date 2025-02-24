import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " - Marks: " + marks;
    }
}

public class StudentFilter {
    public static void main(String[] args) {
        // List of students
        List<Student> students = Arrays.asList(
            new Student("Alice", 85),
            new Student("Bob", 70),
            new Student("Charlie", 90),
            new Student("David", 60),
            new Student("Eve", 95),
            new Student("Frank", 76)
        );

        // Filter students with marks > 75, sort by marks (descending), and extract names
        List<String> topStudents = students.stream()
            .filter(s -> s.marks > 75) // Filter students scoring above 75%
            .sorted(Comparator.comparingDouble(s -> -s.marks)) // Sort by marks in descending order
            .map(s -> s.name) // Extract names
            .collect(Collectors.toList()); // Collect names in a list

        // Display result
        System.out.println("Top Students: " + topStudents);
    }
}
