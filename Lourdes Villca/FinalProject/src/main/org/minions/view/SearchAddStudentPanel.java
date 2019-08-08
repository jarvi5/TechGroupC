package org.minions.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class SearchAddStudentPanel extends JPanel {
    private JLabel firstnameLabel;
    private JLabel lastnameLabel;
    private JTextField firstnameTextfield;
    private JTextField lastnameTextfield;
    private JButton add;
    private JButton search;

    SearchAddStudentPanel() {
        // Create UI elements
        firstnameLabel = new JLabel("Firstname :");
        lastnameLabel = new JLabel("Lastname :");
        firstnameTextfield = new JTextField();
        lastnameTextfield = new JTextField();
        add = new JButton("Add");
        search = new JButton("Search");

        TitledBorder border = new TitledBorder("Add - Search Student");
        border.setTitleJustification(TitledBorder.LEFT);
        border.setTitlePosition(TitledBorder.TOP);
        this.setBorder(border);
        setLayout();

    }
    public void setLayout(){
        // add UI element to view
        GroupLayout layout = new GroupLayout(this);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(firstnameLabel)
                        .addComponent(lastnameLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(firstnameTextfield)
                        .addComponent(lastnameTextfield))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(add)
                        .addComponent(search)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(firstnameLabel)
                        .addComponent(firstnameTextfield)
                        .addComponent(add))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lastnameLabel)
                        .addComponent(lastnameTextfield)
                        .addComponent(search)));
        this.setLayout(layout);
    }
}

