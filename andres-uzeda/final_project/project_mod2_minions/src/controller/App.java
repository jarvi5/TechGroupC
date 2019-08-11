package controller;

import view.View;
import view.View4;

public class App {
    public static void main(String[] args) {
        View4 view4 = new View4();
        Controller c = new Controller(view4);
        c.initController();
    }
}