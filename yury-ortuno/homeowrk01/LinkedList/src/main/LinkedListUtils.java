package main;

import java.util.LinkedList;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {

    public static void insertSorted(LinkedList<Integer> list, int value) {
        if (list == null) return;
        if (list.isEmpty() || list.getLast() <= value) {
            list.addLast(value);
        } else {
            for (int index = 0; index < list.size(); index++) {
                if (list.get(index) >= value) {
                    list.add(index, value);
                    return;
                }
            }
        }
    }


    public static void removeMaximumValues(LinkedList<String> list, int N) {
        if (list == null || N < 0) {
            return;
        }
        if (N >= list.size()) {
            list.clear();
            return;
        }
        while (N > 0) {
            String than = "";
            for (int index = 0; index < list.size() - 1; index++) {
                if (list.get(index).compareTo(list.get(index + 1)) > 0) {
                    than = list.get(index);
                }
            }
            String finalThan = than;
            list.removeIf(element -> element.compareTo(finalThan) == 0);
            N--;
        }
    }

    public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {
        if (one == null || two == null || one.isEmpty() || two.isEmpty()) {
            return false;
        }
        while (true) {
            int position = one.indexOf(two.getFirst());
            if (position < 0) break;
            if (one.size() - 1 >= two.size() + position - 1) {
                if (one.subList(position, two.size() + position).equals(two)) {
                    return true;
                }
            }
            one.remove(position);
        }
        return false;
    }
}
