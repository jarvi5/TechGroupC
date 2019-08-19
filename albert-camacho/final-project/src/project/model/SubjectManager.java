package project.model;

import project.common.utils.DoubleIterator;
import project.common.utils.DoubleLinkedList;
import project.common.utils.IString;
import project.model.datatype.Subject;

import java.util.*;

public class SubjectManager implements Observer {

    private DoubleLinkedList<Subject> subjectList;
    private DoubleIterator<Subject> subjectIterator;
    private DataModel subjectDataModel;
    private Subject currentSubject;

    public SubjectManager() {
        subjectList = new DoubleLinkedList<>();
        subjectIterator = subjectList.doubleIterator();

        subjectDataModel = new DataModel(new String[]{"Id", "Name"});
        subjectDataModel.setStrategyMap(buildStrategyMap());
    }

    private Map<Integer, IString> buildStrategyMap() {
        Map<Integer, IString> strategyDataMap = new HashMap<>();
        strategyDataMap.put(0, idx -> subjectList.get(idx).getId());
        strategyDataMap.put(1, idx -> subjectList.get(idx).getName());
        strategyDataMap.put(2, idx -> String.valueOf(subjectList.get(idx).getGrade()));

        return strategyDataMap;
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

    public DataModel getDataModel() {
        return subjectDataModel;
    }
}
