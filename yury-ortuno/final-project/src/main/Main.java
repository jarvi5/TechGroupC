package main;

/**
 * Created by Yury Ortuno on 7/15/2019.
 */
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("yury","ortuno", 25);
        Student student2 = new Student("yver","calvo", 26);
        Student student3 = new Student("ariel","ortuno", 25);
        MultiList list = new MultiList();
        list.addFirst(student1);
        list.addFirst(student2);
        list.addLast(student3);
    }
}
