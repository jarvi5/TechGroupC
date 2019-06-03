import java.util.*;

public class TestClass {
    public static void main(String[] args){
        LinkedList TestLinkedList = new LinkedList();
        TestLinkedList.add(new UserMovieRating("rocky", 5));
        TestLinkedList.add(new UserMovieRating("rocky", 4));
        TestLinkedList.add(new UserMovieRating("rambo", 4));
        TestLinkedList.add(new UserMovieRating("godzilla", 2));
        TreeMap<String, PriorityQueue<Integer>> treeMapcini = MovieRatingsParser.parseMovieRatings(TestLinkedList);
        for(Map.Entry<String, PriorityQueue<Integer>> entry : treeMapcini.entrySet()) {
            String key = entry.getKey();
            PriorityQueue<Integer> value = entry.getValue();
            System.out.println(key + " => " + value);
        }
        List<String> alphabeticalMoviesList = new ArrayList<>();
        alphabeticalMoviesList = MovieRatingsProcessor.getAlphabeticalMovies(treeMapcini);
        for (String movie : alphabeticalMoviesList) {
            System.out.println(movie);
        }
    }
}