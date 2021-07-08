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
            for (Map.Entry<String, PriorityQueue<Integer>> movieRating : movieRatings.entrySet()) {
                PriorityQueue<Integer> ratings = movieRating.getValue();
                if (!ratings.isEmpty() && rating < ratings.peek()) {
                    movies.add(movieRating.getKey());
                }
            }
            Collections.sort(movies);
        }
        return movies;
    }

    public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
        TreeMap<String, Integer> movies = new TreeMap<>();

        if (movieRatings != null) {
            TreeMap<String, PriorityQueue<Integer>> movieIterator = new TreeMap<>(movieRatings);
            for (Map.Entry<String, PriorityQueue<Integer>> movieRating : movieIterator.entrySet()) {
                String movieTitle = movieRating.getKey();
                int ratingsRemoved = removeRatings(movieRating.getValue(), rating);

                if (movieRating.getValue().isEmpty())
                    movieRatings.remove(movieTitle);

                if (ratingsRemoved > 0)
                    movies.put(movieTitle, ratingsRemoved);

            }
        }

        return movies;
    }

    private static int removeRatings(PriorityQueue<Integer> priorityQueue, int rating) {
        int count = 0;
        if (!priorityQueue.isEmpty() && priorityQueue.peek() < rating) {
            priorityQueue.poll();
            count = 1 + removeRatings(priorityQueue, rating);
        }
        return count;
    }
}
