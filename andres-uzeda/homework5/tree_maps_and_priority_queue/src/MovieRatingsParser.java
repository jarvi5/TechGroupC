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
		TreeMap<String, PriorityQueue<Integer>> ratingsTreeMap = new TreeMap<>();
		if(allUsersRatings == null || allUsersRatings.isEmpty()){
			return ratingsTreeMap;
		}
		for(UserMovieRating userMovieRating : allUsersRatings){
			if(userMovieRating == null || userMovieRating.getMovie() == null){
				continue;
			}
			if(userMovieRating.getMovie().isEmpty() || userMovieRating.getUserRating() < 0){
				continue;
			}
			String movie = userMovieRating.getMovie().toLowerCase();
			PriorityQueue<Integer> priorityQueue;
			if(ratingsTreeMap.containsKey(movie)){
				priorityQueue = ratingsTreeMap.get(movie);
				priorityQueue.add(userMovieRating.getUserRating());
			}else{
				priorityQueue = new PriorityQueue<>();
				priorityQueue.add(userMovieRating.getUserRating());
				ratingsTreeMap.put(movie, priorityQueue);
			}
		}
		return ratingsTreeMap;
	}
}
