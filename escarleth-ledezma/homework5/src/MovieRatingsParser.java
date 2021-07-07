/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.*;
import java.util.stream.Collectors;

public class MovieRatingsParser {
    public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
        TreeMap<String, PriorityQueue<Integer>> map = new TreeMap<>();
        if (allUsersRatings != null && !allUsersRatings.isEmpty()) {
            List<UserMovieRating> userListUpdated = updateUserList(allUsersRatings);
            userListUpdated.forEach(user -> {
                String toLower = user.getMovie().toLowerCase();
                PriorityQueue<Integer> ratingList = map.containsKey(toLower) ? map.get(toLower) : new PriorityQueue<>();
                ratingList.add(user.getUserRating());
                map.put(toLower, ratingList);
            });
        }
        return map;
    }

    private static List<UserMovieRating> updateUserList(List<UserMovieRating> allUsersRatings) {
        allUsersRatings.removeIf(Objects::isNull);
        return allUsersRatings.stream()
                .filter(user -> !user.getMovie().isEmpty()&&user.movie != null && user.getUserRating() >= 0)
                .collect(Collectors.toList());
    }

}
