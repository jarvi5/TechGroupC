package project.model;

import project.common.MultiList;

import java.util.Vector;

public class StudentManager {
    private MultiList<Student, Subject> studentList;
    private Student currentStudent;

    public StudentManager() {
        studentList = new MultiList<>();
    }

    public MultiList<Student, Subject> getStudentList() {
        return studentList;
    }

    public boolean addStudent(Student student) {
        if (student.getName().length() > 2 && !studentIdExists(student.getRfid()) && student.getRfid().length() > 0) {
            if(currentStudent == null) {
                currentStudent = student;
            }
            return studentList.add(student);
        }
        return false;
    }

    public boolean addStudent(String rfid, String name, String lastName) {
        return addStudent(new Student(rfid, name, lastName));
    }

    public Vector<Object> searchStudentBy(String name, String lastName) {
        Vector<Object> result = new Vector<>();

        for (Student student : studentList) {
            if (name.contains(student.getName().toLowerCase()) ||
                    lastName.contains(student.getLastName().toLowerCase())) {
                Vector<String> studentData = new Vector<>();
                studentData.add(student.getRfid());
                studentData.add(student.getName());
                studentData.add(student.getLastName());
                result.add(studentData);
            }
        }
        return result;
    }

    public Student getCurrentStudent() {
        return currentStudent;
    }

    public Student nextStudent() {
        currentStudent = studentList.getNext(currentStudent);
        return currentStudent;
    }

    public Student previousStudent() {
        currentStudent = studentList.getPrevious(currentStudent);
        return currentStudent;
    }

    public boolean studentIdExists(String rfId) {
        // Returns TRUE if a student with same RFID exists in the list
        for (Student student : studentList) {
            if (rfId.equals(student.getRfid())){
                return true;
            }
        }
        return false;
    }

}
