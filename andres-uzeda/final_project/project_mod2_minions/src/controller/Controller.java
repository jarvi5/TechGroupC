package controller;

import model.Course;
import model.Student;
import multi_list_library.DoubleLinkedList;
import multi_list_library.MultiNode;
import multi_list_library.Node;
import view.View;

public class Controller {
    private View view;
    private  DoubleLinkedList<MultiNode> doblete;
    public Controller(View v) {
        view = v;
        initView();
        doblete = new DoubleLinkedList<>();
        Student stu = new Student(12,"Acario","Apa");
        Student stu1 = new Student(12,"Bacario","Bapa");
        Student stu2 = new Student(12,"Cacario","Capa");
        Course math = new Course(182,"Math",100);
        Course science = new Course(166,"Science",90);
        MultiNode multiNodini = new MultiNode(stu);
        multiNodini.getChild().addToBack(math);
        multiNodini.getChild().addToBack(science);
        MultiNode multiNodini2 = new MultiNode(stu1);
        multiNodini2.getChild().addToBack(math);
        MultiNode multiNodini3 = new MultiNode(stu2);
        multiNodini3.getChild().addToBack(science);
        doblete.addToBack(multiNodini);
        doblete.addToBack(multiNodini2);
        doblete.addToBack(multiNodini3);
    }

    public void initView() {
    }
    public void initController() {
        view.getNextStudentButton().addActionListener(e -> mainNextResult());
        view.getPreviousStudentButton().addActionListener(e -> mainPreviousResult());
        view.getNextCourseButton().addActionListener(e -> childNextResult());
        view.getPreviousCourseButton().addActionListener(e -> childPreviousResult());
        /*view.getAddButton().addActionListener();
        view.getSearchButton().addActionListener();
        view.getNextButton().addActionListener();
        view.getPreviousButton().addActionListener();*/
    }

    public void mainNextResult(){
        nextResult();
        //TODO: validar si esta vacio el child list y si tiene resultado imprimirlo
        childListResult();
    }

    public void mainPreviousResult(){
        previousResult();
        childListResult();
    }

    private void nextResult(){
        doblete.moveNext();
        view.getFirstNameTextfield().setText(((Student) ((MultiNode) doblete.getActualNode().getNode()).getNode()).getFirstName());
        view.getLastNameTextfield().setText(((Student) ((MultiNode) doblete.getActualNode().getNode()).getNode()).getLastName());
        view.getRfidTextfield().setText(String.valueOf(((Student) ((MultiNode) doblete.getActualNode().getNode()).getNode()).getRfid()));
    }

    private void previousResult(){
        doblete.movePrevious();
        view.getFirstNameTextfield().setText(((Student) ((MultiNode) doblete.getActualNode().getNode()).getNode()).getFirstName());
        view.getLastNameTextfield().setText(((Student) ((MultiNode) doblete.getActualNode().getNode()).getNode()).getLastName());
        view.getRfidTextfield().setText(String.valueOf(((Student) ((MultiNode) doblete.getActualNode().getNode()).getNode()).getRfid()));
    }

    private void childListResult(){
        DoubleLinkedList listChild =((MultiNode) doblete.getActualNode().getNode()).getChild();
        Node current = listChild.getHeadNode();
        String courseList = "";
        view.getDetailCourseTextfield().setText("");
        view.getCourseTextfield().setText("");
        while (current != null){
            courseList += ((Course)(current.getNode())).getCourseName() + " ";
            current =  current.next;
        }
        view.getCourseTextfield().setText(courseList);
    }

    private void childNextResult(){
        ((MultiNode) doblete.getActualNode().getNode()).getChild().moveNext();
        Node childNode =((MultiNode) doblete.getActualNode().getNode()).getChild().getActualNode();
        String course = ((Course)(childNode.getNode())).getId() +" "+((Course)(childNode.getNode())).getCourseName() + " " + ((Course)(childNode.getNode())).getFinalGrade();
        view.getDetailCourseTextfield().setText(course);
    }

    private void childPreviousResult(){
        ((MultiNode) doblete.getActualNode().getNode()).getChild().movePrevious();
        Node childNode =((MultiNode) doblete.getActualNode().getNode()).getChild().getActualNode();
        String course = ((Course)(childNode.getNode())).getId() +" "+((Course)(childNode.getNode())).getCourseName() + " " + ((Course)(childNode.getNode())).getFinalGrade();
        view.getDetailCourseTextfield().setText(course);
    }

}