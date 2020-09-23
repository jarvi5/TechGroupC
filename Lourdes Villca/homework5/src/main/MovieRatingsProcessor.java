/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.*;


public class MovieRatingsProcessor {

    public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
        return movieRatings == null ? new ArrayList<>() : new ArrayList<>(movieRatings.keySet());
    }

    public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
        ArrayList<String> result = new ArrayList<>();
        if (movieRatings == null) return result;
        for (Map.Entry<String, PriorityQueue<Integer>> movie : movieRatings.entrySet()) {
            if (checkRating(movie.getValue(), rating)) continue;
            result.add(movie.getKey());
        }
        return result;
    }

    public static boolean checkRating(PriorityQueue<Integer> ratingList, int rating) {
        return ratingList.peek() <= rating ? true : false;
    }

    public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
        TreeMap<String, Integer> result = new TreeMap<>();
        if(movieRatings==null) return result;
        for (Map.Entry<String, PriorityQueue<Integer>> movie : movieRatings.entrySet()) {
            PriorityQueue<Integer> ratingQueue = movie.getValue();
            int ratingQueueSize = ratingQueue.size();
            ratingQueue.removeIf(x -> x < rating);
            if (ratingQueue.size() < ratingQueueSize) {
                result.put(movie.getKey(), ratingQueueSize - ratingQueue.size());
            }
        }
        result.keySet().forEach(key -> {
            if(movieRatings.get(key).size() == 0) movieRatings.remove(key);
        });
        return result;
    }
}
