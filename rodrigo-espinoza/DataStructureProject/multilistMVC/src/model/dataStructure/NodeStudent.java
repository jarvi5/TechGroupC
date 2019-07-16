package model.dataStructure;

import model.Student;

public class NodeStudent {
    protected Student student;
    protected NodeSubject nodeSubject;
    protected NodeStudent nextNodeStudent;
    protected NodeStudent prevNodeStudent;


    public NodeStudent(NodeStudent prevNodeStudent, Student student, NodeStudent nextNodeStudent) {
        this.student = student;
        this.nextNodeStudent = nextNodeStudent;
        this.prevNodeStudent = prevNodeStudent;
    }
}
