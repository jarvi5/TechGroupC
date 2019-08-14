package model.dataStructure;

import model.Student;

public class NodeStudent<E,T> {
    protected E student;
    protected NodeSubject nodeSubject;
    protected NodeStudent<E,T> nextNodeStudent;
    protected NodeStudent<E,T> prevNodeStudent;


    public NodeStudent(NodeStudent prevNodeStudent, E student, NodeStudent nextNodeStudent) {
        this.student = student;
        this.nextNodeStudent = nextNodeStudent;
        this.prevNodeStudent = prevNodeStudent;
    }
}
