package org.minions.view;

import org.minions.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private SearchAddStudentPanel addSearchPanel;
    private StudentInfoPanel studentInfoPanel;
    private SubjectPanel subjectPanel;
    public MainFrame(){
        super("Student - Subject");
        addSearchPanel = new SearchAddStudentPanel();
        studentInfoPanel = new StudentInfoPanel();
        subjectPanel = new SubjectPanel();

        Container frame = getContentPane();
        GridLayout gridLayout = new GridLayout(3,1);
        frame.setLayout(gridLayout);
        frame.add(addSearchPanel);
        frame.add(studentInfoPanel);
        frame.add(subjectPanel);

        setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        setVisible(true);
        Controller controller = new Controller(addSearchPanel, studentInfoPanel, subjectPanel);
        controller.initController();
    }
}
