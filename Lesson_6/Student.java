package Lesson_6;

import java.util.*;

public class Student {
    private String name;
    private String group;
    private int course;
    private Map<String, Integer> grades;

    public Student(String name, String group, int course) {
        if (name == null || group == null) {
            throw new IllegalArgumentException("Имя и группа не могут быть пустыми");
        }
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new HashMap<>();
    }

    public void addGrade(String subject, int grade) {
        if (grade < 1 || grade > 5) {
            throw new IllegalArgumentException("Оценка должна быть от 1 до 5");
        }
        if (subject == null) {
            throw new NullPointerException("Название предмета не может быть пустым");
        }
        Integer previousGrade = grades.put(subject, grade);
        if (previousGrade != null) {
            System.out.println("Обновлена оценка студента " + name +
                    " по предмету '" + subject +
                    "' с " + previousGrade + " на " + grade);
        } else {
            System.out.println("Добавлена новая оценка студента " + name +
                    " по предмету '" + subject + "': " + grade);
        }
    }

    public double calculateAverageGrade() {
        if (grades.isEmpty()) {
            System.out.println("У студента " + name + " нет оценок. Средний балл: 0.0");
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades.values()) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public void promoteToNextCourse() {
        this.course++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Map<String, Integer> getGrades() {
        return new HashMap<>(grades);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", course=" + course +
                ", averageGrade=" + String.format("%.2f", calculateAverageGrade()) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Student student = (Student) o;
        return course == student.course &&
                Objects.equals(name, student.name) &&
                Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group, course);
    }
}

class StudentManager {
    private Set<Student> students;

    public StudentManager() {
        this.students = new HashSet<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeUnderperformingStudents() {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.calculateAverageGrade() < 3.0) {
                iterator.remove();
                System.out.println("Студент " + student.getName() + " отчислен.");
            }
        }
    }

    public void promoteQualifiedStudents() {
        for (Student student : students) {
            if (student.calculateAverageGrade() >= 3.0) {
                student.promoteToNextCourse();
                System.out.println("Студент " + student.getName() + " переведен на курс " + student.getCourse());
            }
        }
    }

    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты на курсе " + course + ":");
        boolean found = false;
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("  - " + student.getName() + " (группа: " + student.getGroup() + ", средний балл: "
                        + String.format("%.2f", student.calculateAverageGrade()) + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("  На данном курсе студентов не найдено.");
        }
    }

    public Set<Student> getStudents() {
        return new HashSet<>(students);
    }
}

class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        Student student1 = new Student("Иван Иванов", "ГРУППА-101", 1);
        student1.addGrade("Математика", 5);
        student1.addGrade("Физика", 4);
        student1.addGrade("История", 5);

        Student student2 = new Student("Петр Петров", "ГРУППА-102", 1);
        student2.addGrade("Математика", 2);
        student2.addGrade("Физика", 3);
        student2.addGrade("История", 2);

        Student student3 = new Student("Мария Сидорова", "ГРУППА-201", 2);
        student3.addGrade("Математика", 4);
        student3.addGrade("Физика", 4);
        student3.addGrade("История", 5);

        Student student4 = new Student("Алексей Смирнов", "ГРУППА-202", 2);
        student4.addGrade("Математика", 3);
        student4.addGrade("Физика", 2);
        student4.addGrade("История", 2);

        manager.addStudent(student1);
        manager.addStudent(student2);
        manager.addStudent(student3);
        manager.addStudent(student4);

        System.out.println("=== Исходный список студентов ===");
        for (Student s : manager.getStudents()) {
            System.out.println(s);
        }
        System.out.println();

        StudentManager.printStudents(manager.getStudents(), 1);
        System.out.println();

        System.out.println("=== Отчисление неуспевающих студентов ===");
        manager.removeUnderperformingStudents();
        System.out.println();

        System.out.println("=== Список студентов после отчисления ===");
        for (Student s : manager.getStudents()) {
            System.out.println(s);
        }
        System.out.println();

        System.out.println("=== Перевод студентов на следующий курс ===");
        manager.promoteQualifiedStudents();
        System.out.println();

        StudentManager.printStudents(manager.getStudents(), 2);
    }
}