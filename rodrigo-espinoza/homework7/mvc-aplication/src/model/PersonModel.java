package model;

public class PersonModel {
    private String firstname;
    private String lastname;

    public PersonModel(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean equals(PersonModel personModel) {
        return firstname.equals(personModel.firstname)
                && lastname.equals(personModel.lastname);


    }
}