import java.util.LinkedList;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {
	
	public static boolean insertedValueByPosition(LinkedList<Integer> list, int value, int position) {
		boolean insertedFlag = false;
			
			if( value <= list.get(position)) {
				list.add(position, value);
				insertedFlag = true;
			}
			 
		return insertedFlag;
	}
	
	
	public static void insertSorted(LinkedList<Integer> list, int value) {

		/* IMPLEMENT THIS METHOD! */
		boolean insertedFlag=false;
		int position = 0;
		if(list != null) {			
			if(list.isEmpty()) {
				
				list.addFirst(value);
				System.out.println("first value inserted"+ list.getFirst());
				
			}else {
					if(value < list.getFirst()) {
						list.add(0, value);
					}else {	
						if(value > list.getLast()) {
						list.addLast(value);
					    }else {
							while(insertedFlag == false && position < list.size()) {							
									insertedFlag=insertedValueByPosition(list, value,position);
								    position++;
							}
					    }	
					}
				 }
			}else {
				System.out.println("insertSorted throws  when input LinkedList is null");
		}
	}
	

	 private static void removeMaximunValue(LinkedList<String> list, String maximun, int i){
	        if(i == list.size()){
	            list.remove(maximun);
	        } else {
	            if(list.get(i).length() > maximun.length() && i <= list.size()){
	                maximun = list.get(i);
	                i++;
	                removeMaximunValue(list, maximun, i);
	            }
	        }
	 }
	
	
	public static void removeMaximumValues(LinkedList<String> list, int N) {

		/* IMPLEMENT THIS METHOD! */
		int count = 0;
		if(list != null && !list.isEmpty()) {
			if(N>0) {
			if(list.size() != 1) {
								
				 while(N>count){
		                removeMaximunValue(list, list.getFirst(),0);
		                N--;
		            }
				 
				}else {
					list.removeFirst();
				}
				
			}
		}
		
	}
	
	private static boolean existOnList(LinkedList<Integer> one, LinkedList<Integer> two,int i,int x) {
		boolean value = false;
		for(int j=x; j<one.size();j++) {
			if(one.get(j)== two.get(i)) {
				if(two.size()>i) {
				existOnList(one,two,i+1,j+1);
				value = true;
				}
			}
		}
		return value;
	}
	
	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {

		/* IMPLEMENT THIS METHOD! */
		int i =0;
		int j =0;
		boolean value = false;
		if(one != null && !one.isEmpty()) {
			if(two != null && !two.isEmpty()) {
				while( i<two.size()) {
					value = existOnList(two,one,i,j);
				i++;
				j++;
				}
			}
		}
		
		return value; // this line is here only so this code will compile if you don't modify it
	}

}