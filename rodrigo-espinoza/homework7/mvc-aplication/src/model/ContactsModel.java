package model;

import java.util.LinkedList;

public class ContactsModel {
    private LinkedList<PersonModel> personModels;

    public ContactsModel() {
        personModels = new LinkedList<>();
    }

    public void addContact(PersonModel user) {
        personModels.add(user);
    }

    public PersonModel searchContact(PersonModel personModel) {
        PersonModel result = null;
        for (PersonModel userPersonModel : personModels) {
            if (userPersonModel.equals(personModel)) {
                result = userPersonModel;
                break;
            }
        }
        return result;
    }

    public PersonModel previousContact(PersonModel personModel) {
        PersonModel result;
        int index = 0;
        while (!personModels.get(index).equals(personModel) && index < personModels.size()) {
            index++;
        }
        result = (index > 0 && index < personModels.size()) ? personModels.get(index - 1) : null;
        return result;
    }

    public PersonModel nextContact(PersonModel personModel) {
        PersonModel result;
        int index = 0;
        while (!personModels.get(index).equals(personModel) && index < personModels.size()) {
            index++;
        }
        result = (index >= 0 && index < personModels.size() - 1) ? personModels.get(index + 1) : null;
        return result;
    }
}
