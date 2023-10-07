import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();
    private String dataFileName = "student_data.txt";

    public StudentManagementSystem() {
        loadStudentData();
    }

    public void addStudent(Student student) {
        students.add(student);
        saveStudentData();
        System.out.println("Student added successfully.");
    }

    public void removeStudent(int rollNumber) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNumber() == rollNumber) {
                students.remove(i);
                saveStudentData();
                System.out.println("Student removed successfully.");
                return;
            }
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    public void searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private void loadStudentData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(dataFileName));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0].trim();
                    int rollNumber = Integer.parseInt(parts[1].trim());
                    String grade = parts[2].trim();
                    students.add(new Student(name, rollNumber, grade));
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading student data from file.");
        }
    }

    private void saveStudentData() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(dataFileName));
            for (Student student : students) {
                bw.write(student.getName() + ", " + student.getRollNumber() + ", " + student.getGrade() + "\n");
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error saving student data to file.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter grade: ");
                    String grade = scanner.nextLine();
                    system.addStudent(new Student(name, rollNumber, grade));
                    break;
                case 2:
                    System.out.print("Enter roll number to remove: ");
                    int rollToRemove = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    system.removeStudent(rollToRemove);
                    break;
                case 3:
                    System.out.print("Enter roll number to search: ");
                    int rollToSearch = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    system.searchStudent(rollToSearch);
                    break;
                case 4:
                    System.out.println("All Students:");
                    system.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}




