package controller;

import model.LinkedList;
import view.View;

public class App {
    public static void main(String[] args) {
        LinkedList m = new LinkedList();
        View v = new View("MVC Task");
        Controller c = new Controller(m, v);
        c.initController();
    }
}