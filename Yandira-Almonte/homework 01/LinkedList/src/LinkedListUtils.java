
import java.util.LinkedList;
import java.util.ListIterator;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {

	public static void insertSorted(LinkedList<Integer> list, int value) {
		if (list != null) {
			for (int index = 0; index < list.size(); index++) {
				if (list.get(index).intValue() >= value) {
					list.add(index, value);
					return;
				}
			}
			list.addLast(value);
		}
	}

	public static void removeMaximumValues(LinkedList<String> list, int N) {

		if (list != null && N>0) {
			while (N > 0) {
				if(!list.isEmpty()){
					int maxLength=findLargest(list);
					list.removeIf(element -> (element.length() == maxLength));
				}
				N--;
			}
		}		
	}

	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {
		boolean containsElements = false;
		int indexIterator = 0;
		if(one!=null && two!=null && two.size() <= one.size()) {
			if(two.isEmpty() || one.isEmpty())
				return false;
			ListIterator<Integer> iterator = one.listIterator();
			while (iterator.hasNext()) {
				indexIterator = iterator.nextIndex();
				if (one.get(indexIterator) == two.getFirst()) {
					if ((indexIterator + two.size() <= one.size()) && two.containsAll(one.subList(indexIterator, indexIterator + two.size())))
						return true;
				}
				iterator.next();
			}
		}
		return containsElements;
	}

	private static int findLargest(LinkedList<String> list) {
		int indexMax = 0;
		int indexIterator = 0;
		ListIterator<String> iterator = list.listIterator();
		while (iterator.hasNext()) {
			indexIterator = iterator.nextIndex();
			if (list.get(indexMax).length()<=iterator.next().length()) {
				indexMax = indexIterator;
			}
		}
		return list.get(indexMax).length();
	}

}
