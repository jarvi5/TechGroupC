package main.model;

public class Student {
    private int rfid;
    private String firstName;
    private String lastName;

    public Student(int rfid, String firstName, String lastName) {
        this.rfid = rfid;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getRfid() {
        return rfid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setRfid(int rfid) {
        this.rfid = rfid;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
