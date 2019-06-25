package view;

import javax.swing.*;
import java.awt.*;

public class SearchResult extends JPanel{
    private JLabel personName;
    private JLabel personLastName;
    private JLabel errorMessage;

    SearchResult(){
        personName = new JLabel("personName");
        personLastName = new JLabel("personLastName");
        errorMessage = new JLabel("errorMessage");
        add(personName);
        add(personLastName);
        add(errorMessage);
    }
}
