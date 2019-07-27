import project.common.DoubleList;
//import project.common.ParentList;
import project.common.MultiList;
import project.model.Student;
import project.model.Subject;

public class Main {
    /**
     * Following is only for testing purposes, it will be removed on next versions
     * @param args
     */
    public static void main(String[] args) {
        test_double_linked_list_structure();
    }

    private static void test_double_linked_list_structure() {
        // Create list, add elements and prints the list
        MultiList<Student, Subject> students = new MultiList<>();

        System.out.println("empty = " + students.isEmpty());
        System.out.println("adding students ...");

        Student carlos = new Student("Carlos");
        students.add(new Student("Juan"));
        students.add(carlos);
        students.add(new Student("Pedro"));

        System.out.println("empty = " + students.isEmpty());
        System.out.println("size = " + students.getSize());
        System.out.println("List of students.....");
        for(int i=0; i<students.getSize(); i++) {
            System.out.println("Student Name = " + students.get(i).getName());
        }

        // add at first and end
        System.out.println("adding first/end ...");
        Student albert =  new Student("Albert");
        students.addFirst(albert);
        students.addLast(new Student("Karen"));
        System.out.println("first student = " + students.getFirst().getName());
        System.out.println("last student = " + students.getLast().getName());
        System.out.println("List of students.....");
        for(int i=0; i<students.getSize(); i++) {
            System.out.println("Student Name = " + students.get(i).getName());
        }

        // delete first
        System.out.println("delete first ...");
        students.delete(albert);
        System.out.println("new first student = " + students.getFirst().getName());
        System.out.println("List of students.....");
        for(int i=0; i<students.getSize(); i++) {
            System.out.println("Student Name = " + students.get(i).getName());
        }

        // delete carlos
        System.out.println("delete carlos ...");
        students.delete(carlos);
        System.out.println("List of students.....");
        for(int i=0; i<students.getSize(); i++) {
            System.out.println("Student Name = " + students.get(i).getName());
        }

        // getLast
        Student student = students.getLast();
        DoubleList<Subject> subjects;
        // add child
        System.out.println("Adding child ...");
        Subject lenguaje = new Subject("Lenguaje");
        Subject quimica = new Subject("Quimica");
        Subject geografia = new Subject("Geografia");
        students.addChild(student, lenguaje);
        //students.deleteChild(student, lenguaje);
        students.addChild(student, new Subject("Matematicas"));
        students.addChild(student, geografia);
        students.addChild(student, new Subject("Fisica"));
        students.addChild(student, quimica);
        subjects = students.getChildList(student);
        for (int j=0; j<subjects.getSize(); j++) {
            Subject sbj = subjects.get(j);
            System.out.println("subject is = " + sbj.getName());
        }

        System.out.println("Removing first child...");
        students.deleteChild(student, lenguaje);
        subjects = students.getChildList(student);
        for (int j=0; j<subjects.getSize(); j++) {
            Subject sbj = subjects.get(j);
            System.out.println("subject is = " + sbj.getName());
        }

        // remove last child
        System.out.println("Removing last child...");
        students.deleteChild(student, quimica);
        subjects = students.getChildList(student);
        for (int j=0; j<subjects.getSize(); j++) {
            Subject sbj = subjects.get(j);
            System.out.println("subject is = " + sbj.getName());
        }

        // remove middle child
        System.out.println("Removing middle child...");
        students.deleteChild(student, geografia);
        subjects = students.getChildList(student);
        for (int j=0; j<subjects.getSize(); j++) {
            Subject sbj = subjects.get(j);
            System.out.println("subject is = " + sbj.getName());
        }
    }

}

