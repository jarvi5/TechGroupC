package project.model;

import project.common.utils.DoubleIterator;
import project.common.utils.DoubleList;
import project.common.utils.IString;
import project.common.utils.MultiList;
import project.model.datatype.Student;
import project.model.datatype.Subject;

import java.util.*;

public class StudentManager extends Observable {
    public static final String FIRST_STUDENT = "StudentAtFirstPosition";
    public static final String LAST_STUDENT = "StudentAtLastPosition";

    private MultiList<Student, Subject> studentList;
    private DoubleIterator<Student> studentIterator;
    private DataModel studentDataModel;
    private Student currentStudent;

    public StudentManager() {
        studentList = new MultiList<>();
        studentIterator = studentList.doubleIterator();

        studentDataModel = new DataModel(new String[]{"RFID", "First Name", "Last Name"});
        studentDataModel.setStrategyMap(buildStrategyMap());
    }

    private Map<Integer, IString> buildStrategyMap() {
        Map<Integer, IString> strategyDataMap = new HashMap<>();
        strategyDataMap.put(0, idx -> studentList.get(idx).getRfid());
        strategyDataMap.put(1, idx -> studentList.get(idx).getName());
        strategyDataMap.put(2, idx -> studentList.get(idx).getLastName());

        return strategyDataMap;
    }

    public boolean addStudent(String rfid, String name, String lastName, String atPosition) {
        Student student = new Student(rfid, name, lastName);
        if (validateNewStudent(student)) {
            return addStudentAt(student, atPosition);
        }
        return false;
    }

    private boolean addStudentAt(Student student, String atPosition) {
        boolean result = atPosition.equals(LAST_STUDENT) ? studentList.addLast(student) : studentList.addFirst(student);
        if (result) {
            currentStudent = student;
            studentIterator.set(currentStudent);
            studentDataModel.updateData(studentList);
            setChanged();
            notifyObservers();
        }
        return result;
    }

    private boolean validateNewStudent(Student student) {
        return (student.getName().length() > 2 && !studentExists(student.getRfid()) && student.getRfid().length() > 0);
    }

    public String removeStudent(String atPosition) {
        Student student = atPosition.equals(FIRST_STUDENT) ? studentList.getFirst() : studentList.getLast();
        if (atPosition.equals(FIRST_STUDENT)) {
            studentList.removeFirst();
            updateCurrentAfterRemoveWith(student, studentList.getFirst());
        } else {
            studentList.removeLast();
            updateCurrentAfterRemoveWith(student, studentList.getLast());
        }
        studentDataModel.updateData(studentList);
        return String.format("%s %s",student.getName(), student.getLastName());
    }

    private void updateCurrentAfterRemoveWith(Student student, Student studentToUpdate) {
        if (currentStudent.equals(student)) {
            currentStudent = studentToUpdate;
            studentIterator.set(currentStudent);
        }
    }

//    public Vector<Object> searchStudentBy(String name, String lastName) {
//        Vector<Object> result = new Vector<>();
//
//        for (Student student : studentList) {
//            if (name.contains(student.getName().toLowerCase()) ||
//                    lastName.contains(student.getLastName().toLowerCase())) {
//                Vector<String> studentData = new Vector<>();
//                studentData.add(student.getRfid());
//                studentData.add(student.getName());
//                studentData.add(student.getLastName());
//                result.add(studentData);
//            }
//        }
//        return result;
//    }

    public Student getStudent() {
        return currentStudent;
    }

    public void nextStudent() {
        //studentList.getNext();
        currentStudent = studentIterator.next();
        setChanged();
        notifyObservers();
    }

    public void previousStudent() {
        //studentList.getPrevious();
        currentStudent = studentIterator.previous();
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
        return studentList.getChildList(currentStudent);
    }

    public DataModel getDataModel() {
        return studentDataModel;
    }
}
