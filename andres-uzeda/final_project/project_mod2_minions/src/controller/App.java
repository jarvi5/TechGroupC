package controller;

import view.View;

public class App {
    public static void main(String[] args) {
        View v = new View("MVC Task");
        Controller c = new Controller(v);
        c.initController();
    }
}