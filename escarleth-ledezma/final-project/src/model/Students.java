package model;

public class Students {
    private String rfid;
    private String name;
    private String lastName;

    public Students(String rfid, String name, String lastName) {
        this.rfid = rfid;
        this.name = name;
        this.lastName = lastName;
    }

    public String getRfid() {
        return rfid;
    }

    public void setRfid(String rfid) {
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
}
