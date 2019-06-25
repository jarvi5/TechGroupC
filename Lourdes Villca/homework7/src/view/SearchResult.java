package view;

import javax.swing.*;
import java.awt.*;

public class SearchResult extends JPanel {
    private JLabel personName;
    private JLabel personLastName;
    private JLabel errorMessage;

    SearchResult() {
        personName = new JLabel("");
        personLastName = new JLabel("");
        errorMessage = new JLabel("");
        add(personName);
        add(personLastName);
        add(errorMessage);
    }

    public void setPersonName(String name){
        personName.setText(name);
    }
    public void setPersonLastName(String lastName){
        personLastName.setText(lastName);
    }
    public void setErrorMessage(String errorMessage){
        this.errorMessage.setText(errorMessage);
    }

}
