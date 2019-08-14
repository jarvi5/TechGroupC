package view;

import javax.swing.*;
import java.awt.*;

public class StudentPanel extends JPanel {
    private JPanel studentDetailsPanel;
    private JPanel buttonsPanel;
    private JTextField id,name,lastName;
    private JButton previous, next, addStudent, searchStudent;

    public StudentPanel() {
        this.setBorder(BorderFactory.createTitledBorder("Student"));
        this.setLayout(new BorderLayout(5, 5));
        this.initComponents();
        this.addComponents();
    }

    public void initComponents() {
        id = new JTextField();
        name = new JTextField();
        lastName = new JTextField();
        studentDetailsPanel = new JPanel();
        buttonsPanel = new JPanel();
        previous = new JButton("Prev");
        next = new JButton("Next");
        addStudent = new JButton("Save");
        searchStudent = new JButton("Search");
    }

    public void addComponents() {
        studentDetailsPanel.setLayout(new GridLayout(2, 3));
        studentDetailsPanel.add(new JLabel("RFID"));
        studentDetailsPanel.add(new JLabel("Name"));
        studentDetailsPanel.add(new JLabel("Last Name"));
        studentDetailsPanel.add(id);
        studentDetailsPanel.add(name);
        studentDetailsPanel.add(lastName);
        buttonsPanel.setLayout(new GridLayout(4, 1));
        buttonsPanel.add(previous);
        buttonsPanel.add(next);
        buttonsPanel.add(addStudent);
        buttonsPanel.add(searchStudent);

        this.add(buttonsPanel, BorderLayout.EAST);
        this.add(studentDetailsPanel, BorderLayout.CENTER);
    }
}
