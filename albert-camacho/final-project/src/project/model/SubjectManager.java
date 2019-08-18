package project.model;

import project.common.utils.DoubleIterator;
import project.common.utils.DoubleLinkedList;
import project.common.utils.IString;
import project.model.datatype.Subject;

import java.util.*;

public class SubjectManager implements Observer {

    private static Map<Integer, IString<Subject>> strategyDataMap;
    static {
        Map<Integer, IString<Subject>> map = new HashMap<>();
        map.put(0, Subject::getId);
        map.put(1, Subject::getName);
        map.put(2, element -> String.valueOf(element.getGrade()));
        strategyDataMap = Collections.unmodifiableMap(map);
    }

    private DoubleLinkedList<Subject> subjectList;
    private DoubleIterator<Subject> subjectIterator;
    private DataModel<Subject> subjectDataModel;
    private Subject currentSubject;

    public SubjectManager() {
        subjectList = new DoubleLinkedList<>();
        subjectIterator = subjectList.doubleIterator();

        subjectDataModel = new DataModel<>(new String[]{"Id", "Name"});
        subjectDataModel.setStrategyMap(strategyDataMap);
    }

    public boolean addSubject(String id, String name, String grade) {
        Subject subject = new Subject(id, name, Integer.valueOf(grade));

        if (subject.getName().length() > 2 && !subjectExists(id) && subject.getId().length() > 0) {
            currentSubject = subject;
            subjectList.add(subject);
            subjectIterator.set(subject);
            subjectDataModel.updateData(subjectList);
            return true;
        }
        return false;
    }

    public boolean saveSubject(String id, String name, String grade) {
        Subject subject = new Subject(id, name, Integer.valueOf(grade));

        if (subject.getName().length() > 2 && (currentSubject.getId().equals(id) || !subjectExists(id))
                && subject.getId().length() > 0) {
            currentSubject.setId(subject.getId());
            currentSubject.setName(subject.getName());
            currentSubject.setGrade(subject.getGrade());
            return true;
        }
        return false;
    }

    public Subject getCurrentSubject() {
        return currentSubject;
    }

    public void nextSubject() {
        currentSubject = subjectIterator.next();
    }

    public void previousSubject() {
        currentSubject = subjectIterator.previous();
    }

    public Subject getSelectedSubject(int id) {
        currentSubject = subjectList.get(id);
        subjectIterator.set(currentSubject);
        return currentSubject;
    }

    private boolean subjectExists(String id) {
        // Returns TRUE if a student with same RFID exists in the list
        for (Subject subject : subjectList) {
            if (id.equals(subject.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void update(Observable observable, Object arg) {
        StudentManager manager = (StudentManager) observable;
        subjectDataModel.updateData(manager.getSubjectsCurrentStudent());
    }

    public DataModel<Subject> getDataModel() {
        return subjectDataModel;
    }
}
