package model;

public class Subject implements Comparable<Subject> {
    private String name;
    private int finalScore;
    private String id;

    public Subject(String name, String id, int finalScore) {
        this.name = name;
        this.finalScore = finalScore;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean equals(Subject subject) {
        return id.equals(subject.id);
    }

    @Override
    public int compareTo(Subject subject) {
        return id.compareTo(subject.id);
    }
}
