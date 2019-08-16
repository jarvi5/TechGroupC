package org.minions.utils;

import org.junit.Before;
import org.junit.Test;
import org.minions.model.Student;
import org.minions.model.Subject;

import static org.junit.Assert.*;

public class NodeTest {
    private Node<Student> studentNode1;
    private Node<Student> studentNode2;
    private Node<Student> studentNode3;
    private Student student1, student2, student3;

    @Before
    public void setup() {
        student1 = new Student("Miriam", "Huanca", "123455");
        student2 = new Student("Lourdes", "Villca", "123456");
        student3 = new Student("Moni", "Pardo", "123457");
    }

    @Test
    public void testGetPrevious() {
        studentNode1 = new Node<>(student1);
        studentNode2 = new Node<>(student2);
        studentNode1.setPrevious(studentNode2);
        assertEquals(student2.getRfid(), studentNode1.getPrevious().getValue().getRfid());
    }

    @Test
    public void testSetPrevious() {
        studentNode1 = new Node<>(student1);
        studentNode2 = new Node<>(student2);
        studentNode3 = new Node<>(student3);
        studentNode1.setPrevious(studentNode2);
        studentNode2.setPrevious(studentNode3);
        assertEquals(student2.getRfid(), studentNode1.getPrevious().getValue().getRfid());
    }

    @Test
    public void testGetNext() {
        studentNode1 = new Node<>(student1);
        studentNode2 = new Node<>(student2);
        studentNode3 = new Node<>(student3);
        studentNode1.setNext(studentNode2);
        studentNode2.setNext(studentNode3);
        assertEquals(student2.getRfid(), studentNode1.getNext().getValue().getRfid());
        assertEquals(student3.getRfid(), studentNode2.getNext().getValue().getRfid());
    }

    @Test
    public void testSetNext() {
        studentNode1 = new Node<>(student1);
        studentNode2 = new Node<>(student2);
        studentNode3 = new Node<>(student3);
        studentNode1.setNext(studentNode2);
        studentNode2.setNext(studentNode3);
        assertEquals(student2.getRfid(), studentNode1.getNext().getValue().getRfid());
        assertEquals(student3.getRfid(), studentNode2.getNext().getValue().getRfid());
    }

    @Test
    public void testGetValue() {
        studentNode1 = new Node<>(student1);
        assertEquals(student1.getRfid(), studentNode1.getValue().getRfid());
    }

    @Test
    public void testSetValue() {
        studentNode1 = new Node<>(student1);
        studentNode1.setValue(student2);
        assertEquals(student2.getRfid(), studentNode1.getValue().getRfid());
    }

    @Test
    public void testSetChild() {
        DoubleLinkedList<Subject> subjectList = new DoubleLinkedList<Subject>();
        Subject subject1 = new Subject("Programming I", "P-01", 89);
        Subject subject2 = new Subject("English I", "E-01", 70);
        subjectList.insertDataAtEnd(subject1);
        subjectList.insertDataAtEnd(subject2);
        studentNode1 = new Node<>(student1);
        studentNode1.setChild(subjectList);
        assertEquals(2, studentNode1.getChild().getSize());
    }

    @Test
    public void testGetChild() {
        DoubleLinkedList<Subject> subjectList = new DoubleLinkedList<Subject>();
        Subject subject1 = new Subject("Programming I", "P-01", 89);
        Subject subject2 = new Subject("English I", "E-01", 70);
        subjectList.insertDataAtEnd(subject1);
        subjectList.insertDataAtEnd(subject2);
        studentNode1 = new Node<>(student1);
        studentNode1.setChild(subjectList);
        assertEquals(subject1.getId(), ((Subject)studentNode1.getChild().getElementAtIndex(0)).getId());
    }
}