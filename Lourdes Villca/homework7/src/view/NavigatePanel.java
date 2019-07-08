package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class NavigatePanel extends JPanel{
    private JLabel personName;
    private JLabel personLastName;
    private JButton next;
    private JButton previous;
    private JPanel buttonPanel;
    private JPanel resultPanel;

    NavigatePanel(){
        buttonPanel = new JPanel();
        resultPanel = new JPanel();
        personName = new JLabel("");
        personLastName = new JLabel("");
        previous = new JButton("Previous");
        next = new JButton("Next");
        setLayout(new GridLayout(0,1));

        Dimension buttonD = new Dimension(700, 100);
        setPreferredSize(buttonD);
        setMinimumSize(buttonD);
        setMaximumSize(buttonD);

        buttonPanel.add(previous);
        buttonPanel.add(next);

        resultPanel.add(personName);
        resultPanel.add(personLastName);

        TitledBorder titled = new TitledBorder("Navigate List");
        this.setBorder(titled);
        add(buttonPanel);
        add(resultPanel);
    }
     public JButton getPrevious(){
        return previous;
     }
     public JButton getNext(){
        return next;
     }
     public void setPersonName(String name){
        personName.setText(name);
     }
     public void setPersonLastName(String lastName){
        personLastName.setText(lastName);
     }

}
