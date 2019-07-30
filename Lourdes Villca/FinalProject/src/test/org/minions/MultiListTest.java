package org.minions;

import org.junit.Before;
import org.junit.Test;
import org.minions.model.Student;
import org.minions.model.Subject;

public class MultiListTest {
    private MultiList<Student,Subject> multiList;
    private Student student1, student2, student3;
    private Subject subject1, subject2;

    @Before
    public void setup() {
        //studentList = new DoubleLinkedList<>();
        multiList = new MultiList<>();
        student1 = new Student("Miriam", "Huanca", "123455");
        student2 = new Student("Lourdes", "Villca", "123456");
        student3 = new Student("Miriam", "Huanca", "123457");

        subject1 = new Subject("Calculo","CA01",56);
        subject2 = new Subject("CalculoII","CA02",70);
    }

    @Test
    public void addChild2Test() {
        multiList.insertDataAtFirst(student1);
        multiList.insertDataAtFirst(student2);
        multiList.insertDataAtFirst(student3);
        //ChildNode a = new ChildNode(multiList.getNode(student1));
        //multiList.addChild2(a,subject1);
        multiList.addChild(student1,subject1);
        multiList.addChild(student1,subject2);
    }
}