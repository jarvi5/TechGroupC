package model;

public class Student implements Comparable<Student> {
    private String name;
    private String lastName;
    private long RFID;

    public Student(String name, String lastName, long RFID) {
        this.name = name;
        this.lastName = lastName;
        this.RFID = RFID;
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

    public long getRFID() {
        return RFID;
    }

    public void setRFID(long RFID) {
        this.RFID = RFID;
    }

    public boolean equals(Student student) {
        return name.equals(student.name)
                && lastName.equals(student.lastName);
    }
    public String getFullName(){
        return name + " " + lastName;
    }

    @Override
    public int compareTo(Student student) {
        return getFullName().compareTo(student.getFullName());
    }

}
