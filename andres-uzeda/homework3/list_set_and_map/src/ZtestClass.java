import java.util.List;

public class ZtestClass {
    public static void main(String[] paramArrayOfString){
        List<Sentence> listanga = Analyzer.readFile("./homework3-files/test1.txt");
        for (Sentence e: listanga) {
            System.out.println(e.score + " *espacio* " + e.text);
            if("this is a test".equals(e.text)){ System.out.println("si");}else{System.out.println("no");}
        }
        System.out.println("size list: " + listanga.size());
        for (Sentence e: listanga) {
            System.out.println(e.score + " *espacio* " + e.text);
        }

    }
}
