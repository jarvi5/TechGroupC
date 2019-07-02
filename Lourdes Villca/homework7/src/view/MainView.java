package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private SearchPanel searchPanel;
    private NavigatePanel navigateList;
    private SearchResult searchResult;

    public MainView() {
        super("Homework 7");
        searchPanel = new SearchPanel();
        navigateList = new NavigatePanel();
        searchResult = new SearchResult();
        Container frame = getContentPane();
        setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
        frame.add(searchPanel);
        frame.add(navigateList);
        frame.add(searchResult);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        setVisible(true);
        Controller c = new Controller(searchPanel,navigateList,searchResult);
        c.initController();

    }
}
