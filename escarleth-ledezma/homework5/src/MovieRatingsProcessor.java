/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.*;


public class MovieRatingsProcessor {

    public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
        List<String> movies = new ArrayList<>();
        if (movieRatings != null) {
            movies.addAll(movieRatings.keySet());
            Collections.sort(movies);
        }

        return movies;
    }

    public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
        List<String> movies = new ArrayList<>();
        if (movieRatings != null) {
            movieRatings.forEach((key, ratings) -> {
                if (!ratings.isEmpty() && rating < ratings.peek()) {
                    movies.add(key);
                }
            });
            Collections.sort(movies);
        }
        return movies;
    }

    public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
        TreeMap<String, Integer> map = new TreeMap<>();
        if (movieRatings != null) {
            movieRatings.forEach((key, ratingQueue) -> {
                int ratingQueueSize = ratingQueue.size();
                ratingQueue.removeIf(x -> x < rating);
                if (ratingQueue.size() < ratingQueueSize) {
                    map.put(key, ratingQueueSize - ratingQueue.size());
                }
            });
            map.keySet()
                    .stream().filter(key -> movieRatings.get(key).size() == 0).forEach(movieRatings::remove);
        }
        return map;
    }
}
