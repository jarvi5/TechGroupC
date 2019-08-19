package project.model;

import project.common.utils.DoubleList;
import project.common.utils.IString;

import javax.swing.table.AbstractTableModel;
import java.util.HashMap;
import java.util.Map;

public class DataModel extends AbstractTableModel {
    private String[] columnNames;
    private DoubleList doubleList;
    private Map<Integer, IString> strategyMap;

    public DataModel() {
        strategyMap = new HashMap<>();
    }

    public DataModel(String[] columns) {
        this();
        columnNames = columns;
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }

    public void setStrategyMap(Map<Integer, IString> dataMap) {
        strategyMap.clear();
        strategyMap.putAll(dataMap);
    }

    public void updateData(DoubleList list) {
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
        return strategyMap.get(columnIndex).inRow(rowIndex);
    }
}
