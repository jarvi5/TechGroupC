package org.minions.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class StudentInfoPanel extends JPanel {
    private JLabel rfidLabel;
    private JLabel firstnameLabel;
    private JLabel lastnameLabel;
    private JLabel rfidInfoLabel;
    private JLabel firstnameInfo;
    private JLabel lastnameInfo;
    private JButton nextButton;
    private JButton previousButton;

    StudentInfoPanel() {
        // Create UI elements
        rfidLabel = new JLabel("RFID :");
        firstnameLabel = new JLabel("First Name :");
        lastnameLabel = new JLabel("Last Name :");
        firstnameInfo = new JLabel();
        lastnameInfo = new JLabel();
        rfidInfoLabel = new JLabel();

        Icon nextArrow = new ImageIcon("resources/row_right.png");
        Icon previuosArrow = new ImageIcon("resources/row_left.png");
        nextButton = new JButton(nextArrow);
        previousButton = new JButton(previuosArrow);

        TitledBorder border = new TitledBorder("Student Information");
        border.setTitleJustification(TitledBorder.LEFT);
        border.setTitlePosition(TitledBorder.TOP);
        this.setBorder(border);
        setPanelLayout();
    }

    private void setPanelLayout() {
        GroupLayout layout = new GroupLayout(this);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                        GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(previousButton)
                        .addComponent(rfidLabel)
                        .addComponent(firstnameLabel)
                        .addComponent(lastnameLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(nextButton)
                        .addComponent(rfidInfoLabel)
                        .addComponent(firstnameInfo)
                        .addComponent(lastnameInfo))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                        GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(previousButton)
                        .addComponent(nextButton))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(rfidLabel)
                        .addComponent(rfidInfoLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(firstnameLabel)
                        .addComponent(firstnameInfo))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lastnameLabel)
                        .addComponent(lastnameInfo)));
        this.setLayout(layout);
    }

    public JLabel getFirstnameLabel() {
        return firstnameLabel;
    }

    public void setFirstnameLabel(JLabel firstnameLabel) {
        this.firstnameLabel = firstnameLabel;
    }

    public JLabel getLastnameLabel() {
        return lastnameLabel;
    }

    public void setLastnameLabel(JLabel lastnameLabel) {
        this.lastnameLabel = lastnameLabel;
    }

    public JLabel getFirstnameInfo() {
        return firstnameInfo;
    }

    public void setFirstnameInfo(JLabel firstnameInfo) {
        this.firstnameInfo = firstnameInfo;
    }

    public JLabel getLastnameInfo() {
        return lastnameInfo;
    }

    public void setLastnameInfo(JLabel lastnameInfo) {
        this.lastnameInfo = lastnameInfo;
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

    public JLabel getRfidLabel() {
        return rfidLabel;
    }

    public void setRfidLabel(JLabel rfidLabel) {
        this.rfidLabel = rfidLabel;
    }

    public JLabel getRfidInfoLabel() {
        return rfidInfoLabel;
    }

    public void setRfidInfoLabel(JLabel rfidInfoLabel) {
        this.rfidInfoLabel = rfidInfoLabel;
    }

}
