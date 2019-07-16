package model.dataStructure;

import model.Student;
import model.Subject;


public class MultiList {
    private NodeStudent firstStudent;
    private NodeStudent lastStudent;
    private NodeSubject firstSubject;
    private NodeSubject lastSubject;
    private NodeStudent current;

    public void addStudent(Student student) {
        final NodeStudent currentLast = lastStudent;
        final NodeStudent newNode = new NodeStudent(currentLast, student, null);
        lastStudent = newNode;
        if (currentLast == null) {
            firstStudent = newNode;
        }
        else {
            currentLast.nextNodeStudent = newNode;
        }
        current = lastStudent;
    }

    public void addSubject(Subject subject){
        final NodeSubject currentSubjectLast = lastSubject;
        final NodeSubject newNode = new NodeSubject(currentSubjectLast, subject, null);
        lastSubject = newNode;
        if (lastSubject == null) {
            firstSubject = newNode;
        }
        else {
            currentSubjectLast.nextNodeSubject = newNode;
        }
    }

    public Student previousStudent(){
        if(current != null && current.prevNodeStudent != null){
            current = current.prevNodeStudent;
        }
        return current.student;
    }

    public Student nextStudent(){
        if (current != null && current.nextNodeStudent != null){
            current = current.nextNodeStudent;
        }
        return current.student;
    }

    public Student searchStudent(Student student){
        current = searchNodeStudent(firstStudent);
        return current.student;
    }

    private NodeStudent searchNodeStudent(NodeStudent nodeStudent){
        NodeStudent current = nodeStudent;
        while(current != null && current.nextNodeStudent != null){
            if(current.student.equals(nodeStudent.student)) {
                break;
            }
            else {
                current = current.nextNodeStudent;
            }
        }
        return current;
    }


}
