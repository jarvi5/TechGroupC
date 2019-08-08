package org.minions.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

import static java.awt.BorderLayout.CENTER;

public class StudentInfoPanel extends JPanel{
    private JLabel firstnameLabel;
    private JLabel lastnameLabel;
    private JLabel firstnameInfo;
    private JLabel lastnameInfo;
    private JButton next;
    private JButton previous;
    private JPanel groupLayoutPanel;

    StudentInfoPanel() {
        // Create UI elements
        firstnameLabel = new JLabel("First Name :");
        lastnameLabel = new JLabel("Last Name :");
        firstnameInfo = new JLabel("Lourdes");
        lastnameInfo = new JLabel("Villca");
        next = new JButton("Next");
        previous = new JButton("Previous");
        groupLayoutPanel = new JPanel();

        TitledBorder border = new TitledBorder("Student Information");
        border.setTitleJustification(TitledBorder.LEFT);
        border.setTitlePosition(TitledBorder.TOP);
        this.setBorder(border);
        setLayout();

    }
    public void setLayout(){
        // add UI element to view

        GroupLayout layout = new GroupLayout(groupLayoutPanel);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(previous)
                        .addComponent(firstnameLabel)
                        .addComponent(lastnameLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(next)
                        .addComponent(firstnameInfo)
                        .addComponent(lastnameInfo)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(previous)
                        .addComponent(next))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(firstnameLabel)
                        .addComponent(firstnameInfo))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lastnameLabel)
                        .addComponent(lastnameInfo)));
        layout.linkSize(SwingConstants.HORIZONTAL, next, previous);
        groupLayoutPanel.setLayout(layout);
        this.setLayout(new FlowLayout());
        this.add(groupLayoutPanel, FlowLayout.CENTER);
    }
}
