package movieRating;
/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;


public class MovieRatingsProcessor {

	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
		
		/* IMPLEMENT THIS METHOD! */
		List<String> movieListAlpha = new LinkedList(); 
		try { 
			if(movieRatings != null  ) {
				if(!movieRatings.isEmpty()) {
					return alphabeticalMovies(movieRatings,movieListAlpha);
				}
				
			}
			
		}catch (Exception e){
			System.out.println("TreeMap is not valid"); 
	     }
		return movieListAlpha; // this line is here only so this code will compile if you don't modify it
	}
	
	private static List<String> alphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> treeMap, List<String> movieListAlpha) {
		Iterator it = treeMap.keySet().iterator();
		while(it.hasNext()){
		  String key = (String) it.next();
		  movieListAlpha.add(key);
		  //System.out.println(key);
		}
		  return movieListAlpha;
	}

	public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		
		/* IMPLEMENT THIS METHOD! */
		List<String> movieListAlpha = new LinkedList(); 
		try { 
			if(movieRatings != null  ) {
				if(!movieRatings.isEmpty()) {
					return alphabeticalMoviesAboveRating(movieRatings,movieListAlpha,rating);
				}
				
			}
			
		}catch (Exception e){
			System.out.println("TreeMap is not valid"); 
	     }
		return movieListAlpha;  // this line is here only so this code will compile if you don't modify it
	}
	
	private static List<String> alphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> treeMap,List<String> movieListAlpha, int rating) {
		Iterator it = treeMap.keySet().iterator();
		
		try {
			while(it.hasNext()){
			  String key = (String) it.next();
			  
			  if(ratingAbove(treeMap.get(key),rating)) {
				  movieListAlpha.add(key);
			  }
			}
		}catch (Exception e){
			System.out.println("Invalid next node"); 
	     }
		return movieListAlpha;
	}
	
	private static boolean ratingAbove(PriorityQueue<Integer> queue, int rating) {
		boolean flag = false;
		Iterator it = queue.iterator();
		try {
			while(it.hasNext()) {
				Integer value = (Integer)it.next();
				if(value > rating) {
						flag= true;				
				}else {
					return false;
				}
			}
		}catch (Exception e){
			System.out.println("Invalid next value"); 
	     }
		return flag;
	}
	
	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		
		/* IMPLEMENT THIS METHOD! */
		TreeMap<String, Integer> map = new TreeMap<String, Integer>(); 
		try { 
			if(movieRatings != null  ) {
				if(!movieRatings.isEmpty()) {
					return removeMoviesBelowRating(movieRatings,map,rating);
				}
				
			}
			
		}catch (Exception e){
			System.out.println("TreeMap is not valid"); 
	     }
		return map; // this line is here only so this code will compile if you don't modify it
	}
	
	private static TreeMap<String, Integer> removeMoviesBelowRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, TreeMap<String, Integer> map, int rating){
		Iterator it = movieRatings.keySet().iterator();
		System.out.println("mapInit "+ movieRatings+ "  rating: "+ rating); 
		try {
			while(it.hasNext()){
			  String key = (String) it.next();
			  if(ratingBelow(movieRatings.get(key),rating) > 0) {
				  map.put(key, (ratingBelow(movieRatings.get(key),rating)));				  
				 
			  }
			}
		}catch (Exception e){
			System.out.println("Invalid value"); 
	     }
		System.out.println("map::: "+ map); 
		return map;
	}
	
	private static int ratingBelow(PriorityQueue<Integer> queue, int rating) {
		
		LinkedList<Integer> ratingList = new LinkedList<Integer>();
		LinkedList<Integer> ratingListRemoved = new LinkedList<Integer>();
		PriorityQueue<Integer> queueList = new PriorityQueue<Integer>();
		Iterator it = queue.iterator();
		
		try {
			while(it.hasNext()) {
				Integer value = (Integer)it.next();
				//System.out.println("value "+value+" rating "+rating); 
				if(value != null) {
					if(value >= rating) {
							ratingList.add(value);
							//queue.remove(value);
					}else {
						ratingListRemoved.add(value);
					}
				}
			}
		}catch (Exception e){
			System.out.println("Invalid value for rating"); 
	     }
		
		 queueListRemoved(ratingListRemoved);
		
		return ratingNumberRemoved(ratingListRemoved);
	}
	
	private static PriorityQueue<Integer> queueListRemoved(LinkedList<Integer> ratingList){
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();		
		for(int i =0; i< ratingList.size(); i++) {			
				queue.add(ratingList.get(i));			
		}
		
		return queue;
	}
	
	private static int ratingNumberRemoved(LinkedList<Integer>ratingListRemoved) {
		return ratingListRemoved.size();
	}
	
}

