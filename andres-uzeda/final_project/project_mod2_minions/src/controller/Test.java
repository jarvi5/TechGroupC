package controller;

import model.Course;
import model.Student;
import multi_list_library.DoubleLinkedList;
import multi_list_library.MultiNode;
import multi_list_library.Node;

public class Test {
    public static void main(String[] args){
//        DoubleLinkedList doblete = new DoubleLinkedList();
//        Student stu = new Student(12,"Acario","Apa");
//        Student stu1 = new Student(12,"Bacario","Bapa");
//        Student stu2 = new Student(12,"Cacario","Capa");
//        doblete.addToBack(stu);
//        doblete.addToBack(stu1);
//        doblete.addToBack(stu2);
//        System.out.println(((Student) doblete.moveNext().getNode()).getFirstName());
//        System.out.println(((Student) doblete.moveNext().getNode()).getFirstName());
//        System.out.println(((Student) doblete.moveNext().getNode()).getFirstName());
//
        Student stu1 = new Student(12,"Bacario","Bapa");
        Student stu2 = new Student(122,"Zcacario","Zapa");
        Course coco = new Course(182,"Math",100);
        MultiNode<Student, Course> multiNodini = new MultiNode(stu1);
        Course scom = new Course(151,"Science",90);
        multiNodini.getChild().addToBack(coco);
        multiNodini.getChild().addToBack(scom);
        MultiNode<Student, Course> multiNodini2 = new MultiNode(stu2);
        multiNodini2.getChild().addToBack(scom);
        DoubleLinkedList<MultiNode> multipe = new DoubleLinkedList<>();
        multipe.addToBack(multiNodini);
        multipe.addToBack(multiNodini2);
        System.out.println("ss");
        multipe.moveNext();
        //((Student) doblete.getActualNode().getNode()).getFirstName()
        System.out.println((((Student) ((MultiNode) multipe.getActualNode().getNode()).getNode()).getFirstName()));
        //((MultiNode) multipe.getActualNode().getNode())
        //((MultiNode) multipe.getActualNode().getNode())
        //((Course) ((MultiNode) multipe.getActualNode().getNode()).getChild().getActualNode().getNode()).getCourseName();
        DoubleLinkedList pepe =((MultiNode) multipe.getActualNode().getNode()).getChild();
        returnAllNodes(pepe);
        //System.out.println(((Course) ((MultiNode) multipe.getActualNode().getNode()).getChild().getActualNode().getNode()).getCourseName());
    }
    public static void returnAllNodes(DoubleLinkedList lista){
        Node current = lista.getHeadNode();
        while (current != null){
            System.out.println(((Course)(current.getNode())).getCourseName());
            current =  current.next;
        }
    }
}
