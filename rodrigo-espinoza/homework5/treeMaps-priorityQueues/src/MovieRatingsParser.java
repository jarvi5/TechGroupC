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
		TreeMap<String, PriorityQueue<Integer>> movies = new TreeMap<>();
		if(allUsersRatings == null || allUsersRatings.isEmpty()){
			return movies;
		}
		for(UserMovieRating movieRating : allUsersRatings){
			if(movieRating == null || movieRating.getMovie() == null || movieRating.getMovie().isEmpty() || movieRating.getUserRating() < 0){
				continue;
			}
			String movieName = movieRating.getMovie().toLowerCase();
			PriorityQueue<Integer> rating;
			if(movies.containsKey(movieName)){
				rating = movies.get(movieName);
				rating.add(movieRating.getUserRating());
			}
			else{
				rating = new PriorityQueue<>();
				rating.add(movieRating.getUserRating());
				movies.put(movieName, rating);
			}
		}
		return movies;
	}

}
