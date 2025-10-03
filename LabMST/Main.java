package LabMST;
import java.util.*;

class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

class StudentList {
    private List<String> students = new ArrayList<>();

    public void addStudent(String name) {
        students.add(name);
    }

    public void removeStudent(String name) {
        students.remove(name);
    }

    public void displayStudents() throws CustomException {
        if (students.isEmpty()) {
            throw new CustomException("Student list is empty!");
        }
        Collections.sort(students);
        System.out.println("Sorted names: " + students);
    }
}

class AverageCalculator {
    public static void execute() {
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter numbers (type 'done' to finish):");

        while (true) {
            String input = sc.next();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                int num = Integer.parseInt(input);
                numbers.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input, please enter a valid integer.");
            }
        }

        try {
            if (numbers.size() == 0) {
                throw new ArithmeticException("List is empty, cannot calculate average.");
            }
            int sum = 0;
            for (int num : numbers) {
                sum += num;
            }
            double avg = (double) sum / numbers.size();
            System.out.println("Average: " + avg);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

public class Main {

    static void executeFirst(){
        StudentList sl = new StudentList();
        sl.addStudent("Alice");
        sl.addStudent("Bob");
        sl.addStudent("Charlie");
        try {
            sl.displayStudents();
        } catch (CustomException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sl.removeStudent("Bob");
        try {
            sl.displayStudents();
        } catch (CustomException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sl.removeStudent("Alice");
        sl.removeStudent("Charlie");
        try {
            sl.displayStudents();
        } catch (CustomException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nMENU ");
            System.out.println("1. Manage Student List");
            System.out.println("2. Calculate Average of Numbers");
            System.out.println("3. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                   executeFirst();
                    break;
                case 2:
                    AverageCalculator.execute();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}