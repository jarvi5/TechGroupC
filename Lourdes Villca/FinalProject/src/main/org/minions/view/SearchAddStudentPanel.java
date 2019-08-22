package org.minions.view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class SearchAddStudentPanel extends JPanel {
    private JLabel rfidLabel;
    private JLabel firstnameLabel;
    private JLabel lastnameLabel;
    private JTextField rfidTxt;
    private JTextField firstnameTxt;
    private JTextField lastnameTxt;
    private JLabel checkRfidLabel;
    private JLabel checkFirstnameLabel;
    private JLabel checkLastnameLabel;
    private JButton addButton;
    private JButton searchButton;

    SearchAddStudentPanel() {
        // Create UI elements
        rfidLabel = new JLabel("RFID :");
        firstnameLabel = new JLabel("First Name :");
        lastnameLabel = new JLabel("Last Name :");
        rfidTxt = new JTextField();
        firstnameTxt = new JTextField();
        lastnameTxt = new JTextField();
        checkRfidLabel = new JLabel();
        checkFirstnameLabel = new JLabel();
        checkLastnameLabel = new JLabel();
        checkFirstnameLabel.setForeground(Color.RED);
        checkLastnameLabel.setForeground(Color.RED);
        checkRfidLabel.setForeground(Color.RED);

        addButton = new JButton("Add");
        searchButton = new JButton("Search");

        TitledBorder border = new TitledBorder("Add - Search Student");
        border.setTitleJustification(TitledBorder.LEFT);
        border.setTitlePosition(TitledBorder.TOP);
        this.setBorder(border);
        setPanelLayout();
    }

    private void setPanelLayout() {
        // addButton UI element to view
        GroupLayout layout = new GroupLayout(this);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(rfidLabel)
                        .addComponent(firstnameLabel)
                        .addComponent(lastnameLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(rfidTxt)
                        .addComponent(checkRfidLabel)
                        .addComponent(firstnameTxt)
                        .addComponent(checkFirstnameLabel)
                        .addComponent(lastnameTxt)
                        .addComponent(checkLastnameLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(addButton)
                        .addComponent(searchButton)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(rfidLabel)
                        .addComponent(rfidTxt)
                        .addComponent(addButton))
                .addComponent(checkRfidLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(firstnameLabel)
                        .addComponent(firstnameTxt)
                        .addComponent(searchButton))
                .addComponent(checkFirstnameLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lastnameLabel)
                        .addComponent(lastnameTxt))
                .addComponent(checkLastnameLabel)
        );
        layout.linkSize(SwingConstants.HORIZONTAL, addButton, searchButton, firstnameLabel, lastnameLabel);
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

    public JTextField getFirstnameTxt() {
        return firstnameTxt;
    }

    public void setFirstnameTxt(JTextField firstnameTxt) {
        this.firstnameTxt = firstnameTxt;
    }

    public JTextField getLastnameTxt() {
        return lastnameTxt;
    }

    public void setLastnameTxt(JTextField lastnameTxt) {
        this.lastnameTxt = lastnameTxt;
    }

    public JLabel getCheckFirstnameLabel() {
        return checkFirstnameLabel;
    }

    public void setCheckFirstnameLabel(JLabel checkFirstnameLabel) {
        this.checkFirstnameLabel = checkFirstnameLabel;
    }

    public JLabel getCheckLastnameLabel() {
        return checkLastnameLabel;
    }

    public void setCheckLastnameLabel(JLabel checkLastnameLabel) {
        this.checkLastnameLabel = checkLastnameLabel;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public void setAddButton(JButton addButton) {
        this.addButton = addButton;
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void setSearchButton(JButton searchButton) {
        this.searchButton = searchButton;
    }
    public JLabel getRfidLabel() {
        return rfidLabel;
    }

    public void setRfidLabel(JLabel rfidLabel) {
        this.rfidLabel = rfidLabel;
    }

    public JTextField getRfidTxt() {
        return rfidTxt;
    }

    public void setRfidTxt(JTextField rfidTxt) {
        this.rfidTxt = rfidTxt;
    }

    public JLabel getCheckRfidLabel() {
        return checkRfidLabel;
    }

    public void setCheckRfidLabel(JLabel checkRfidLabel) {
        this.checkRfidLabel = checkRfidLabel;
    }


}

