package view;

import javax.swing.*;
import javax.swing.border.TitledBorder;

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
        TitledBorder titled = new TitledBorder("Search Result");
        this.setBorder(titled);
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
