/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

    public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
        TreeMap<String, PriorityQueue<Integer>> map = new TreeMap<>();

        if (allUsersRatings != null) {
            for (UserMovieRating movieRating : allUsersRatings) {
                parseRatings(map, movieRating);
            }
        }

        return map;
    }

    private static void parseRatings(TreeMap<String, PriorityQueue<Integer>> map, UserMovieRating movieRating) {
        if (movieRating != null && movieRating.getMovie() != null
                && movieRating.getMovie().length() != 0 && movieRating.getUserRating() > 0) {
            // get movie and rating
            String movie = movieRating.getMovie().toLowerCase();
            int rating = movieRating.getUserRating();

            // add rating if movie exists, add new movie key with rating if doesn't
            if (map.containsKey(movie)) {
                map.get(movie).add(rating);
            } else {
                PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
                priorityQueue.add(rating);
                map.put(movie, priorityQueue);
            }
        }
    }
}
