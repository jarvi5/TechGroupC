package project;

public class Subject {
    private int id;
    private String name;
    private int note;

    public Subject(int id, String name, int note){
        this.setId(id);
        this.setName(name);
        this.setNote(note);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
