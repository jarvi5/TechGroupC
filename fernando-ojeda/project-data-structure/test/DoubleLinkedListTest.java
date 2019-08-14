package projectTest;

import org.junit.Test;
import project.DoubleLinkedList;
import project.Student;
import project.Subject;

public class DoubleLinkedListTest<T> {

    @Test
    public void addStudentsTest() {
        Student student1 = new Student("Fer", "Silva");
        Student student2 = new Student("Marta", "Cardenas");
        Student student3 = new Student("Felipa", "Cardona");
        Student student4 = new Student("Daniela", "Caceres");
        Student student5 = new Student("Jose", "Serrano");
        Student student6 = new Student("Nestor", "Cespedes");
        Student student7 = new Student("Carlos", "Fernandez");
        Student student8 = new Student("Daniel", "Coca");
        Student student9 = new Student("David", "Pozo");

        DoubleLinkedList<Student> listDoubleEnlace = new DoubleLinkedList<>();
        listDoubleEnlace.add(student1);
        listDoubleEnlace.add(student2);
        listDoubleEnlace.add(student3);
        listDoubleEnlace.add(student4);
        listDoubleEnlace.add(student5);
        listDoubleEnlace.add(student6);
        listDoubleEnlace.add(student7);
        listDoubleEnlace.add(student8);
        listDoubleEnlace.add(student9);

        Student student = listDoubleEnlace.search(student3);
        System.out.println(student.getName() + " " + student.getLastname());
    }

    @Test
    public void searchStudentsTest() {
        Student student1 = new Student("Fer", "Silva");
        Student student2 = new Student("Marta", "Cardenas");
        Student student3 = new Student("Felipa", "Cardona");
        Student student4 = new Student("Daniela", "Caceres");
        Student student5 = new Student("Jose", "Serrano");
        Student student6 = new Student("Nestor", "Cespedes");
        Student student7 = new Student("Carlos", "Fernandez");
        Student student8 = new Student("Daniel", "Coca");
        Student student9 = new Student("David", "Pozo");

        DoubleLinkedList<Student> listDoubleEnlace = new DoubleLinkedList<>();
        listDoubleEnlace.add(student1);
        listDoubleEnlace.add(student2);
        listDoubleEnlace.add(student3);
        listDoubleEnlace.add(student4);
        listDoubleEnlace.add(student5);
        listDoubleEnlace.add(student6);
        listDoubleEnlace.add(student7);
        listDoubleEnlace.add(student8);
        listDoubleEnlace.add(student9);

        Student student = listDoubleEnlace.search(student3);
        System.out.println(student.getName() + " " + student.getLastname());
    }

    @Test
    public void nextStudentsTest() {
        Student student1 = new Student("Fer", "Silva");
        Student student2 = new Student("Marta", "Cardenas");
        Student student3 = new Student("Felipa", "Cardona");
        Student student4 = new Student("Daniela", "Caceres");
        Student student5 = new Student("Jose", "Serrano");
        Student student6 = new Student("Nestor", "Cespedes");
        Student student7 = new Student("Carlos", "Fernandez");
        Student student8 = new Student("Daniel", "Coca");
        Student student9 = new Student("David", "Pozo");

        DoubleLinkedList<Student> listDoubleEnlace = new DoubleLinkedList<>();
        listDoubleEnlace.add(student1);
        listDoubleEnlace.add(student2);
        listDoubleEnlace.add(student3);
        listDoubleEnlace.add(student4);
        listDoubleEnlace.add(student5);
        listDoubleEnlace.add(student6);
        listDoubleEnlace.add(student7);
        listDoubleEnlace.add(student8);
        listDoubleEnlace.add(student9);

        Student student = listDoubleEnlace.nextData(student3);
        System.out.println(student.getName() + " " + student.getLastname());
    }

    @Test
    public void previousStudentsTest() {
        Student student1 = new Student("Fer", "Silva");
        Student student2 = new Student("Marta", "Cardenas");
        Student student3 = new Student("Felipa", "Cardona");
        Student student4 = new Student("Daniela", "Caceres");
        Student student5 = new Student("Jose", "Serrano");
        Student student6 = new Student("Nestor", "Cespedes");
        Student student7 = new Student("Carlos", "Fernandez");
        Student student8 = new Student("Daniel", "Coca");
        Student student9 = new Student("David", "Pozo");

        DoubleLinkedList<Student> listDoubleEnlace = new DoubleLinkedList<>();
        listDoubleEnlace.add(student1);
        listDoubleEnlace.add(student2);
        listDoubleEnlace.add(student3);
        listDoubleEnlace.add(student4);
        listDoubleEnlace.add(student5);
        listDoubleEnlace.add(student6);
        listDoubleEnlace.add(student7);
        listDoubleEnlace.add(student8);
        listDoubleEnlace.add(student9);

        Student student = listDoubleEnlace.previousData(student3);
        System.out.println(student.getName() + " " + student.getLastname());
    }

    @Test
    public void addSubjectTest() {
        Student student1 = new Student("Fer", "Silva");
        Student student2 = new Student("Marta", "Cardenas");
        Student student3 = new Student("Felipa", "Cardona");
        Student student4 = new Student("Daniela", "Caceres");
        Student student5 = new Student("Jose", "Serrano");
        Student student6 = new Student("Nestor", "Cespedes");
        Student student7 = new Student("Carlos", "Fernandez");
        Student student8 = new Student("Daniel", "Coca");
        Student student9 = new Student("David", "Pozo");

        Subject subject1 = new Subject(11111, "Matematicas", 70);
        Subject subject2 = new Subject(22222, "Matematicas", 50);
        Subject subject3 = new Subject(33333, "Matematicas", 80);
        Subject subject4 = new Subject(44444, "Matematicas", 90);
        Subject subject5 = new Subject(55555, "Matematicas", 100);
        Subject subject6 = new Subject(66666, "Matematicas", 70);
        Subject subject7 = new Subject(77777, "Matematicas", 90);

        DoubleLinkedList<Object> listDoubleEnlace = new DoubleLinkedList<>();
        listDoubleEnlace.add(student1);
        listDoubleEnlace.add(student2);
        listDoubleEnlace.add(student3);
        listDoubleEnlace.add(student4);
        listDoubleEnlace.add(student5);
        listDoubleEnlace.add(student6);
        listDoubleEnlace.add(student7);
        listDoubleEnlace.add(student8);
        listDoubleEnlace.add(student9);

        listDoubleEnlace.addChild(student1, subject1);
        listDoubleEnlace.addChild(student1, subject2);
        listDoubleEnlace.addChild(student1, subject3);

        listDoubleEnlace.addChild(student2, subject4);
        listDoubleEnlace.addChild(student2, subject5);
        listDoubleEnlace.addChild(student2, subject6);

        listDoubleEnlace.addChild(student3, subject1);
        listDoubleEnlace.addChild(student3, subject2);
        listDoubleEnlace.addChild(student3, subject3);

        Subject result = (Subject) listDoubleEnlace.searchChild(student3, subject1);
        System.out.println(result.getId() + " " + result.getNote() + " " + result.getName());
    }

    @Test
    public void searchSubjectTest() {
        Student student1 = new Student("Fer", "Silva");
        Student student2 = new Student("Marta", "Cardenas");
        Student student3 = new Student("Felipa", "Cardona");
        Student student4 = new Student("Daniela", "Caceres");
        Student student5 = new Student("Jose", "Serrano");
        Student student6 = new Student("Nestor", "Cespedes");
        Student student7 = new Student("Carlos", "Fernandez");
        Student student8 = new Student("Daniel", "Coca");
        Student student9 = new Student("David", "Pozo");

        Subject subject1 = new Subject(11111, "Matematicas", 70);
        Subject subject2 = new Subject(22222, "Matematicas", 50);
        Subject subject3 = new Subject(33333, "Matematicas", 80);
        Subject subject4 = new Subject(44444, "Matematicas", 90);
        Subject subject5 = new Subject(55555, "Matematicas", 100);
        Subject subject6 = new Subject(66666, "Matematicas", 70);
        Subject subject7 = new Subject(77777, "Matematicas", 90);

        DoubleLinkedList<Object> listDoubleEnlace = new DoubleLinkedList<>();
        listDoubleEnlace.add(student1);
        listDoubleEnlace.add(student2);
        listDoubleEnlace.add(student3);
        listDoubleEnlace.add(student4);
        listDoubleEnlace.add(student5);
        listDoubleEnlace.add(student6);
        listDoubleEnlace.add(student7);
        listDoubleEnlace.add(student8);
        listDoubleEnlace.add(student9);

        listDoubleEnlace.addChild(student1, subject1);
        listDoubleEnlace.addChild(student1, subject2);
        listDoubleEnlace.addChild(student1, subject3);

        listDoubleEnlace.addChild(student2, subject4);
        listDoubleEnlace.addChild(student2, subject5);
        listDoubleEnlace.addChild(student2, subject6);

        listDoubleEnlace.addChild(student3, subject1);
        listDoubleEnlace.addChild(student3, subject2);
        listDoubleEnlace.addChild(student3, subject3);

        Subject result = (Subject) listDoubleEnlace.searchChild(student3, subject1);
        System.out.println(result.getId() + " " + result.getNote() + " " + result.getName());
    }

    @Test
    public void nextSubjectTest() {
        Student student1 = new Student("Fer", "Silva");
        Student student2 = new Student("Marta", "Cardenas");
        Student student3 = new Student("Felipa", "Cardona");
        Student student4 = new Student("Daniela", "Caceres");
        Student student5 = new Student("Jose", "Serrano");
        Student student6 = new Student("Nestor", "Cespedes");
        Student student7 = new Student("Carlos", "Fernandez");
        Student student8 = new Student("Daniel", "Coca");
        Student student9 = new Student("David", "Pozo");

        Subject subject1 = new Subject(11111, "Matematicas", 70);
        Subject subject2 = new Subject(22222, "Matematicas", 50);
        Subject subject3 = new Subject(33333, "Matematicas", 80);
        Subject subject4 = new Subject(44444, "Matematicas", 90);
        Subject subject5 = new Subject(55555, "Matematicas", 100);
        Subject subject6 = new Subject(66666, "Matematicas", 70);
        Subject subject7 = new Subject(77777, "Matematicas", 90);

        DoubleLinkedList<Object> listDoubleEnlace = new DoubleLinkedList<>();
        listDoubleEnlace.add(student1);
        listDoubleEnlace.add(student2);
        listDoubleEnlace.add(student3);
        listDoubleEnlace.add(student4);
        listDoubleEnlace.add(student5);
        listDoubleEnlace.add(student6);
        listDoubleEnlace.add(student7);
        listDoubleEnlace.add(student8);
        listDoubleEnlace.add(student9);

        listDoubleEnlace.addChild(student1, subject1);
        listDoubleEnlace.addChild(student1, subject2);
        listDoubleEnlace.addChild(student1, subject3);

        listDoubleEnlace.addChild(student2, subject4);
        listDoubleEnlace.addChild(student2, subject5);
        listDoubleEnlace.addChild(student2, subject6);

        listDoubleEnlace.addChild(student3, subject1);
        listDoubleEnlace.addChild(student3, subject2);
        listDoubleEnlace.addChild(student3, subject3);

        Subject result = (Subject) listDoubleEnlace.nextChildData(student3, subject1);
        System.out.println(result.getId() + " " + result.getNote() + " " + result.getName());
    }

    @Test
    public void previousSubjectTest() {
        Student student1 = new Student("Fer", "Silva");
        Student student2 = new Student("Marta", "Cardenas");
        Student student3 = new Student("Felipa", "Cardona");
        Student student4 = new Student("Daniela", "Caceres");
        Student student5 = new Student("Jose", "Serrano");
        Student student6 = new Student("Nestor", "Cespedes");
        Student student7 = new Student("Carlos", "Fernandez");
        Student student8 = new Student("Daniel", "Coca");
        Student student9 = new Student("David", "Pozo");

        Subject subject1 = new Subject(11111, "Matematicas", 70);
        Subject subject2 = new Subject(22222, "Matematicas", 50);
        Subject subject3 = new Subject(33333, "Matematicas", 80);
        Subject subject4 = new Subject(44444, "Matematicas", 90);
        Subject subject5 = new Subject(55555, "Matematicas", 100);
        Subject subject6 = new Subject(66666, "Matematicas", 70);
        Subject subject7 = new Subject(77777, "Matematicas", 90);

        DoubleLinkedList<Object> listDoubleEnlace = new DoubleLinkedList<>();
        listDoubleEnlace.add(student1);
        listDoubleEnlace.add(student2);
        listDoubleEnlace.add(student3);
        listDoubleEnlace.add(student4);
        listDoubleEnlace.add(student5);
        listDoubleEnlace.add(student6);
        listDoubleEnlace.add(student7);
        listDoubleEnlace.add(student8);
        listDoubleEnlace.add(student9);

        listDoubleEnlace.addChild(student1, subject1);
        listDoubleEnlace.addChild(student1, subject2);
        listDoubleEnlace.addChild(student1, subject3);

        listDoubleEnlace.addChild(student2, subject4);
        listDoubleEnlace.addChild(student2, subject5);
        listDoubleEnlace.addChild(student2, subject6);

        listDoubleEnlace.addChild(student3, subject1);
        listDoubleEnlace.addChild(student3, subject2);
        listDoubleEnlace.addChild(student3, subject3);

        Subject result = (Subject) listDoubleEnlace.previousChildData(student3, subject1);
        System.out.println(result.getId() + " " + result.getNote() + " " + result.getName());
    }
}
