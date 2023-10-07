import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private int enrolledStudents;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = 0;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getAvailableSlots() {
        return capacity - enrolledStudents;
    }

    public boolean enrollStudent() {
        if (enrolledStudents < capacity) {
            enrolledStudents++;
            return true;
        }
        return false;
    }

    public void dropStudent() {
        enrolledStudents--;
    }
}

class Student {
    private int studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        if (course.enrollStudent()) {
            registeredCourses.add(course);
        } else {
            JOptionPane.showMessageDialog(null, "Course is full.");
        }
    }

    public void dropCourse(Course course) {
        course.dropStudent();
        registeredCourses.remove(course);
    }
}

public class CourseRegistrationSystem {
    private static List<Course> courses = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        // Sample data initialization
        initializeSampleData();

        while (true) {
            String[] options = { "Course Listing", "Student Registration", "Course Removal", "Exit" };
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Choose an option:",
                    "Course Registration System",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]);

            switch (choice) {
                case 0:
                    displayCourseListing();
                    break;
                case 1:
                    performStudentRegistration();
                    break;
                case 2:
                    performCourseRemoval();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }

    private static void initializeSampleData() {
        courses.add(new Course("CS101", "Introduction to Programming", "Learn the basics of programming", 30,
                "MWF 10:00 AM"));
        courses.add(new Course("ENG201", "English Composition", "Improve your writing skills", 25, "TTH 2:00 PM"));
        courses.add(new Course("MATH301", "Calculus I", "Study calculus concepts", 40, "MWF 9:00 AM"));
        students.add(new Student(1, "Alice"));
        students.add(new Student(2, "Bob"));
        students.add(new Student(3, "Charlie"));
    }

    private static void displayCourseListing() {
        StringBuilder courseList = new StringBuilder("Available Courses:\n");
        for (Course course : courses) {
            courseList.append(course.getCode()).append(" - ").append(course.getTitle()).append(" (")
                    .append(course.getAvailableSlots()).append(" available slots)\n");
        }
        JOptionPane.showMessageDialog(null, courseList.toString());
    }

    private static void performStudentRegistration() {
        String studentIDString = JOptionPane.showInputDialog("Enter your Student ID:");
        int studentID = Integer.parseInt(studentIDString);
        Student student = findStudent(studentID);

        if (student == null) {
            JOptionPane.showMessageDialog(null, "Student not found.");
            return;
        }

        String[] courseCodes = new String[courses.size()];
        for (int i = 0; i < courses.size(); i++) {
            courseCodes[i] = courses.get(i).getCode();
        }

        String selectedCourseCode = (String) JOptionPane.showInputDialog(
                null,
                "Select a course to register for:",
                "Student Registration",
                JOptionPane.PLAIN_MESSAGE,
                null,
                courseCodes,
                courseCodes[0]);

        Course selectedCourse = findCourse(selectedCourseCode);

        if (selectedCourse != null) {
            student.registerCourse(selectedCourse);
            JOptionPane.showMessageDialog(null, "Registration successful.");
        } else {
            JOptionPane.showMessageDialog(null, "Course not found.");
        }
    }

    private static void performCourseRemoval() {
        String studentIDString = JOptionPane.showInputDialog("Enter your Student ID:");
        int studentID = Integer.parseInt(studentIDString);
        Student student = findStudent(studentID);

        if (student == null) {
            JOptionPane.showMessageDialog(null, "Student not found.");
            return;
        }

        List<Course> registeredCourses = student.getRegisteredCourses();

        if (registeredCourses.isEmpty()) {
            JOptionPane.showMessageDialog(null, "You are not registered for any courses.");
            return;
        }

        String[] courseCodes = new String[registeredCourses.size()];
        for (int i = 0; i < registeredCourses.size(); i++) {
            courseCodes[i] = registeredCourses.get(i).getCode();
        }

        String selectedCourseCode = (String) JOptionPane.showInputDialog(
                null,
                "Select a course to drop:",
                "Course Removal",
                JOptionPane.PLAIN_MESSAGE,
                null,
                courseCodes,
                courseCodes[0]);

        Course selectedCourse = findCourse(selectedCourseCode);

        if (selectedCourse != null) {
            student.dropCourse(selectedCourse);
            JOptionPane.showMessageDialog(null, "Course dropped.");
        } else {
            JOptionPane.showMessageDialog(null, "Course not found.");
        }
    }

    private static Student findStudent(int studentID) {
        for (Student student : students) {
            if (student.getStudentID() == studentID) {
                return student;
            }
        }
        return null;
    }

    private static Course findCourse(String courseCode) {
        for (Course course : courses) {
            if (course.getCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }
}