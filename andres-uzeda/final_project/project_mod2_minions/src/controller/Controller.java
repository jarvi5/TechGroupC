package controller;

import model.Course;
import model.Student;
import multi_list_library.DoubleLinkedList;
import multi_list_library.MultiNode;
import multi_list_library.Node;
import view.View4;

public class Controller {
    private View4 view;
    private  DoubleLinkedList<MultiNode> doblete;
    public Controller(View4 v) {
        view = v;
        initView();
        doblete = new DoubleLinkedList<>();
        Student stu = new Student(12,"Acario","Apa");
        Student stu1 = new Student(12,"Bacario","Bapa");
        Student stu2 = new Student(12,"Cacario","Capa");
        Student stu3 = new Student(14,"Dacario","Dapa");
        Course math = new Course(182,"Math",100);
        Course science = new Course(166,"Science",90);
        MultiNode multiNodini = new MultiNode(stu);
        multiNodini.getChild().addToBack(math);
        multiNodini.getChild().addToBack(science);
        MultiNode multiNodini2 = new MultiNode(stu1);
        multiNodini2.getChild().addToBack(math);
        MultiNode multiNodini3 = new MultiNode(stu2);
        multiNodini3.getChild().addToBack(science);
        MultiNode multiNodini4 = new MultiNode(stu3);
        doblete.addToBack(multiNodini);
        doblete.addToBack(multiNodini2);
        doblete.addToBack(multiNodini3);
        doblete.addToBack(multiNodini4);
    }

    public void initView() {
    }
    public void initController() {
        view.getPreviousStudentJButton().addActionListener(e -> {
            previousResult();
            isItEmptyAChild();
        });
        view.getNextStudentJButton().addActionListener(e -> {
            nextResult();
            isItEmptyAChild();
        });
        view.getPreviousCourseJButton().addActionListener(e -> childPreviousResult());
        view.getNextCourseJButton().addActionListener(e -> childNextResult());
        /*view.getAddButton().addActionListener();
        view.getSearchButton().addActionListener();
        view.getNextButton().addActionListener();
        view.getPreviousButton().addActionListener();*/
    }

    private void isItEmptyAChild(){
        if(((MultiNode) doblete.getActualNode().getNode()).getChild().getHeadNode() != null){
            childListResult();
        }else{
            view.getCourseDetailJTextArea().setText("");
            view.getCourseListJTextArea().setText("");
        }
    }

    private void nextResult(){
        doblete.moveNext();
        view.getFirstNameJTextField().setText(((Student) ((MultiNode) doblete.getActualNode().getNode()).getNode()).getFirstName());
        view.getLastNameTextField().setText(((Student) ((MultiNode) doblete.getActualNode().getNode()).getNode()).getLastName());
        view.getRfidJTextField().setText(String.valueOf(((Student) ((MultiNode) doblete.getActualNode().getNode()).getNode()).getRfid()));
    }

    private void previousResult(){
        doblete.movePrevious();
        view.getFirstNameJTextField().setText(((Student) ((MultiNode) doblete.getActualNode().getNode()).getNode()).getFirstName());
        view.getLastNameTextField().setText(((Student) ((MultiNode) doblete.getActualNode().getNode()).getNode()).getLastName());
        view.getRfidJTextField().setText(String.valueOf(((Student) ((MultiNode) doblete.getActualNode().getNode()).getNode()).getRfid()));
    }

    private void childListResult(){
        DoubleLinkedList listChild =((MultiNode) doblete.getActualNode().getNode()).getChild();
        Node current = listChild.getHeadNode();
        String courseList = "";
        view.getCourseDetailJTextArea().setText("");
        view.getCourseListJTextArea().setText("");
        while (current != null){
            courseList += ((Course)(current.getNode())).getCourseName() + " ";
            current =  current.next;
        }
        view.getCourseListJTextArea().setText(courseList);
    }

    private void childNextResult(){
        ((MultiNode) doblete.getActualNode().getNode()).getChild().moveNext();
        Node childNode =((MultiNode) doblete.getActualNode().getNode()).getChild().getActualNode();
        String course = ((Course)(childNode.getNode())).getId() +" "+((Course)(childNode.getNode())).getCourseName() + " " + ((Course)(childNode.getNode())).getFinalGrade();
        view.getCourseDetailJTextArea().setText(course);
    }

    private void childPreviousResult(){
        ((MultiNode) doblete.getActualNode().getNode()).getChild().movePrevious();
        Node childNode =((MultiNode) doblete.getActualNode().getNode()).getChild().getActualNode();
        String course = ((Course)(childNode.getNode())).getId() +" "+((Course)(childNode.getNode())).getCourseName() + " " + ((Course)(childNode.getNode())).getFinalGrade();
        view.getCourseDetailJTextArea().setText(course);
    }

}