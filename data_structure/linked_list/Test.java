package data_structure.linked_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // LinkedList linkedList = new LinkedList();
        // System.out.println(linkedList);

        // linkedList.addFirst(10);
        // System.out.println(linkedList);
        // linkedList.addFirst(20);
        // System.out.println(linkedList);

        // linkedList.addLast(30);
        // System.out.println(linkedList);
        // linkedList.addLast(50);
        // System.out.println(linkedList);

        // linkedList.add(40, 1);
        // System.out.println(linkedList);

        // System.out.println("get first data : " + linkedList.get(0));
        // System.out.println("get last data : " + linkedList.getLast());

        // System.out.println("remove first data : " + linkedList.removeFirst());
        // System.out.println(linkedList);
        // System.out.println("remove last data : " + linkedList.removeLast());
        // System.out.println(linkedList);
        // System.out.println("remove 2nd data : " + linkedList.remove(1));
        // System.out.println(linkedList);

        // System.out.println("get index of 30 : " + linkedList.indexOf(30));

        // ListIterator listIterator = linkedList.listIterator();
        // while (listIterator.hasNext()) {
        //     System.out.println(listIterator.next());
        // }

        List<String> tmp = new ArrayList<>();
        tmp.add("hello");
        tmp.add("hi");
        Iterator<String> it = tmp.iterator();
        it.remove();
        System.out.println(tmp.toString());
        System.out.println("next : " + it.next());
        it.remove();
        System.out.println(tmp.toString());
    }
}