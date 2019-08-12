package project.model;

import project.common.utils.DoubleList;
import project.common.utils.IString;

import javax.swing.table.AbstractTableModel;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class SubjectModel extends AbstractTableModel implements Observer {
    private String[] columnNames = {"ID", "Name"};
    private DoubleList<Subject> subjectList;

    public void setData(DoubleList<Subject> subjects) {
        subjectList = subjects;
        this.fireTableDataChanged();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public boolean addSubject(String id, String name, String grade) {
        Subject subject = new Subject(id, name, Integer.valueOf(grade));

        if (subject.getName().length() > 2 && !subjectExists(id) && subject.getId().length() > 0) {
            return subjectList.add(subject);
        }
        return false;
    }

    public boolean saveSubject(String id, String name, String grade) {
        Subject subject = new Subject(id, name, Integer.valueOf(grade));

        if (subject.getName().length() > 2 && (subjectList.get().getId().equals(id) || !subjectExists(id))
                && subject.getId().length() > 0) {
            subjectList.get().setId(subject.getId());
            subjectList.get().setName(subject.getName());
            subjectList.get().setGrade(subject.getGrade());
            return true;
        }
        return false;
    }

    public void nextSubject() {
        subjectList.getNext();
    }

    public void previousSubject() {
        subjectList.getPrevious();
    }

    public Subject getCurrentSubject() {

        return subjectList.get();
    }

    public Subject getSelectedSubject(int id) {
        return subjectList.get(id);
    }

    @Override
    public int getRowCount() {
        return subjectList.getSize();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Map<Integer, IString> strategyMap = new HashMap<>();
        strategyMap.put(0, () -> subjectList.get(rowIndex).getId());
        strategyMap.put(1, () -> subjectList.get(rowIndex).getName());

        return strategyMap.get(columnIndex).getString();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
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
        setData(manager.getSubjectsCurrentStudent());
    }
}
