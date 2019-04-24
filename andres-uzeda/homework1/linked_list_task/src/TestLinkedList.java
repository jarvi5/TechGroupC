import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TestLinkedList {
    //LinkedList localLinkedList = new LinkedList();
    public static int findMax(LinkedList list)
    {
        int max = 0;
        for (Object valueInTheList: list) {
            if(String.valueOf(valueInTheList).length() > max){
                max = String.valueOf(valueInTheList).length();
            }
        }
        return max;
    }
    public static void deleteElementsBySize(LinkedList list, int sizeElement){
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
    public static void main(String[] paramArrayOfString) {
        LinkedList localLinkedList = new LinkedList();
        localLinkedList.add("uno");
        localLinkedList.add("hola");
        localLinkedList.add("uno");
        localLinkedList.add("coca");
        localLinkedList.add("cola");
        localLinkedList.add("light");
        localLinkedList.add("ola");
        localLinkedList.add("light");
        localLinkedList.add("light");
        //localLinkedList.add("light");
        //List a = localLinkedList;
        //Collections.sort(a);
        /*for (Object ab: a
             ) {
            System.out.println(ab);
        }*/
        int i = 1;
        while(i > 0){
            deleteElementsBySize(localLinkedList,findMax(localLinkedList));
            i--;
        }
        System.out.println();
        for (Object ab: localLinkedList
             ) {
            System.out.println(ab);
        }
    }
}
