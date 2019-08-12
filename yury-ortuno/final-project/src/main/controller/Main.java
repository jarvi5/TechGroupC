package main.controller;

import main.view.App;

/**
 * Created by Yury Ortuno on 7/15/2019.
 */
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new App());
        controller.initController();
    }
}
