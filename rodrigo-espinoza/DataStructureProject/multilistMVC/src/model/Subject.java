package model;

public class Subject {
    private String name;
    private int finalScore;
    private String ID;

    public Subject(String name, int finalScore, String ID) {
        this.name = name;
        this.finalScore = finalScore;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
