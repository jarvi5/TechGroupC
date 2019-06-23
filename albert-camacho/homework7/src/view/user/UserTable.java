package view.user;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class UserTable {
    private DefaultTableModel model;
    private JTable table;

    private final static Vector<String> columNames = new Vector<>(Arrays.asList("Name", "Last Name"));

    public UserTable(){
        super();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columNames);

        table = new JTable(model){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    public JTable getTable(){
        return table;
    }

    public void loadData(Vector data){
        clearTable();
        model.setDataVector(data, columNames);
        table.setModel(model);
    }

    public void clearTable(){
        model.setRowCount(0);
    }

}
