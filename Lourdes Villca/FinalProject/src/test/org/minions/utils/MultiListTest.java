package org.minions.utils;

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
        assertEquals(student1.getRfid(), ((Student)multiList.getElementAt(2)).getRfid());
        assertEquals(student2.getRfid(), ((Student)multiList.getElementAt(1)).getRfid());
        assertEquals(student3.getRfid(), ((Student)multiList.getElementAt(0)).getRfid());
    }
    @Test
    public void testInsertDataAtEnd() {
        multiList.insertDataAtEnd(student1);
        multiList.insertDataAtEnd(student2);
        multiList.insertDataAtEnd(student3);
        assertEquals(student1.getRfid(),((Student)multiList.getElementAt(0)).getRfid());
        assertEquals(student2.getRfid(),((Student)multiList.getElementAt(1)).getRfid());
        assertEquals(student3.getRfid(),((Student)multiList.getElementAt(2)).getRfid());
    }
    @Test
    public void testAddChild() {
        multiList.insertDataAtFirst(student1);
        multiList.insertDataAtFirst(student2);
        multiList.insertDataAtFirst(student3);
        Subject subject1 = new Subject("ProgrammingI", "P-01",89);
        Subject subject2 = new Subject("English I","E-01",70);
        Subject subject3 = new Subject("English II","E-02",75);
        Subject subject4 = new Subject("Calculo II","C-02",75);
        multiList.addChild(student1,subject1);
        multiList.addChild(student1,subject2);
        multiList.addChild(student1,subject3);
        multiList.addChild(student1,subject4);
        assertEquals(subject1.getId(), ((Subject)multiList.getParentNode(student1).getChild().getElementAtIndex(0)).getId());
        assertEquals(subject2.getId(), ((Subject)multiList.getParentNode(student1).getChild().getElementAtIndex(1)).getId());
    }

}