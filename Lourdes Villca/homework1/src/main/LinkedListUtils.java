

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {

    /**
     * Method that insert elements in sorted way.
     *
     * @param list  Linked Lis of string elements.
     * @param value Value to be inserted
     */
    public static void insertSorted(LinkedList<Integer> list, int value) {
        if (list == null) {
            return;
        }
        if (list.size() == 0 || value <= list.getFirst()) {
            list.addFirst(value);
            return;
        }
        if (value >= list.getLast()) {
            list.addLast(value);
            return;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (value >= list.get(i) && value <= list.get(i + 1)) {
                list.add(i + 1, value);
                break;
            }
        }

    }

    /**
     * Method that remove maximun values of a linked list.
     *
     * @param list Linked list with String elements.
     * @param N    Number of maximun values that will be removed.
     */
    public static void removeMaximumValues(LinkedList<String> list, int N) {
        if (list == null || N < 0) {
            return;
        }
        if (N > list.size()) {
            list.clear();
            return;
        }
        while (N > 0) {
            String max = Collections.max(list);
            list.removeIf(element -> Objects.equals(element, max));
            N--;
        }
    }

    /**
     * Method that verify if a list contains all elements of the second one in the same order
     *
     * @param one LinkedList with Integer elements.
     * @param two LinkedList with Integer elements.
     * @return True if the second list is contained in the first one, False otherwise.
     */
    public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {
        if (one == null || two == null || one.isEmpty() || two.isEmpty()) {
            return false;
        }
        boolean result = false;
        LinkedList<Integer> sublist = new LinkedList<>();
        for (int i = 0; i <= one.size() - two.size(); i++) {
            if (one.get(i).equals(two.get(0))) {
                sublist.addAll(one.subList(i, i + two.size()));
                result = isSubsequence(sublist, two);
            }
        }
        return result;
    }

    /**
     * Method that verify if the second linked list contains all elements of the first one in the same order.
     *
     * @param sublist linked list of Integer elements.
     * @param two     linked list of Integer elements.
     * @return True if the second list is equal to the second one, False otherwise.
     */
    private static boolean isSubsequence(LinkedList<Integer> sublist, LinkedList<Integer> two) {
        for (int i = 1; i < sublist.size(); i++) {
            if (!sublist.get(i).equals(two.get(i))) {
                return false;
            }
        }
        return true;
    }
}
