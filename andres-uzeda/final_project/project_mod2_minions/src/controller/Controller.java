package controller;

import model.LinkedList;
import view.View;

import javax.swing.JOptionPane;
public class Controller {
    private LinkedList model;
    private View view;
    public Controller(LinkedList m, View v) {
        model = m;
        view = v;
        initView();
    }
    public void initView() {
    }
    public void initController() {
        /*view.getAddButton().addActionListener();
        view.getSearchButton().addActionListener();
        view.getNextButton().addActionListener();
        view.getPreviousButton().addActionListener();*/
    }


}