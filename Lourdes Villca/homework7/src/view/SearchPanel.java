package view;

import java.awt.BorderLayout;
import javax.swing.*;

public class SearchPanel extends JPanel {
    // View uses Swing framework to display UI to user
    private JLabel firstnameLabel;
    private JLabel lastnameLabel;
    private JTextField firstnameTextfield;
    private JTextField lastnameTextfield;
    private JButton add;
    private JButton search;

    SearchPanel() {
        // Create UI elements
        firstnameLabel = new JLabel("Firstname :");
        lastnameLabel = new JLabel("Lastname :");
        firstnameTextfield = new JTextField();
        lastnameTextfield = new JTextField();
        add = new JButton("Add");
        search = new JButton("Search");
        // add UI element to view
        GroupLayout layout = new GroupLayout(this);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(firstnameLabel)
                        .addComponent(lastnameLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(firstnameTextfield)
                        .addComponent(lastnameTextfield))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(add)
                        .addComponent(search)));
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(firstnameLabel)
                        .addComponent(firstnameTextfield).addComponent(add))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lastnameLabel)
                        .addComponent(lastnameTextfield).addComponent(search)));
        layout.linkSize(SwingConstants.HORIZONTAL, add, search);
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
    public JTextField getFirstnameTextfield() {
        return firstnameTextfield;
    }
    public void setFirstnameTextfield(JTextField firstnameTextfield) {
        this.firstnameTextfield = firstnameTextfield;
    }
    public JTextField getLastnameTextfield() {
        return lastnameTextfield;
    }
    public void setLastnameTextfield(JTextField lastnameTextfield) {
        this.lastnameTextfield = lastnameTextfield;
    }
    public JButton getAddButton() {
        return add;
    }
    public void setAdd(JButton add) {
        this.add = add;
    }
    public JButton getSearch() {
        return search;
    }
    public void setSearch(JButton search) {
        this.search = search;
    }
}