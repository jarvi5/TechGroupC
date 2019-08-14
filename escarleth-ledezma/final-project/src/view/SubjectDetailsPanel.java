package view;

import javax.swing.*;
import java.awt.*;

public class SubjectDetailsPanel extends JPanel {
    private JTextField subjectId, subjectName, finalScore;
    private JButton saveSubject;
    private JPanel subjectDetailsPanel, buttonsPanel;

    public SubjectDetailsPanel() {
        this.setBorder(BorderFactory.createTitledBorder("Subject Details"));
        this.setLayout(new BorderLayout(5, 5));
        this.initComponents();
        this.addComponents();
    }

    public void initComponents() {
        subjectId = new JTextField();
        subjectName = new JTextField();
        finalScore = new JTextField();
        subjectDetailsPanel = new JPanel();
        buttonsPanel = new JPanel();
        saveSubject = new JButton("Save");
    }

    public void addComponents() {
        subjectDetailsPanel.setLayout(new GridLayout(6, 1));
        subjectDetailsPanel.add(new JLabel("ID"));
        subjectDetailsPanel.add(subjectId);
        subjectDetailsPanel.add(new JLabel("Subject"));
        subjectDetailsPanel.add(subjectName);
        subjectDetailsPanel.add(new JLabel("Final Score"));
        subjectDetailsPanel.add(finalScore);
        buttonsPanel.setLayout(new GridLayout(1, 1));
        buttonsPanel.add(saveSubject);
        this.add(subjectDetailsPanel, BorderLayout.CENTER);
        this.add(buttonsPanel, BorderLayout.SOUTH);
    }
}
