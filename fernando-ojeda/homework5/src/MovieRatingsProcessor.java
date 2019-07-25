/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.*;


public class MovieRatingsProcessor {

    public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
        List<String> result = new ArrayList<>();
        if (movieRatings != null && movieRatings.size() != 0) {
            for (Map.Entry<String, PriorityQueue<Integer>> movie : movieRatings.entrySet()) {
                String movieTitle = movie.getKey();
                result.add(movieTitle);
            }
            Collections.sort(result);
        }
        return result;
    }

    public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
        List<String> result = new ArrayList<>();
        if (movieRatings != null && movieRatings.size() != 0) {
            for (Map.Entry<String, PriorityQueue<Integer>> movie : movieRatings.entrySet()) {
                String movieTitle = movie.getKey();
                PriorityQueue<Integer> ratingMovies = movie.getValue();
                int count = 0;
                for (int ratingMovie : ratingMovies) {
                    if (ratingMovie <= rating) {
                        break;
                    } else {
                        if (count >= ratingMovies.size() - 1) {
                            result.add(movieTitle);
                        }
                    }
                    count++;
                }
            }
            Collections.sort(result);
        }
        return result;
    }

    public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
        TreeMap<String, Integer> result = new TreeMap<>();
        if (movieRatings != null && movieRatings.size() != 0) {
            for (Map.Entry<String, PriorityQueue<Integer>> movie : movieRatings.entrySet()) {
                String movieTitle = movie.getKey();
                PriorityQueue<Integer> ratingMovies = movie.getValue();
                int count = 0;
                for (int count2 = ratingMovies.size(); count2 > 0 ; count2--) {
                    int ratingMovie = ratingMovies.peek();
                    if (ratingMovie < rating) {
                        ratingMovies.remove(ratingMovie);
                        count++;
                    }
                }
                if (count != 0) {
                    result.put(movieTitle, count);
                }
            }
        }
        return result;
    }
}
