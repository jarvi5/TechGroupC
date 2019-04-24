import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class LinkedListUtils {

    public static void insertSorted(LinkedList<Integer> list, int value){
        if (list != null) {
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

    public static void removeMaximumValues(LinkedList<String> list, int N){
        if (list != null && !list.isEmpty()) {
            if (list.size() <= N) {
                list.clear();
                return;
            }

            LinkedList<String> tempList = new LinkedList<>(list);
            for (int i = 1; i < tempList.size(); i++){
                String lastValue = tempList.get(i - 1);
                String value = tempList.get(i);
                if (lastValue.compareTo(value) < 0 && N >= 0){
                    list.removeAll(Collections.singleton(value));
                    N--;
                }
            }
        }
    }

    public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two){
        boolean isSubsequence = false;

        if (one != null && two != null && !one.isEmpty() && !two.isEmpty()){
            LinkedList<Integer> subList = new LinkedList<>();
            for (int i = 0; i <= one.size() - two.size(); i++) {
                if (one.get(i).equals(two.get(0))){
                    subList.addAll(one.subList(i, two.size() + i));
                    isSubsequence = IntStream.range(0, two.size())
                            .allMatch(x -> subList.get(x).equals(two.get(x)));
                }
            }
        }
        return isSubsequence;
    }
}
