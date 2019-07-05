package project;

public class Student {
    private String name;
    private String lastname;

    public Student(String name, String lastname){
        this.setName(name);
        this.setLastname(lastname);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
