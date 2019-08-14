package model;

import model.dataStructure.DoubleLinkedList;
import model.dataStructure.MultiList;

public class ManagerStudent {
    private MultiList<Student, Subject> students;

    public ManagerStudent() {
        this.students = new MultiList<>();
    }

    public void addStudent(String name, String lastName, long RFID){
        Student student = new Student(name, lastName, RFID);
        this.students.addBack(student);
    }

    public void nextStudent(){
        this.students.next();
    }

    public void previousStudent(){
        this.students.previous();
    }

    public void addSubject(String name, String ID, int finalScore){
        Subject subject = new Subject(name,ID, finalScore);
        this.students.addChildToCurrent(subject);
    }

    public void nextSubject(){
        this.students.nextCurrentChild();
    }

    public void previousSubject(){
        this.students.previousCurrentChild();
    }

    public Student searchStudent(String name, String lastName, long RFID){
        Student student = new Student(name, lastName, RFID);
        return this.students.getCurrentValue();
    }

    public MultiList<Student, Subject> getStudents() {
        return this.students;
    }

    public Student student(){
        return this.students.getCurrentValue();
    }

    public DoubleLinkedList<Subject> getCurrentSubjects(){
        return this.students.getCurrentChildrenList();
    }

    public void addStudent(Student student){
        this.students.addBack(student);
    }

}
