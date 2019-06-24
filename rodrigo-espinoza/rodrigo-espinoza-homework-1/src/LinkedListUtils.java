

import java.util.Collections;
import java.util.LinkedList;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {
	
	public static void insertSorted(LinkedList<Integer> list, int value) {
	    if (list == null) {
		return;
	    }else {
	            if (list.isEmpty() || list.getLast() <= value){
	                list.add(value);
	            } else {
	                for (int i = 0; i < list.size(); i++){
	                    if (value <= list.get(i)){
	                        list.add(i, value);
	                        break;
	                    }
	                }
	            }
	    }
	        
	}
	

	public static void removeMaximumValues(LinkedList<String> list, int N) {
	    
	    if(list == null || N < 0) {		
		return;
	    }
	    if (list.size() <= N) {
                list.clear();
                return;
	    }else {
		for (int i = 0; i < N; i++) {
	                LinkedList<String> list2 = new LinkedList<>(list);
	                list2.sort(Collections.reverseOrder());
	                list.removeAll(Collections.singletonList(list2.get(0)));
	            }
	    }
	}
	
	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {

	    if (one == null || two == null || one.isEmpty() || two.isEmpty()) {
	            return false;
	        }
            int start = one.indexOf(two.getFirst());
            if (start < 0){
            return false;
            }
	            for (int i = 0; i < two.size(); i++) {
                    if (start + i >= one.size()){
                        return false;
                    }
	        	    if (!(one.get(start + i).equals(two.get(i))) {
	        	        return false;
	        	    }
                }
	        	return true;
    }
}
