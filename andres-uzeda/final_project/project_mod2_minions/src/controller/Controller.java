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
            cleanCourseTextField();
            isItEmptyAChild();
        });
        view.getNextStudentJButton().addActionListener(e -> {
            nextResult();
            cleanCourseTextField();
            isItEmptyAChild();
        });
        view.getPreviousCourseJButton().addActionListener(e -> childPreviousResult());
        view.getNextCourseJButton().addActionListener(e -> childNextResult());
        view.getAddStudentJButton().addActionListener(e -> addStudent());
        view.getAddCourseJButton().addActionListener(e -> {
            addCourseToStudent();
            isItEmptyAChild();
        });
        view.getEditStudentJButton().addActionListener(e -> editStudent());
        view.getEditCourseJButton().addActionListener(e -> editCourse());
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
        view.getCourseNameTextField().setText(((Course)(childNode.getNode())).getCourseName());
        view.getCourseIDTextField().setText(Integer.toString(((Course)(childNode.getNode())).getId()));
        view.getFinalGradeTextField().setText(Integer.toString(((Course)(childNode.getNode())).getFinalGrade()));
    }

    private void childPreviousResult(){
        ((MultiNode) doblete.getActualNode().getNode()).getChild().movePrevious();
        Node childNode =((MultiNode) doblete.getActualNode().getNode()).getChild().getActualNode();
        String course = ((Course)(childNode.getNode())).getId() +" "+((Course)(childNode.getNode())).getCourseName() + " " + ((Course)(childNode.getNode())).getFinalGrade();
        view.getCourseDetailJTextArea().setText(course);
        view.getCourseNameTextField().setText(((Course)(childNode.getNode())).getCourseName());
        view.getCourseIDTextField().setText(Integer.toString(((Course)(childNode.getNode())).getId()));
        view.getFinalGradeTextField().setText(Integer.toString(((Course)(childNode.getNode())).getFinalGrade()));
    }

    private void childActualResult(){
        Node childNode =((MultiNode) doblete.getActualNode().getNode()).getChild().getActualNode();
        String course = ((Course)(childNode.getNode())).getId() +" "+((Course)(childNode.getNode())).getCourseName() + " " + ((Course)(childNode.getNode())).getFinalGrade();
        view.getCourseDetailJTextArea().setText(course);
    }

    private void addStudent(){
        Student student = new Student(Integer.parseInt(view.getRfidJTextField().getText()),view.getFirstNameJTextField().getText(),view.getLastNameTextField().getText());
        MultiNode multiNode = new MultiNode(student);
        doblete.addToBack(multiNode);
        cleanStudentTextField();
    }

    private void cleanStudentTextField(){
        view.getRfidJTextField().setText("");
        view.getFirstNameJTextField().setText("");
        view.getLastNameTextField().setText("");
    }

    private void addCourseToStudent(){
        Course newCourse = new Course(Integer.parseInt(view.getCourseIDTextField().getText()),view.getCourseNameTextField().getText(),Integer.parseInt(view.getFinalGradeTextField().getText()));
        MultiNode actual = ((MultiNode) doblete.getActualNode().getNode());
        actual.getChild().addToBack(newCourse);
        cleanCourseTextField();
    }

    private void cleanCourseTextField(){
        view.getFinalGradeTextField().setText("");
        view.getCourseNameTextField().setText("");
        view.getCourseIDTextField().setText("");
    }

    private void editStudent(){
        ((Student) ((MultiNode) doblete.getActualNode().getNode()).getNode()).setRfid(Integer.parseInt(view.getRfidJTextField().getText()));
        ((Student) ((MultiNode) doblete.getActualNode().getNode()).getNode()).setFirstName(view.getFirstNameJTextField().getText());
        ((Student) ((MultiNode) doblete.getActualNode().getNode()).getNode()).setLastName(view.getLastNameTextField().getText());
    }

    private void editCourse(){
        ((Course) ((MultiNode) doblete.getActualNode().getNode()).getChild().getActualNode().getNode()).setCourseName(view.getCourseNameTextField().getText());
        ((Course) ((MultiNode) doblete.getActualNode().getNode()).getChild().getActualNode().getNode()).setFinalGrade(Integer.parseInt(view.getFinalGradeTextField().getText()));
        ((Course) ((MultiNode) doblete.getActualNode().getNode()).getChild().getActualNode().getNode()).setId(Integer.parseInt(view.getCourseIDTextField().getText()));
        childListResult();
        childActualResult();
    }
}