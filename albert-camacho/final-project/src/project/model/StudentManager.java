package project.model;

import project.common.utils.DoubleList;
import project.common.utils.MultiList;

import java.util.Observable;
import java.util.Vector;

public class StudentManager extends Observable {
    private MultiList<Student, Subject> studentList;

    public StudentManager() {
        studentList = new MultiList<>();
    }

    public boolean addStudent(String rfid, String name, String lastName) {
        if (name.length() > 2 && !studentExists(rfid) && rfid.length() > 0) {
            Student student = new Student(rfid, name, lastName);
            if (studentList.add(student)) {
                setChanged();
                notifyObservers();
                return true;
            }
        }
        return false;
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
        return studentList.get();
    }

    public void nextStudent() {
        studentList.getNext();
        setChanged();
        notifyObservers();
    }

    public void previousStudent() {
        studentList.getPrevious();
        setChanged();
        notifyObservers();
    }

    private boolean studentExists(String rfId) {
        // Returns TRUE if a student with same RFID exists in the list
        for (Student student : studentList) {
            if (rfId.equals(student.getRfid())) {
                return true;
            }
        }
        return false;
    }

    public DoubleList<Subject> getSubjectsCurrentStudent() {
        return studentList.getChildList();
    }
}
