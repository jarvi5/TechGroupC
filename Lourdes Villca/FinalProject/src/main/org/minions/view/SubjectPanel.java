package org.minions.view;

import org.minions.MultiList;

import javax.swing.*;

public class SubjectPanel extends JPanel{
    private JList<MultiList> subjectList;
    SubjectPanel(){
        subjectList = new JList<>();
    }
}
