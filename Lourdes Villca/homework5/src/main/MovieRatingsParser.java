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
        TreeMap<String, PriorityQueue<Integer>> movieRatingList = new TreeMap<>();
        if (allUsersRatings == null) return movieRatingList;
        allUsersRatings.forEach(userMovieRating -> {
            if (userMovieRating == null || userMovieRating.movie == null || userMovieRating.movie.isEmpty() || userMovieRating.userRating < 0)
                return;
            String key = userMovieRating.movie.toLowerCase();
            PriorityQueue<Integer> ratingList;
            ratingList = movieRatingList.containsKey(key)? movieRatingList.get(key):new PriorityQueue<>();
            ratingList.add(userMovieRating.userRating);
            movieRatingList.put(key, ratingList);
        });
        return movieRatingList;
    }

}
