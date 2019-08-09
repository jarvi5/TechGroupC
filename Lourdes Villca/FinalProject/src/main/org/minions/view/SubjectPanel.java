package org.minions.view;

import org.minions.MultiList;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class SubjectPanel extends JPanel {
    private JPanel subjectListPanel;
    private JPanel subjectDetailPanel;
    private JButton next;
    private JButton previous;
    private JList<MultiList> subjectList;
    private JLabel idLabel;
    private JLabel name;
    private JLabel finalGrade;

    SubjectPanel() {
        subjectListPanel = new JPanel();
        TitledBorder borderSubjectList = new TitledBorder("Subject List");
        borderSubjectList.setTitleJustification(TitledBorder.LEFT);
        borderSubjectList.setTitlePosition(TitledBorder.TOP);
        subjectListPanel.setBorder(borderSubjectList);

        subjectDetailPanel = new JPanel();
        TitledBorder borderSubjectDetail = new TitledBorder("Subject Detail");
        borderSubjectDetail.setTitleJustification(TitledBorder.LEFT);
        borderSubjectDetail.setTitlePosition(TitledBorder.TOP);
        subjectDetailPanel.setBorder(borderSubjectDetail);

        DefaultListModel listModel = new DefaultListModel();
        listModel.addElement("Jane Doe");
        listModel.addElement("John Smith");
        listModel.addElement("Kathy Green");

        subjectList = new JList<>(listModel);
        subjectList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        subjectList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        subjectList.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(subjectList);



        next = new JButton("Next");
        previous = new JButton("Previous");
        idLabel = new JLabel("TESTTTTTTTTTTTTTTTTT");

        GroupLayout subjectlayout = new GroupLayout(this);
        subjectlayout.setAutoCreateGaps(true);
        subjectlayout.setAutoCreateContainerGaps(false);
        subjectlayout.setHorizontalGroup(subjectlayout.createSequentialGroup()
                .addComponent(subjectListPanel)
                .addComponent(subjectDetailPanel));
        subjectlayout.setVerticalGroup(subjectlayout.createSequentialGroup()
                .addGroup(subjectlayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(subjectListPanel)
                        .addComponent(subjectDetailPanel)));
        subjectlayout.linkSize(SwingConstants.HORIZONTAL, subjectListPanel, subjectDetailPanel);
        this.setLayout(subjectlayout);

        GroupLayout subjectListLayout = new GroupLayout(subjectListPanel);
        subjectListLayout.setAutoCreateGaps(true);
        subjectListLayout.setAutoCreateContainerGaps(true);
        subjectListLayout.setHorizontalGroup(subjectListLayout.createParallelGroup()
                .addGroup(subjectListLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(subjectList)
                        .addGroup(subjectListLayout.createSequentialGroup()
                                .addGroup(subjectListLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(next))
                                .addGroup(subjectListLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(previous)))
        ));
        subjectListLayout.linkSize(SwingConstants.HORIZONTAL, next, previous, subjectList);
        subjectListLayout.setVerticalGroup(subjectListLayout.createSequentialGroup()
                .addGroup(subjectListLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(next)
                        .addComponent(previous))
                .addGroup(subjectListLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)).
                        addComponent(subjectList));

        subjectListPanel.setLayout(subjectListLayout);


    }

}
