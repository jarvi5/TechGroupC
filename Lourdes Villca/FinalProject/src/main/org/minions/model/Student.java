package org.minions.model;

public class Student {
    private String name;
    private String lastName;
    private String ci;

    public Student(String name, String lastName, String ci) {
        this.name = name;
        this.lastName = lastName;
        this.ci = ci;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    @Override
    public boolean equals(Object o){
        if(((Student)o).getCi().equals(ci) && ((Student)o).getLastName().equals(lastName) && ((Student)o).getName().equals(name)){
            return true;
        }
        return false;
    }
}
