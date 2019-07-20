package controller;

import model.Course;
import model.Student;
import multi_list_library.DoubleLinkedList;
import multi_list_library.MultiNode;

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
        Course coco = new Course(13,"Math",100);
        MultiNode<Student, Course> multiNodini = new MultiNode(stu1);
        multiNodini.getChild().addToBack(coco);
    }
}
