package laba9.task2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class Student {
    private String name;
    private String group;
    private int course;
    private Map<String, Integer> grades; 

    public Student(String name, String group, int course, Map<String, Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public void promoteToNextCourse() {
        this.course++;
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (int grade : grades.values()) {
            sum += grade;
        }
        return sum / grades.size();
    }

    @Override
    public String toString() {
        return "Студент: " + name + ", Группа: " + group + ", Курс: " + course +
               ", Средний балл: " + String.format("%.2f", getAverageGrade());
    }
}

public class StudentProcessor {

    public static void processStudents(List<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3) {
                System.out.println("Студент " + student.getName() + " отчислен со средним баллом " + String.format("%.2f", student.getAverageGrade()));
                iterator.remove();
            } else {
                 System.out.println("Студент " + student.getName() + " переведен на следующий курс.");
                student.promoteToNextCourse();
            }
        }
    }

    public static void printStudents(List<Student> students, int course) {
        System.out.println("\nСтуденты на " + course + " курсе:");
        boolean found = false;
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("- " + student.getName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("На данном курсе нет студентов.");
        }
    }

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Иванов Иван", "Группа 1", 2,
                new HashMap<String, Integer>() {{ put("Математика", 5); put("Физика", 4); put("История", 5); }}));
        studentList.add(new Student("Гредюшка Матвей", "Группа т-318", 2,
                new HashMap<String, Integer>() {{ put("Математика", 2); put("Физика", 3); put("История", 2); }}));
        studentList.add(new Student("Сидорова Анна", "Группа 1", 2,
                new HashMap<String, Integer>() {{ put("Математика", 4); put("Физика", 3); put("История", 3); }}));
        studentList.add(new Student("Смирнов Алексей", "Группа 3", 1,
                new HashMap<String, Integer>() {{ put("Программирование", 5); put("Алгебра", 5); }}));

        System.out.println("--- Исходный список студентов ---");
        studentList.forEach(System.out::println);

        System.out.println("\n--- Обработка студентов: отчисление и перевод ---");
        processStudents(studentList);

        System.out.println("\n--- Итоговый список студентов ---");
        studentList.forEach(System.out::println);

        printStudents(studentList, 3);
        printStudents(studentList, 2);
    }
}