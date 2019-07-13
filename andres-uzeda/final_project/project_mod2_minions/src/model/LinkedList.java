package model;

public class LinkedList {

    class Node{
        Student student;
        Node next = null;
        Node previous = null;
        Node(Student student){
            this.student = student;
        }
    }

    protected Node head = null;
    protected Node tail = null;
    protected Node actual = null;

    public void addAStudent(Student student){
        Node newNode = new Node(student);
        if(tail == null){
            head = newNode;
        }else{
            tail.next = newNode;
            newNode.previous = tail;
            newNode.next = null;
        }
        tail = newNode;
    }

    public void printLinkedList(){
        Node current = head;
        while (current != null){
            System.out.println(current.student.getFirstName());
            current =  current.next;
        }
    }

    public Student moveNext(){
        if(actual == null){
            actual = head;
            return actual.student;
        }else if(actual.next != null){
            actual = actual.next;
            return actual.student;
        }else{
            return actual.student;
        }
    }

    public Student movePrevious(){
        if(actual == null){
            actual = head;
            return actual.student;
        }else if(actual.previous != null){
            actual = actual.previous;
            return actual.student;
        }else{
            return actual.student;
        }
    }
}
