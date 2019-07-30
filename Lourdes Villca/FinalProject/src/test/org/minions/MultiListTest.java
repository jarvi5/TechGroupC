package org.minions;

import org.junit.Before;
import org.junit.Test;
import org.minions.model.Student;
import org.minions.model.Subject;

import static org.junit.Assert.*;

public class MultiListTest {
    private MultiList multiList;
    private Student student1, student2, student3;

    @Before
    public void setup() {
        multiList = new MultiList();
        student1 = new Student("Miriam", "Huanca", "123455");
        student2 = new Student("Lourdes", "Villca", "123456");
        student3 = new Student("Moni", "Pardo", "123457");
    }

    @Test
    public void testInsertDataAtFirst() {
        multiList.insertDataAtFirst(student1);
        multiList.insertDataAtFirst(student2);
        multiList.insertDataAtFirst(student3);
        assertEquals(student1.getCi(), ((Student)multiList.getElementAt(2)).getCi());
        assertEquals(student2.getCi(), ((Student)multiList.getElementAt(1)).getCi());
        assertEquals(student3.getCi(), ((Student)multiList.getElementAt(0)).getCi());
    }
    @Test
    public void testInsertDataAtEnd() {
        multiList.insertDataAtEnd(student1);
        multiList.insertDataAtEnd(student2);
        multiList.insertDataAtEnd(student3);
        assertEquals(student1.getCi(),((Student)multiList.getElementAt(0)).getCi());
        assertEquals(student2.getCi(),((Student)multiList.getElementAt(1)).getCi());
        assertEquals(student3.getCi(),((Student)multiList.getElementAt(2)).getCi());
    }
    @Test
    public void testAddChild() {
        multiList.insertDataAtFirst(student1);
        multiList.insertDataAtFirst(student2);
        multiList.insertDataAtFirst(student3);
        Subject subject1 = new Subject("ProgrammingI", "P-01",89);
        Subject subject2 = new Subject("English I","E-01",70);
        multiList.addChild(student1,subject1);
        multiList.addChild(student1,subject2);
        assertEquals(subject1.getId(), ((Subject)multiList.getNode(student1).getChild().getValue()).getId());
        assertEquals(subject2.getId(), ((Subject)multiList.getNode(student1).getChild().getNext().getValue()).getId());
    }

}