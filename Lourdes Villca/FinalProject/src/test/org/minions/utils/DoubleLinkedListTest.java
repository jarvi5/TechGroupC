package org.minions.utils;

import org.junit.Before;
import org.junit.Test;
import org.minions.model.Student;

import static org.junit.Assert.*;

public class DoubleLinkedListTest {

    private DoubleLinkedList<Student> studentList;
    private Student student1, student2, student3;

    @Before
    public void setup() {
        studentList = new DoubleLinkedList<>();
        student1 = new Student("Miriam", "Huanca", "123455");
        student2 = new Student("Lourdes", "Villca", "123456");
        student3 = new Student("Moni", "Pardo", "123457");
    }

    @Test
    public void testInsertDataAtFirst() {
        studentList.insertDataAtFirst(student1);
        studentList.insertDataAtFirst(student2);
        studentList.insertDataAtFirst(student3);
        assertEquals(student1.getRfid(), studentList.getElementAt(2).getRfid());
        assertEquals(student2.getRfid(), studentList.getElementAt(0).getRfid());
        assertEquals(student3.getRfid(), studentList.getElementAt(1).getRfid());
    }

    @Test
    public void testInsertDataAtEnd() {
        studentList.insertDataAtEnd(student1);
        studentList.insertDataAtEnd(student2);
        studentList.insertDataAtEnd(student3);
        assertEquals(student1.getRfid(),studentList.getElementAt(0).getRfid());
        assertEquals(student2.getRfid(),studentList.getElementAt(1).getRfid());
        assertEquals(student3.getRfid(),studentList.getElementAt(2).getRfid());
    }

    @Test
    public void getData() {
        studentList.insertDataAtEnd(student1);
        studentList.insertDataAtEnd(student2);
        studentList.insertDataAtEnd(student3);
        Student response = studentList.getData(student1);
        assertEquals(student1.getRfid(), response.getRfid());
    }

    @Test
    public void getNode() {
    }

//    @Test
//    public void addChild() {
//        studentList.insertDataAtEnd(student1);
//        studentList.insertDataAtEnd(student2);
//        studentList.insertDataAtEnd(student3);
//        Subject subject1 = new Subject("ProgrammingI", "P-01",89);
//        Subject subject2 = new Subject("English I","E-01",70);
//        studentList.addChild(student2,subject1);
//        studentList.addChild(student2,subject2);
//    }

    @Test
    public void getElementAt() {
    }
}