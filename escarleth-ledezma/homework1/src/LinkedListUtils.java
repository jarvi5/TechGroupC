import java.util.Collections;
import java.util.LinkedList;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {

    public static void insertSorted(LinkedList<Integer> list, int value) {
        if (list != null) {
            list.add(value);
            Collections.sort(list);
        }
    }

    public static void removeMaximumValues(LinkedList<String> list, int N) {
        if (list != null && N > 0 && !list.isEmpty()) {
            for (int count = 0; count < N; count++) {
                if (!list.isEmpty()) {
                    String maxValue = Collections.max(list);
                    list.removeIf(maxValue::equals);
                }
            }
        }
    }

    public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {
        if (one == null || two == null || one.isEmpty() || two.isEmpty()) {
            return false;
        }
        int startIndex = one.indexOf(two.getFirst());
        if (startIndex == -1 || startIndex + two.size() > one.size()) {
            return false;
        }
        return one.subList(startIndex, startIndex + two.size()).equals(two);
    }
}
