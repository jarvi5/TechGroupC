import java.util.LinkedList;
import java.util.List;

public class LinkedListUtils {

    public static void insertSorted(LinkedList<Integer> list, int value) {
        if(list == null){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.getMessage();
            }
        }else if(list.isEmpty()){
            list.add(value);
        }else{
            int actualSize = list.size();
            for (int indexList = 0; indexList < list.size(); indexList++) {
                if ((int) list.get(indexList) >= value) {
                    list.add(indexList, value);
                    break;
                }
            }
            if(actualSize == list.size()){
                list.addLast(value);
            }
        }
    }

    public static void removeMaximumValues(LinkedList<String> list, int N) {
        if (list == null) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.getMessage();
            }
        } else {
            while (N > 0) {
                deleteElementsBySize(list, findMax(list));
                N--;
            }
        }
    }

    public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {
        if (one == null || two == null) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.getMessage();
            }
        } else if(two.isEmpty()){
            return false;
        }else {
            for (int indexList = 0; indexList < one.size(); indexList++) {
                if (one.get(indexList) == two.get(0)) {
                    try {
                        List list = one.subList(indexList, indexList+two.size());
                        if(list.equals(two)){
                            return true;
                        }else {
                            return false;
                        }
                    } catch (Exception e) {
                        return false;
                    }

                }
            }
        }
        return false;
    }
    private static int findMax(LinkedList list)
    {
        int max = 0;
        for (Object valueInTheList: list) {
            if(String.valueOf(valueInTheList).length() > max){
                max = String.valueOf(valueInTheList).length();
            }
        }
        return max;
    }
    private static void deleteElementsBySize(LinkedList list, int sizeElement){
        LinkedList<Integer> listWithIndex = new LinkedList<>();
        for (int indexList = 0; indexList < list.size(); indexList++) {
            if(String.valueOf(list.get(indexList)).length() == sizeElement){
                listWithIndex.addFirst(indexList);
            }
        }
        for (Integer index: listWithIndex) {
            list.remove((int)index);
        }
    }
}