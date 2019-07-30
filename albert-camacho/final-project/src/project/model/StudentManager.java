package project.model;

import project.common.DoubleList;
import project.common.MultiList;

import java.util.Vector;

public class StudentManager {
    private MultiList<Student, Subject> studentList;
    private DoubleList<Subject> subjectList;
    private Student currentStudent;
    private Subject currentSubject;

    public StudentManager() {
        studentList = new MultiList<>();
    }

//    public MultiList<Student, Subject> getStudentList() {
//        return studentList;
//    }

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

    public boolean saveSubject(String id, String name, String grade, int index) {
        //Adds a subject to the current student
        subjectList = studentList.getChildList(currentStudent);
        Subject subject = new Subject(id, name, Integer.valueOf(grade));

        if (subject.getName().length() > 2 && !subjectIdExists(id) && subject.getId().length() > 0) {
            if (currentSubject == null) {
                currentSubject = subject;
            }
            // add subject at last or update an existing by index
            if (subjectList.getSize() <= index) {
                return studentList.addChild(currentStudent, subject);
            }
            //TODO: add 'else' to retrieve subject by index and update its values
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
        return currentStudent;
    }

    public Student nextStudent() {
        currentStudent = studentList.getNext(currentStudent);
        subjectList = studentList.getChildList(currentStudent);
        return currentStudent;
    }

    public Student previousStudent() {
        currentStudent = studentList.getPrevious(currentStudent);
        subjectList = studentList.getChildList(currentStudent);
        return currentStudent;
    }

    public Subject nextSubject() {
        currentSubject = subjectList.getNext(currentSubject);
        return currentSubject;
    }

    public Subject previousSubject() {
        currentSubject = subjectList.getPrevious(currentSubject);
        return currentSubject;
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

    public boolean subjectIdExists(String id) {
        // Returns TRUE if a student with same RFID exists in the list
        for (Subject subject : studentList.getChildList(currentStudent)) {
            if (id.equals(subject.getId())){
                return true;
            }
        }
        return false;
    }

    public Vector<Object> getSubjectVector() {
        // returns a vector of Subject objects in the current student
        Vector<Object> result = new Vector<>();
        for (Subject subject : studentList.getChildList(currentStudent)) {
            Vector<String> subjectData = new Vector<>();
            subjectData.add(subject.getId());
            subjectData.add(subject.getName());
            result.add(subjectData);
        }
        return result;
    }

    public Subject getSelectedSubject(int id) {
        currentSubject = subjectList.get(id);
        return currentSubject;
    }

//    public Subject getCurrentSubject(){
//        return currentSubject;
//    }

}
