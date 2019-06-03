package main;

import java.util.Collections;
import java.util.LinkedList;
import java.util.*;

public class LinkedListUtils {

	public static LinkedList<Integer> insertSorted(LinkedList<Integer> list, int value) {

		list.add(value);
	    Collections.sort(list);
	    return list;

	}
	
	public static void removeMaximumValues(LinkedList<String> list1,  int N) {
		if (list1!=null && !list1.isEmpty()&& N>0) {
			int cont =1;
			while( cont<=N ) {
				String tope = Collections.max(list1);
				list1.removeIf(element -> Objects.equals(element, tope));
				cont++;		
			}	
		}
	}


	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {

		 if (one != null && !one.isEmpty() && two != null && !two.isEmpty()) {            
	            return Collections.indexOfSubList(one, two) != -1;
	                  }
	        return false;
	        }
}


	
		
		

