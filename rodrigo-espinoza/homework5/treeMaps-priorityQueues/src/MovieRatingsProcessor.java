/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.*;


public class MovieRatingsProcessor {

    public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
        List<String> alphabeticalMovies = new ArrayList<>();
        if (movieRatings == null || movieRatings.isEmpty()) {
            return alphabeticalMovies;
        }
        alphabeticalMovies.addAll(movieRatings.keySet());
        return alphabeticalMovies;
    }

    public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
        List<String> movies = new LinkedList<>();
        if (movieRatings != null && !movieRatings.isEmpty()) {
            String firstTitle = movieRatings.firstKey();
            SortedMap<String, PriorityQueue<Integer>> sortedMap = movieRatings.tailMap(firstTitle);
            for (String title : sortedMap.keySet()) {
                PriorityQueue<Integer> ratings = sortedMap.get(title);
                if (ratings.peek() > rating) {
                    movies.add(title);
                }
            }
        }
        return movies;
    }

    public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
        if (movieRatings == null) {
            return new TreeMap<String, Integer>();
        }
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        Iterator<Map.Entry<String, PriorityQueue<Integer>>> entries = movieRatings.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, PriorityQueue<Integer>> current = entries.next();
            int removedCount = 0;
            while (current.getValue().size() != 0 && current.getValue().peek() < rating) {
                current.getValue().remove();
                removedCount++;
            }
            if (removedCount > 0) {
                map.put(current.getKey(), removedCount);
            }
            if (current.getValue().size() == 0) {
                entries.remove();
            }
        }
        return map;
    }
}
