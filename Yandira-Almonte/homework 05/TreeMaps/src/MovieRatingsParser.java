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
		TreeMap<String,PriorityQueue<Integer>> movieRatings = new TreeMap<>();
		PriorityQueue<Integer> ratingQueue = new PriorityQueue<>();;
		if(allUsersRatings!=null && !allUsersRatings.isEmpty())
		{
			for(UserMovieRating userRating:allUsersRatings){
				if(userRating!=null && 
				userRating.getMovie() != null && !userRating.getMovie().isEmpty() && 
				userRating.getUserRating()>=0 )
				{
					if(movieRatings.containsKey(userRating.getMovie().toLowerCase())){
						ratingQueue.add(userRating.getUserRating());
					}
					else{
						ratingQueue = new PriorityQueue<>();
						ratingQueue.add(userRating.getUserRating());
					}
					movieRatings.put(userRating.getMovie().toLowerCase(), ratingQueue);
					
					
				}
					
			}
		}
					
		return movieRatings;
	}

}
