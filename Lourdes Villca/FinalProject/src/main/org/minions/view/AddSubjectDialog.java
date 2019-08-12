package org.minions.view;

import javax.swing.*;
import java.awt.*;

public class AddSubjectDialog extends JDialog {
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel finalGradeLabel;
    private JTextField idTxt;
    private JTextField nameTxt;
    private JTextField finalGradeTxt;
    private JLabel checkIdLabel;
    private JLabel checkNameLabel;
    private JLabel checkFinalGradeLabel;
    private JButton addButton;
    private JButton cancelButton;

    public AddSubjectDialog() {
        // Create UI elements
        idLabel = new JLabel("ID :");
        nameLabel = new JLabel("Name :");
        finalGradeLabel = new JLabel("Final Grade :");
        idTxt = new JTextField();
        nameTxt = new JTextField();
        finalGradeTxt = new JTextField();
        checkIdLabel = new JLabel();
        checkNameLabel = new JLabel();
        checkFinalGradeLabel = new JLabel();
        checkIdLabel.setForeground(Color.RED);
        checkNameLabel.setForeground(Color.RED);
        checkFinalGradeLabel.setForeground(Color.RED);

        addButton = new JButton("Add");
        cancelButton = new JButton("Cancel");
        setPanelLayout();
        this.setVisible(true);
        this.setSize(300,200);
        this.setLocationRelativeTo(null);
    }

    private void setPanelLayout() {
        // addButton UI element to view
        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(idLabel)
                        .addComponent(nameLabel)
                        .addComponent(finalGradeLabel)
                        .addComponent(addButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(idTxt)
                        .addComponent(checkIdLabel)
                        .addComponent(nameTxt)
                        .addComponent(checkNameLabel)
                        .addComponent(finalGradeTxt)
                        .addComponent(checkFinalGradeLabel)
                        .addComponent(cancelButton)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(idLabel)
                        .addComponent(idTxt))
                .addComponent(checkIdLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nameLabel)
                        .addComponent(nameTxt))
                .addComponent(checkNameLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(finalGradeLabel)
                        .addComponent(finalGradeTxt))
                .addComponent(checkFinalGradeLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(addButton)
                        .addComponent(cancelButton))
        );
        layout.linkSize(SwingConstants.HORIZONTAL, addButton, cancelButton);
        getContentPane().setLayout(layout);
       //this.add(groupPanel);
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

    public JTextField getIdTxt() {
        return idTxt;
    }

    public void setIdTxt(JTextField idTxt) {
        this.idTxt = idTxt;
    }

    public JTextField getNameTxt() {
        return nameTxt;
    }

    public void setNameTxt(JTextField nameTxt) {
        this.nameTxt = nameTxt;
    }

    public JTextField getFinalGradeTxt() {
        return finalGradeTxt;
    }

    public void setFinalGradeTxt(JTextField finalGradeTxt) {
        this.finalGradeTxt = finalGradeTxt;
    }

    public JLabel getCheckIdLabel() {
        return checkIdLabel;
    }

    public void setCheckIdLabel(JLabel checkIdLabel) {
        this.checkIdLabel = checkIdLabel;
    }

    public JLabel getCheckNameLabel() {
        return checkNameLabel;
    }

    public void setCheckNameLabel(JLabel checkNameLabel) {
        this.checkNameLabel = checkNameLabel;
    }

    public JLabel getCheckFinalGradeLabel() {
        return checkFinalGradeLabel;
    }

    public void setCheckFinalGradeLabel(JLabel checkFinalGradeLabel) {
        this.checkFinalGradeLabel = checkFinalGradeLabel;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setCancelButton(JButton cancelButton) {
        this.cancelButton = cancelButton;
    }

}
