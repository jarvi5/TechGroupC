package model.dataStructure;

import model.Subject;

public class NodeSubject {
    protected Subject subject;
    protected NodeSubject previousNodeSubject;
    protected NodeSubject nextNodeSubject;

    public NodeSubject(NodeSubject previousNodeSubject, Subject subject, NodeSubject nextNodeSubject) {
        this.subject = subject;
        this.previousNodeSubject = previousNodeSubject;
        this.nextNodeSubject = nextNodeSubject;
    }
}
