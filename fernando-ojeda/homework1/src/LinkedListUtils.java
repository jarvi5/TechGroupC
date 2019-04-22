import java.util.LinkedList;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */


public class LinkedListUtils {

    public static void insertSorted(LinkedList<Integer> list, int value) {
        int count = 0;
        if (list != null) {
            if(list.size() != 0){
                addList(list, value, count);
            }else {
                list.add(value);
            }
        }
    }

    private static void addList(LinkedList<Integer> list, int value, int count) {
        for (int data : list) {
            if (value <= data) {
                list.add(count, value);
                break;
            }else {
                if(count == list.size()-1){
                    list.addLast(value);
                    break;
                }
            }
            count++;
        }
    }


    public static void removeMaximumValues(LinkedList<String> list, int N) {
        int count = 0;
        String resultData = "";
        if (list != null) {
            if (N > list.size() || N == list.size()) {
                list.clear();
            } else {
                if (N > 0) {
                    while (count < N) {
                        for (int count2 = 0; count2 < list.size(); count2++) {
                            for (String aList : list) {
                                if (list.get(count2).compareTo(aList) > 0) {
                                    resultData = list.get(count2);
                                }
                            }
                        }
                        count++;
                        remove(list, resultData, N);
                    }
                }
            }
        }
    }

    private static void remove(LinkedList<String> list, String resultData, int N) {
        int count = 0;
        while (count < N) {
            for (int count2 = 0; count2 < list.size(); count2++) {
                if (list.get(count2).equals(resultData)) {
                    list.remove(count2);
                }
            }
            count++;
        }
    }

    public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {
        boolean result = false;
        int cant = 0;
        int data = 0;
        int count = 0;
        if ((one != null && two != null) && (one.size() != 0 && two.size() != 0)) {
            cant = getCant(one, two, cant, data, count);
            if (cant == two.size()) {
                result = true;
            }
        }
        return result;
    }

    private static int getCant(LinkedList<Integer> one, LinkedList<Integer> two, int cant, int data, int count) {
        while (count < two.size()) {
            for (int count2 = data; count2 < one.size(); count2++) {
                if (two.get(count).equals(one.get(count2))) {
                    cant++;
                    data = count2 + 1;
                    break;
                } else {
                    if (cant != 0) {
                        break;
                    }
                }
            }
            count++;
        }
        return cant;
    }

}
