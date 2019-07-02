package controller;

import model.Person;
import view.NavigatePanel;
import view.SearchPanel;
import view.SearchResult;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static java.lang.System.out;

public class Controller {
    private Person person;
    private SearchPanel searchPanel;
    private NavigatePanel navigatePanel;
    private SearchResult searchResult;
    private ArrayList<Person> personList;

    public Controller(SearchPanel searchPanel, NavigatePanel navigatePanel, SearchResult resultPanel) {
        this.searchPanel = searchPanel;
        this.navigatePanel = navigatePanel;
        this.searchResult = resultPanel;
        personList = new ArrayList<>();
    }

    public void initController() {
        searchPanel.getAddButton().addActionListener(e -> {
            if (verifyTextField(searchPanel.getFirstnameTextfield().getText(), searchPanel.getLastnameTextfield().getText()))
            {
                addPerson(searchPanel.getFirstnameTextfield().getText(), searchPanel.getLastnameTextfield().getText());
                navigatePanel.setPersonName(person.getFirstname());
                navigatePanel.setPersonLastName(person.getLastname());
                searchPanel.getFirstnameTextfield().setText("");
                searchPanel.getLastnameTextfield().setText("");
            }
        });
        searchPanel.getSearch().addActionListener(e -> {
            searchResult.setErrorMessage("");
            if (verifyTextField(searchPanel.getFirstnameTextfield().getText(), searchPanel.getLastnameTextfield().getText())){
                if (searchPerson(searchPanel.getFirstnameTextfield().getText(), searchPanel.getLastnameTextfield().getText())) {
                    searchResult.setPersonName(searchPanel.getFirstnameTextfield().getText());
                    searchResult.setPersonLastName(searchPanel.getLastnameTextfield().getText());
                } else {
                    searchResult.setPersonName(searchPanel.getFirstnameTextfield().getText());
                    searchResult.setPersonLastName(searchPanel.getLastnameTextfield().getText());
                    searchResult.setErrorMessage("Person not Found!!!");
            }}

        });
        navigatePanel.getPrevious().addActionListener(e -> {
            person = previousList(person);
            navigatePanel.setPersonName(person.getFirstname());
            navigatePanel.setPersonLastName(person.getLastname());
        });
        navigatePanel.getNext().addActionListener(e -> {
            person = nextList(person);
            navigatePanel.setPersonName(person.getFirstname());
            navigatePanel.setPersonLastName(person.getLastname());
        });
    }

    private boolean verifyTextField(String name, String lastName) {
        if (name.isEmpty() || lastName.isEmpty()) {
            JOptionPane.showMessageDialog(searchPanel, "'Name' and 'Last Name' should not be empty", "Validation", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void addPerson(String name, String lastName) {
        if (personList.isEmpty()) {
            person = new Person(name, lastName);
            personList.add(person);
            return;
        }
        for (Person pers : personList) {
            if (!(pers.getFirstname().equals(name) && pers.getLastname().equals(lastName))) {
                person = new Person(name, lastName);
                personList.add(person);
                return;
            }
        }
    }

    private boolean searchPerson(String name, String lastName) {
        for (Person p : personList) {
            if (p.getFirstname().equals(name) && p.getLastname().equals(lastName)) {
                return true;
            }
        }
        return false;
    }

    private Person previousList(Person p) {
        int position = personList.indexOf(p);
        if(position==0){
            return personList.get(position);
        }
        return personList.get(position-1);
     }

    private Person nextList(Person p) {
        int position = personList.indexOf(p);
        if(position==personList.size()-1) return personList.get(position);
        return personList.get(position+1);
    }
}
