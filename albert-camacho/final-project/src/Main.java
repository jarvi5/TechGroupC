import project.util.DoubleList;
import project.util.Node;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DoubleList<String> lista = new DoubleList<>();
        lista.add("text1");
        lista.add("text2");
        lista.add("text3");
        lista.add("text4");
        lista.add("text5");
        lista.add("text6");
        lista.add("text7");

        lista.add(0, "text8");
        System.out.println(lista.getSize());
        System.out.println(lista.get(0));
        System.out.println(lista.get(1));

    }

}
