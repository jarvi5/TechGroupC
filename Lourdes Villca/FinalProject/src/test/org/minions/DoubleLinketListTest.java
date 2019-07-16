package org.minions;

import org.junit.Before;
import org.junit.Test;
import org.minions.model.Student;

import static org.junit.Assert.*;

public class DoubleLinketListTest {

    private DoubleLinketList<Student> studentList;
    private Student student1, student2, student3;

    @Before
    public void setup() {
        studentList = new DoubleLinketList<>();
        student1 = new Student("Miriam", "Huanca", "123455");
        student2 = new Student("Lourdes", "Villca", "123456");
        student3 = new Student("Miriam", "Huanca", "123457");
    }

    @Test
    public void testInsertDataAtFirst() {
        studentList.insertDataAtFirst(student1);
        studentList.insertDataAtFirst(student2);
        studentList.insertDataAtFirst(student3);
        assertEquals(student1.getCi(), studentList.getElementAt(2).getCi());
        assertEquals(student2.getCi(), studentList.getElementAt(0).getCi());
        assertEquals(student3.getCi(), studentList.getElementAt(1).getCi());
    }

    @Test
    public void testInsertDataAtEnd() {
        studentList.insertDataAtEnd(student1);
        studentList.insertDataAtEnd(student2);
        studentList.insertDataAtEnd(student3);
        assertEquals(student1.getCi(),studentList.getElementAt(0).getCi());
        assertEquals(student2.getCi(),studentList.getElementAt(1).getCi());
        assertEquals(student3.getCi(),studentList.getElementAt(2).getCi());
    }

    @Test
    public void getData() {

    }

    @Test
    public void getNode() {
    }

    @Test
    public void addChild() {
    }

    @Test
    public void getElementAt() {
    }
}