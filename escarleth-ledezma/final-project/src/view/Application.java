package view;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {

    public Application() {
        this.setTitle("Student Application");
        this.addComponent();
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void addComponent() {
        this.setLayout(new BorderLayout(5, 5));
        this.getContentPane().add(new SubjectsPanel().getSplitPane(), BorderLayout.CENTER);
        this.getContentPane().add(new StudentPanel(), BorderLayout.NORTH);
    }
}
