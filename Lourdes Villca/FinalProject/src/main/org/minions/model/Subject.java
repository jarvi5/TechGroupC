package org.minions.model;

public class Subject {
    private String name;
    private String id;
    private int finalNote;

    public Subject(String name, String id, int finalNote) {
        this.name = name;
        this.id = id;
        this.finalNote = finalNote;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFinalNote() {
        return finalNote;
    }

    public void setFinalNote(int finalNote) {
        this.finalNote = finalNote;
    }
    @Override
    public String toString(){
        return id  +" - " +name;
    }
}
