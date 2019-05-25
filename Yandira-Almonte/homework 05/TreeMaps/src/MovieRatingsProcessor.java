/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.Iterator;



public class MovieRatingsProcessor {

	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
		List<String> movies = new ArrayList<>();
		if(movieRatings != null && !movieRatings.isEmpty()){
			for(Entry<String, PriorityQueue<Integer>> movie: movieRatings.entrySet())
				movies.add(movie.getKey());
			Collections.sort(movies);
		}
		
		return movies; // this line is here only so this code will compile if you don't modify it
	}

	public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		List<String> movies = new ArrayList<>();
		if (movieRatings != null && movieRatings.size() >= 0) {
			for(Entry<String, PriorityQueue<Integer>> movie: movieRatings.entrySet()){
				if(rating<movie.getValue().peek())
					movies.add(movie.getKey());
			}
			Collections.sort(movies);
		}
			
		return movies; // this line is here only so this code will compile if you don't modify it
	}
	
	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		TreeMap<String, Integer> movieRatingsRemoved = new TreeMap<>();
		if (movieRatings != null && !movieRatings.isEmpty()) {
			 TreeMap<String, PriorityQueue<Integer>> it=(TreeMap<String, PriorityQueue<Integer>>) movieRatings.clone();
			 for (Map.Entry<String, PriorityQueue<Integer>> movie : /*movieRatings*/it.entrySet()) {
				 int removedRatings=0;
				 for (Iterator<Integer> iterator = movie.getValue().iterator(); iterator.hasNext();){
				 	 int movieRating=iterator.next();
					 if( movieRating< rating)
					 {
						iterator.remove();
						removedRatings++;
					 }
					 
				}
				if(removedRatings>0){
					 movieRatingsRemoved.put(movie.getKey(), removedRatings);
				if(movie.getValue().isEmpty())
					movieRatings.remove(movie.getKey());
			 }
		
				
			 
			 }
			 
		 }
			
		return movieRatingsRemoved; // this line is here only so this code will compile if you don't modify it
	}
}
