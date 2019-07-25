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
        TreeMap<String, PriorityQueue<Integer>> result = new TreeMap<>();
        PriorityQueue<Integer> userRatings = null;
        if (allUsersRatings != null && allUsersRatings.size() != 0) {
            for (UserMovieRating userMovieRating : allUsersRatings) {
                if (userMovieRating != null && userMovieRating.getMovie() != null) {
                    userRatings = getIntegerPriorityQueue(result, userRatings, userMovieRating);
                }
            }
        }
        return result;
    }

    private static PriorityQueue<Integer> getIntegerPriorityQueue(TreeMap<String,
            PriorityQueue<Integer>> result, PriorityQueue<Integer> userRatings, UserMovieRating userMovieRating) {
        if (userMovieRating.getMovie().length() != 0 && userMovieRating.getUserRating() > 0) {
            String movie = userMovieRating.getMovie().toLowerCase();
            int userRating = userMovieRating.getUserRating();
            if (result.containsKey(movie)) {
                userRatings.add(userRating);
            } else {
                userRatings = new PriorityQueue<>();
                userRatings.add(userRating);
            }
            result.put(movie, userRatings);
        }
        return userRatings;
    }
}
