import project.common.utils.DoubleList;
import project.common.utils.MultiList;
import project.model.datatype.Student;
import project.model.datatype.Subject;

public class Main {
    /**
     * Following is only for testing purposes, it will be removed on next versions
     * @param args only for testing purposes
     */
    public static void main(String[] args) {
        test_double_linked_list_structure();
    }

    private static void test_double_linked_list_structure() {
        // Create list, add elements and prints the list
        MultiList<Student, Subject> students = new MultiList<>();

        System.out.println("empty = " + students.isEmpty());
        System.out.println("adding students ...");

        Student carlos = new Student("2","Carlos", "dd");
        students.add(new Student("1","Juan", "test"));
        students.add(carlos);
        students.add(new Student("3","Pedro", "dss"));

        System.out.println("empty = " + students.isEmpty());
        System.out.println("size = " + students.getSize());
        System.out.println("List of students.....");
//        for(int i=0; i<students.getSize(); i++) {
//            System.out.println("Student Name = " + students.get(i).getName());
//        }

        for (Student st: students) {
            System.out.println("Student Name = " + st.getName());
        }

        // add at first and end
        System.out.println("adding first/end ...");
        Student albert =  new Student("45","Albert", "cass");
        students.addFirst(albert);
        students.addLast(new Student("22","Karen", "32344"));
        System.out.println("first student = " + students.getFirst().getName());
        System.out.println("last student = " + students.getLast().getName());
        System.out.println("List of students.....");
        for(int i=0; i<students.getSize(); i++) {
            System.out.println("Student Name = " + students.get(i).getName());
        }

        // remove first
        System.out.println("remove first ...");
        students.remove(albert);
        System.out.println("new first student = " + students.getFirst().getName());
        System.out.println("List of students.....");
        for(int i=0; i<students.getSize(); i++) {
            System.out.println("Student Name = " + students.get(i).getName());
        }

        // remove carlos
        System.out.println("remove carlos ...");
        students.remove(carlos);
        System.out.println("List of students.....");
        for(int i=0; i<students.getSize(); i++) {
            System.out.println("Student Name = " + students.get(i).getName());
        }

        // getLast
        Student student = students.getLast();
        DoubleList<Subject> subjects;
        // add child
        System.out.println("Adding child ...");
        Subject lenguaje = new Subject("1","Lenguaje", 20);
        Subject quimica = new Subject("2","Quimica", 45);
        Subject geografia = new Subject("2","Geografia", 45);
        students.addChild(student, lenguaje);
        //students.deleteChild(student, lenguaje);
        students.addChild(student, new Subject("33","Matematicas", 45));
        students.addChild(student, geografia);
        students.addChild(student, new Subject("33","Fisica",452));
        students.addChild(student, quimica);
        subjects = students.getChildList(student);
//        for (int j=0; j<subjects.getSize(); j++) {
//            Subject sbj = subjects.get(j);
//            System.out.println("subject is = " + sbj.getName());
//        }
        for (Subject sb : subjects){
            System.out.println("subject is = " + sb.getName());
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

