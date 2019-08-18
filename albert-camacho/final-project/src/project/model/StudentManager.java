package project.model;

import project.common.utils.DoubleIterator;
import project.common.utils.DoubleList;
import project.common.utils.IString;
import project.common.utils.MultiList;
import project.model.datatype.Student;
import project.model.datatype.Subject;

import java.util.*;

public class StudentManager extends Observable {
    private static Map<Integer, IString<Student>> strategyDataMap;
    static {
        Map<Integer, IString<Student>> map = new HashMap<>();
        map.put(0, Student::getRfid);
        map.put(1, Student::getName);
        map.put(2, Student::getLastName);
        strategyDataMap = Collections.unmodifiableMap(map);
    }

    private MultiList<Student, Subject> studentList;
    private DoubleIterator<Student> studentIterator;
    private DataModel<Student> studentDataModel;
    private Student currentStudent;

    public StudentManager() {
        studentList = new MultiList<>();
        studentIterator = studentList.doubleIterator();

        studentDataModel = new DataModel<>(new String[]{"RFID", "First Name", "Last Name"});
        studentDataModel.setStrategyMap(strategyDataMap);
    }

    public boolean addStudent(String rfid, String name, String lastName) {
        if (name.length() > 2 && !studentExists(rfid) && rfid.length() > 0) {
            Student student = new Student(rfid, name, lastName);
            if (studentList.add(student)) {
                currentStudent = student;
                studentIterator.set(currentStudent);

                studentDataModel.updateData(studentList);

                setChanged();
                notifyObservers();
                return true;
            }
        }
        return false;
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

    public Student getCurrentStudent() {
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

    public DataModel<Student> getDataModel() {
        return studentDataModel;
    }
}
