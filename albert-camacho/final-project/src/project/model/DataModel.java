package project.model;

import project.common.utils.DoubleList;
import project.common.utils.IString;

import javax.swing.table.AbstractTableModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DataModel<E> extends AbstractTableModel {
    private String[] columnNames;
    private DoubleList<E> doubleList;
    private Map<Integer, IString<E>> strategyMap;
    private Iterator<E> iterator;
    private E element;

    public DataModel(){
        strategyMap = new HashMap<>();
    }

    public DataModel(String[] columns) {
        this();
        columnNames = columns;
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public void setStrategyMap(Map<Integer, IString<E>> dataMap) {
        strategyMap.clear();
        strategyMap.putAll(dataMap);
    }

    public void updateData(DoubleList<E> list) {
        doubleList = list;
        this.fireTableDataChanged();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public int getRowCount() {
        return doubleList.getSize();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex == 0 && columnIndex == 0) {
            iterator = doubleList.iterator();
        }
        if (columnIndex == 0) {
            element = iterator.next();
        }

        return strategyMap.get(columnIndex).ofElement(element);
    }
}
