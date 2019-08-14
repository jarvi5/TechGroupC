package org.minions.view;

import org.minions.model.Subject;
import org.minions.utils.DoubleLinkedList;
import org.minions.utils.MultiList;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class SubjectListPanel extends JPanel {
    private JButton nextButton;
    private JButton previousButton;
    private JButton addSubjectButton;
    private JList<Subject> subjectList;

    SubjectListPanel() {
        TitledBorder borderSubjectList = new TitledBorder("Subject List");
        borderSubjectList.setTitleJustification(TitledBorder.LEFT);
        borderSubjectList.setTitlePosition(TitledBorder.TOP);
        this.setBorder(borderSubjectList);

        subjectList = new JList<>();
        subjectList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Dimension dimension = new Dimension(250, 100);
        subjectList.setPreferredSize(dimension);
        subjectList.setMinimumSize(dimension);
        subjectList.setMaximumSize(dimension);

        subjectList.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(subjectList);

        addSubjectButton = new JButton("Add");
        addSubjectButton.setEnabled(false);
        Icon nextArrow = new ImageIcon("resources/row_down.png");
        Icon previousArrow = new ImageIcon("resources/row_up.png");
        nextButton = new JButton(nextArrow);
        previousButton = new JButton(previousArrow);
        setLayoutPanel();
    }

    private void setLayoutPanel() {
        GroupLayout subjectListLayout = new GroupLayout(this);
        subjectListLayout.setAutoCreateGaps(true);
        subjectListLayout.setAutoCreateContainerGaps(true);
        subjectListLayout.setHorizontalGroup(subjectListLayout.createParallelGroup()
                .addComponent(addSubjectButton)
                .addGroup(subjectListLayout.createSequentialGroup()
                        .addComponent(subjectList)
                        .addGroup(subjectListLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(previousButton)
                                .addComponent(nextButton))));
        subjectListLayout.setVerticalGroup(subjectListLayout.createSequentialGroup()
                .addComponent(addSubjectButton)
                .addGroup(subjectListLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(subjectList)
                        .addGroup(subjectListLayout.createSequentialGroup()
                                .addComponent(previousButton)
                                .addComponent(nextButton))));
        subjectListLayout.linkSize(SwingConstants.HORIZONTAL, nextButton, previousButton);
        this.setLayout(subjectListLayout);
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public void setNextButton(JButton nextButton) {
        this.nextButton = nextButton;
    }

    public JButton getPreviousButton() {
        return previousButton;
    }

    public void setPreviousButton(JButton previousButton) {
        this.previousButton = previousButton;
    }

    public JButton getAddSubjectButton() {
        return addSubjectButton;
    }

    public void setAddSubjectButton(JButton addSubjectButton) {
        this.addSubjectButton = addSubjectButton;
    }

    public JList<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(JList<Subject> subjectList) {
        this.subjectList = subjectList;
    }

}
