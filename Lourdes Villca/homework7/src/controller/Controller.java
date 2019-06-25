package controller;

import model.Person;
import view.NavigatePanel;
import view.SearchPanel;
import view.SearchResult;

import java.util.ArrayList;

public class Controller {
    private Person person;
    private SearchPanel searchPanel;
    private NavigatePanel navigatePanel;
    private SearchResult searchResult;
    private ArrayList<Person> personList;

    public Controller(SearchPanel searchPanel, NavigatePanel navigatePanel, SearchResult resultPanel) {
        this.searchPanel=searchPanel;
        this.navigatePanel=navigatePanel;
        this.searchResult=resultPanel;
        personList = new ArrayList<>();
}

    public void initController() {
        searchPanel.getAddButton().addActionListener(e -> {
                addPerson(searchPanel.getFirstnameTextfield().getText(),searchPanel.getLastnameTextfield().getText());
                navigatePanel.setPersonName(person.getFirstname());
                navigatePanel.setPersonLastName(person.getLastname());
        });
        searchPanel.getSearch().addActionListener(e ->
                searchPerson(searchPanel.getFirstnameTextfield().getText(),searchPanel.getLastnameTextfield().getText()));
        navigatePanel.getPrevious().addActionListener(e -> {
            nextList(person);
        });
    }

    private void saveFirstname() {
        person.setFirstname(searchPanel.getFirstnameTextfield().getText());

    }

    private void saveLastname() {
        person.setLastname(searchPanel.getLastnameTextfield().getText());

    }

    private void addPerson(String name, String lastName) {
        if( personList.isEmpty() )
            person = new Person(name, lastName);
        for (Person pers : personList) {
            if (!pers.getFirstname().equals(name) && pers.getLastname().equals(lastName)) {
                person = new Person(name,lastName);
                personList.add(person);
            }
        }
    }

    private boolean searchPerson(String name, String lastName) {
        for(Person p: personList){
            if(p.getFirstname().equals(name) && p.getLastname().equals(lastName)){
                return true;

            }
        }
        return false;
    }
    private Person nextList(Person p){
        for(int i = 0; i< personList.size(); i++){
            if(personList.get(i).getFirstname().equals(personList.get(i).getFirstname()) && p.getLastname().equals(p.getLastname())){
                return personList.get(i+1);
            }
        }
        return null;
    }
}
