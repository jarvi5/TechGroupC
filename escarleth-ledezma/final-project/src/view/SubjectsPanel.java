package view;

import javax.swing.*;
import java.awt.*;

public class SubjectsPanel extends JPanel  {
    private JList list;
    private JPanel principalPanel;
    private JPanel buttonsPanel;
    private SubjectDetailsPanel panel;
    private JButton edit, delete, cancel;
    private JSplitPane splitPane;
    private JScrollPane listScrollPane,pictureScrollPane;
//ToDo just examples
    private String[] imageNames = {"Mate", "Fisica", "Quimica", "Algebra", "Calculo", "Ecuaciones",
            "Ingles", "Gestion", "Estadistica", "Grafos", "Planeo", "Estructura de Datos"};


    public SubjectsPanel() {
        this.initComponents();
        this.addComponents();
        this.modifyComponents();
    }
    public void initComponents() {
        edit = new JButton("Edit");
        delete = new JButton("Delete");
        cancel = new JButton("Cancel");

        buttonsPanel = new JPanel();
        principalPanel = new JPanel();
        panel = new SubjectDetailsPanel();

        list = new JList(imageNames);
        listScrollPane = new JScrollPane(list);
        pictureScrollPane = new JScrollPane(principalPanel);
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listScrollPane, pictureScrollPane);
    }

    public void addComponents() {
        buttonsPanel.setLayout(new GridLayout(3, 1));
        buttonsPanel.add(edit);
        buttonsPanel.add(delete);
        buttonsPanel.add(cancel);

        principalPanel.setLayout(new BorderLayout(2, 2));
        principalPanel.add(buttonsPanel, BorderLayout.EAST);
        principalPanel.add(panel, BorderLayout.CENTER);
    }

    public void modifyComponents() {
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);

        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(150);
        splitPane.setPreferredSize(new Dimension(500, 200));

        Dimension minimumSize = new Dimension(100, 50);
        listScrollPane.setMinimumSize(minimumSize);
        pictureScrollPane.setMinimumSize(minimumSize);
    }

    public JList getList() {
        return list;
    }

    public JSplitPane getSplitPane() {
        return splitPane;
    }
}