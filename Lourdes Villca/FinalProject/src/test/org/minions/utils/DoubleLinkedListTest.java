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
        studentList.insertElementAtFirst(student1);
        studentList.insertElementAtFirst(student2);
        studentList.insertElementAtFirst(student3);
        assertEquals(student1.getRfid(), studentList.getElementAtIndex(2).getRfid());
        assertEquals(student2.getRfid(), studentList.getElementAtIndex(1).getRfid());
        assertEquals(student3.getRfid(), studentList.getElementAtIndex(0).getRfid());
    }

    @Test
    public void testInsertDataAtEnd() {
        studentList.insertElementAtEnd(student1);
        studentList.insertElementAtEnd(student2);
        studentList.insertElementAtEnd(student3);
        assertEquals(student1.getRfid(),studentList.getElementAtIndex(0).getRfid());
        assertEquals(student2.getRfid(),studentList.getElementAtIndex(1).getRfid());
        assertEquals(student3.getRfid(),studentList.getElementAtIndex(2).getRfid());
    }

    @Test
    public void testGetData() {
        studentList.insertElementAtEnd(student1);
        studentList.insertElementAtEnd(student2);
        studentList.insertElementAtEnd(student3);
        Student response = studentList.getData(student1);
        assertEquals(student1.getRfid(), response.getRfid());
    }

    @Test
    public void testGetNode(){
        studentList.insertElementAtEnd(student1);
        studentList.insertElementAtEnd(student2);
        studentList.insertElementAtEnd(student3);
        assertEquals(student1.getRfid(),((Student)studentList.getNode(student1).getValue()).getRfid());
    }

    @Test
    public void testGetElementAtIndexZero() {
        int index = 0;
        studentList.insertElementAtEnd(student1);
        studentList.insertElementAtEnd(student2);
        studentList.insertElementAtEnd(student3);
        Student elementAtIndex = studentList.getElementAtIndex(index);
        assertEquals(student1.getRfid(), elementAtIndex.getRfid());
    }
    @Test
    public void testGetElementAtIndexOne() {
        int index = 1;
        studentList.insertElementAtEnd(student1);
        studentList.insertElementAtEnd(student2);
        studentList.insertElementAtEnd(student3);
        Student elementAtIndex = studentList.getElementAtIndex(index);
        assertEquals(student2.getRfid(), elementAtIndex.getRfid());
    }

    @Test
    public void testDeleteFirstElement(){
        studentList.insertElementAtEnd(student1);
        studentList.insertElementAtEnd(student2);
        studentList.insertElementAtEnd(student3);
        studentList.deleteFirstElement();
        assertEquals(studentList.getSize(),2);
        assertNull(studentList.getData(student1));
    }
    @Test
    public void testDeleteLastElement(){
        studentList.insertElementAtEnd(student1);
        studentList.insertElementAtEnd(student2);
        studentList.insertElementAtEnd(student3);
        studentList.deleteLastElement();
        assertEquals(studentList.getSize(),2);
        assertNull(studentList.getData(student3));
    }
    @Test
    public void testDeleteElementAtIndex(){
        int index = 1;
        studentList.insertElementAtEnd(student1);
        studentList.insertElementAtEnd(student2);
        studentList.insertElementAtEnd(student3);
        studentList.deleteElementAtIndex(index);
        assertEquals(studentList.getSize(),2);
        assertNull(studentList.getData(student2));
    }
}