package org.minions.model;

public class Student {
    private String name;
    private String lastName;
    private String rfid;

    public Student(String name, String lastName, String rfid) {
        this.name = name;
        this.lastName = lastName;
        this.rfid = rfid;
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

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
        this.rfid = rfid;
    }

    @Override
    public boolean equals(Object o){
        if(((Student)o).getRfid().equals(rfid) && ((Student)o).getLastName().equals(lastName) && ((Student)o).getName().equals(name)){
            return true;
        }
        return false;
    }
}
