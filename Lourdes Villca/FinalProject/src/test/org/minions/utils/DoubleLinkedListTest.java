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
        assertEquals(student1.getRfid(), studentList.getElementAtIndex(2).getRfid());
        assertEquals(student2.getRfid(), studentList.getElementAtIndex(1).getRfid());
        assertEquals(student3.getRfid(), studentList.getElementAtIndex(0).getRfid());
    }

    @Test
    public void testInsertDataAtEnd() {
        studentList.insertDataAtEnd(student1);
        studentList.insertDataAtEnd(student2);
        studentList.insertDataAtEnd(student3);
        assertEquals(student1.getRfid(),studentList.getElementAtIndex(0).getRfid());
        assertEquals(student2.getRfid(),studentList.getElementAtIndex(1).getRfid());
        assertEquals(student3.getRfid(),studentList.getElementAtIndex(2).getRfid());
    }

    @Test
    public void testGetData() {
        studentList.insertDataAtEnd(student1);
        studentList.insertDataAtEnd(student2);
        studentList.insertDataAtEnd(student3);
        Student response = studentList.getData(student1);
        assertEquals(student1.getRfid(), response.getRfid());
    }

    @Test
    public void testGetNode(){
        studentList.insertDataAtEnd(student1);
        studentList.insertDataAtEnd(student2);
        studentList.insertDataAtEnd(student3);
        assertEquals(student1.getRfid(),((Student)studentList.getNode(student1).getValue()).getRfid());
    }

    @Test
    public void getElementAt() {
    }
}