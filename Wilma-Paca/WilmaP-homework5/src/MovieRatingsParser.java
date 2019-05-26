package movieRating;
/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

	public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
		
		/* IMPLEMENT THIS METHOD! */
		TreeMap<String, PriorityQueue<Integer>> treeMap = new TreeMap<String, PriorityQueue<Integer>>();
		
		try { 
			if(allUsersRatings != null  ) {
				if(!allUsersRatings.isEmpty()) {
					treeMap = movieRating(allUsersRatings);
				}
				
			}
			
		}catch (Exception e){
			System.out.println("List is not valid"); 
	     }
		return treeMap;// this line is here only so this code will compile if you don't modify it
	}
	
	public static TreeMap<String, PriorityQueue<Integer>> movieRating(List<UserMovieRating> listUsersRatings){
				
		TreeMap<String, PriorityQueue<Integer>> treeMap = new TreeMap<String, PriorityQueue<Integer>>();				
		Iterator<UserMovieRating> it = listUsersRatings.listIterator();
		
		try {
			while(it.hasNext()){
				UserMovieRating movie = it.next();
				
				if(validData(movie) == true) {
					
					if(!movieNameExist(movie,treeMap)) {						
						createMovieRating(treeMap,movie.getMovie().toLowerCase(),movie.getUserRating());					
						
					}else {
						treeMap.get(movie.getMovie().toLowerCase()).add(movie.getUserRating());										
						
					}
				}
			}
		}catch  (Exception e){
			System.out.println("Null object"); 
	     }
		return treeMap;
		
	}
	
	private static void createMovieRating(TreeMap<String, PriorityQueue<Integer>> treeMap, String movieName, int rating) {
	
		PriorityQueue<Integer>  queue = new PriorityQueue<Integer>();
		queue.add(Integer.valueOf(rating));
		treeMap.put(movieName,queue);
		
	}
	
	private static boolean validData(UserMovieRating object) {
		
		boolean flag = false;
		
		if(!object.equals(null) ) {
			if( object.getMovie() != null ) {
				if(!object.getMovie().isEmpty()) {
					if( Integer.valueOf(object.getUserRating()) != null) {
						if( object.getUserRating() > 0 ) {
							return true;
						
						}
					}
					
				}
			}
			
		}
		
		return flag;
	}
	
	
	private static boolean movieNameExist(UserMovieRating object,TreeMap<String, PriorityQueue<Integer>> treeMap){
		boolean flag = false;
		if(treeMap.containsKey(object.getMovie().toLowerCase())) {
			
			return true;
		}
		
		return flag;
		
	}

}
