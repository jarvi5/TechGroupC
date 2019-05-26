/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.*;


public class MovieRatingsProcessor {

	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
		List<String> alphabeticalMoviesList = new ArrayList<>();
		if(movieRatings == null || movieRatings.isEmpty()){
			return alphabeticalMoviesList;
		}
		alphabeticalMoviesList.addAll(movieRatings.keySet());
		return alphabeticalMoviesList;
	}

	public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		List<String> alphabeticalMoviesList = new ArrayList<>();
		if(movieRatings == null || movieRatings.isEmpty()){
			return alphabeticalMoviesList;
		}
		for(Map.Entry<String, PriorityQueue<Integer>> entry : movieRatings.entrySet()) {
			if(entry.getValue().peek() > rating) {
				alphabeticalMoviesList.add(entry.getKey());
			}
		}
		return alphabeticalMoviesList;
	}
	
	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
        TreeMap<String, Integer> removedTreeMap = new TreeMap<>();
	    if(movieRatings == null || movieRatings.isEmpty()){
            return removedTreeMap;
        }
        Iterator<Map.Entry<String, PriorityQueue<Integer>>> entries = movieRatings.entrySet().iterator();
        while (entries.hasNext()){
            Map.Entry<String, PriorityQueue<Integer>> entryMap = entries.next();
            Iterator<Integer> ratings = entryMap.getValue().iterator();
            while(ratings.hasNext()){
                if(ratings.next() < rating){
                    ratings.remove();
                    putTreeMap(removedTreeMap,entryMap);
                }
            }
            if(entryMap.getValue().isEmpty()){
                entries.remove();
            }
        }
        return removedTreeMap;
	}

	private static void putTreeMap(TreeMap<String, Integer> treeMap, Map.Entry<String, PriorityQueue<Integer>> entryMap){
        if(!treeMap.containsKey(entryMap.getKey())) {
            treeMap.put(entryMap.getKey(), 1);
        }else{
            treeMap.put(entryMap.getKey(), treeMap.get(entryMap.getKey()) + 1);
        }
    }
}
