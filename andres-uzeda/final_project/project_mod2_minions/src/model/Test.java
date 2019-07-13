package model;

public class Test {
    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        Student stu = new Student(12,"Acario","Apa");
        Student stu1 = new Student(12,"Bacario","Bapa");
        Student stu2 = new Student(12,"Cacario","Capa");
        linkedList.addAStudent(stu);
        linkedList.addAStudent(stu1);
        linkedList.addAStudent(stu2);
        linkedList.printLinkedList();
        System.out.println("/*/*/*/*/*/*/*/*");
        System.out.println(linkedList.moveNext());
        System.out.println(linkedList.moveNext());
        System.out.println(linkedList.moveNext());
        System.out.println(linkedList.moveNext());
        System.out.println("/*/*/*/*/*/*/*/*");
        System.out.println(linkedList.movePrevious());
        System.out.println(linkedList.movePrevious());
        System.out.println(linkedList.movePrevious());
        System.out.println(linkedList.movePrevious());
    }
}
