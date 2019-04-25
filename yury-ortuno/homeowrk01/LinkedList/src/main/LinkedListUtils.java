package main;

import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Objects;

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

		two.forEach(element->{
		    if (one.contains(element)){
		        int index=one.indexOf(element);
                for (int i = one.indexOf(element); i < one.size(); i++) {

                }
            }
        });

        return true; // this line is here only so this code will compile if you don't modify it
    }
}
