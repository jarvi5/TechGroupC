package main.controller;

import main.model.Course;
import main.model.Student;
import main.utilities.MultiList;
import main.utilities.MultiNode;
import main.view.App;

/**
 * Created by Yury Ortuno on 7/15/2019.
 */
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new App());
        controller.initController();

//        Student student=new Student(5, "yury", "ortuno");
//        Course course = new Course(10,"matematicas",100);
//        Course course1 = new Course(10,"asdasda",123);
//        MultiList<Student, Course> multiList = new MultiList<>();
//        multiList.addParent(student);
//        multiList.addChild(student, course);
//        multiList.addChild(student, course1);
    }
}
