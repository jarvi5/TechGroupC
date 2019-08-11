package model;

public class Course {
    int id;
    String courseName;
    int finalGrade;

    public Course(int id, String courseName, int finalGrade) {
        this.id = id;
        this.courseName = courseName;
        this.finalGrade = finalGrade;
    }

    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getFinalGrade() {
        return finalGrade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setFinalGrade(int finalGrade) {
        this.finalGrade = finalGrade;
    }
}
