package org.minions.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private SearchAddStudentPanel addSearchPanel;
    private StudentInfoPanel studentInfoPanel;
    public MainFrame(){
        super("Student - Subject");
        addSearchPanel = new SearchAddStudentPanel();
        studentInfoPanel = new StudentInfoPanel();
        Container frame = getContentPane();
        frame.add(addSearchPanel);
        frame.add(studentInfoPanel);
        setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        setVisible(true);
    }
}
