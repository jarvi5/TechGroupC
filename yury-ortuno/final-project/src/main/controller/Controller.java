package main.controller;

import main.view.App;

public class Controller {
    private App view;

    public Controller(App view) {
        this.view = view;
    }

    public void initController() {
        view.getAddButton().addActionListener(e -> addStudent());
    }

    private void addStudent() {
        if (view.getFirstNameTxt().getText().equals("yury")) {
            view.getLastNameTxt().setText("yver");
        }
    }

}