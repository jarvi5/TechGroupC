package org.minions.view;

import javax.swing.*;
import java.awt.*;


public class SubjectPanel extends JPanel {
    private SubjectListPanel subjectListPanel;
    private SubjectDetailPanel subjectDetailPanel;

    SubjectPanel() {
        subjectListPanel = new SubjectListPanel();
        subjectDetailPanel = new SubjectDetailPanel();

        GridLayout gridLayout = new GridLayout(0, 2);
        this.setLayout(gridLayout);
        this.add(subjectListPanel);
        this.add(subjectDetailPanel);
    }
    public SubjectListPanel getSubjectListPanel() {
        return subjectListPanel;
    }

    public void setSubjectListPanel(SubjectListPanel subjectListPanel) {
        this.subjectListPanel = subjectListPanel;
    }

    public SubjectDetailPanel getSubjectDetailPanel() {
        return subjectDetailPanel;
    }

    public void setSubjectDetailPanel(SubjectDetailPanel subjectDetailPanel) {
        this.subjectDetailPanel = subjectDetailPanel;
    }
}
