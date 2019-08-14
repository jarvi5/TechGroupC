package dataStructure;

import model.Students;
import model.Subjects;

public class Main {
    public static void main(String[] args) {
        Students student1 = new Students("5555", "Fer", "Silva");
        Students student2 = new Students("45421", "Marta", "Cardenas");

        Subjects subject1 = new Subjects("54546", "Matematicas");
        Subjects subject2 = new Subjects("54555", "Fisica");
        Subjects subject3 = new Subjects("65757", "Lenguaje");
        Subjects subject4 = new Subjects("7585", "Quimica");
        Subjects subject5 = new Subjects("75855", "Algebra");

        DoubleLinkedList<Subjects> subjectsList = new DoubleLinkedList<>();
        subjectsList.addToBack(subject1);
        subjectsList.addToBack(subject2);
        subjectsList.addToBack(subject3);
        subjectsList.addToBack(subject4);

        Node<Students> studentsNodes=new Node<>(student1);
        MultiNode<Students, Subjects> multiNode= new MultiNode<>(studentsNodes.getValue());
        multiNode.setChild(subjectsList);

        Node<Subjects> subjectsNode=new Node<>(subject5);
        MultiList<Students, Subjects> multiList=new MultiList<>();
        multiList.addChild(multiNode,subjectsNode);

    }
}
