package org.minions.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class SubjectDetailPanel extends JPanel {
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel finalGradeLabel;
    private JLabel idInfoLabel;
    private JLabel nameInfoLabel;
    private JLabel finalGradeInfoLabel;

    SubjectDetailPanel() {
        TitledBorder borderSubjectDetail = new TitledBorder("Subject Detail");
        borderSubjectDetail.setTitleJustification(TitledBorder.LEFT);
        borderSubjectDetail.setTitlePosition(TitledBorder.TOP);
        this.setBorder(borderSubjectDetail);

        idLabel = new JLabel("ID:");
        nameLabel = new JLabel("Name:");
        finalGradeLabel = new JLabel("Grade:");

        idInfoLabel = new JLabel();
        nameInfoLabel = new JLabel();
        finalGradeInfoLabel = new JLabel();
        setLayoutPanel();
    }

    private void setLayoutPanel() {
        GroupLayout subjectDetailLayout = new GroupLayout(this);
        subjectDetailLayout.setAutoCreateGaps(true);
        subjectDetailLayout.setAutoCreateContainerGaps(true);
        subjectDetailLayout.setHorizontalGroup(subjectDetailLayout.createSequentialGroup()
                .addGroup(subjectDetailLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(idLabel)
                        .addComponent(nameLabel)
                        .addComponent(finalGradeLabel))
                .addGroup(subjectDetailLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(idInfoLabel)
                        .addComponent(nameInfoLabel)
                        .addComponent(finalGradeInfoLabel)
                )
        );
        subjectDetailLayout.setVerticalGroup(subjectDetailLayout.createSequentialGroup()
                .addGroup(subjectDetailLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(idLabel)
                        .addComponent(idInfoLabel))
                .addGroup(subjectDetailLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nameLabel)
                        .addComponent(nameInfoLabel))
                .addGroup(subjectDetailLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(finalGradeLabel)
                        .addComponent(finalGradeInfoLabel)));
        this.setLayout(subjectDetailLayout);
    }
    public JLabel getIdLabel() {
        return idLabel;
    }

    public void setIdLabel(JLabel idLabel) {
        this.idLabel = idLabel;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public void setNameLabel(JLabel nameLabel) {
        this.nameLabel = nameLabel;
    }

    public JLabel getFinalGradeLabel() {
        return finalGradeLabel;
    }

    public void setFinalGradeLabel(JLabel finalGradeLabel) {
        this.finalGradeLabel = finalGradeLabel;
    }

    public JLabel getIdInfoLabel() {
        return idInfoLabel;
    }

    public void setIdInfoLabel(JLabel idInfoLabel) {
        this.idInfoLabel = idInfoLabel;
    }

    public JLabel getNameInfoLabel() {
        return nameInfoLabel;
    }

    public void setNameInfoLabel(JLabel nameInfoLabel) {
        this.nameInfoLabel = nameInfoLabel;
    }

    public JLabel getFinalGradeInfoLabel() {
        return finalGradeInfoLabel;
    }

    public void setFinalGradeInfoLabel(JLabel finalGradeInfoLabel) {
        this.finalGradeInfoLabel = finalGradeInfoLabel;
    }

}
