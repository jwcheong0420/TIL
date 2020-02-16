package data_structure.linked_list;

import data_structure.linked_list.LinkedList.ListIterator;

public class Test {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        System.out.println(linkedList);

        linkedList.addFirst(10);
        System.out.println(linkedList);
        linkedList.addFirst(20);
        System.out.println(linkedList);

        linkedList.addLast(30);
        System.out.println(linkedList);
        linkedList.addLast(50);
        System.out.println(linkedList);

        linkedList.add(40, 1);
        System.out.println(linkedList);

        System.out.println("get first data : " + linkedList.get(0));
        System.out.println("get last data : " + linkedList.getLast());

        System.out.println("remove first data : " + linkedList.removeFirst());
        System.out.println(linkedList);
        System.out.println("remove last data : " + linkedList.removeLast());
        System.out.println(linkedList);
        System.out.println("remove 2nd data : " + linkedList.remove(1));
        System.out.println(linkedList);

        System.out.println("get index of 30 : " + linkedList.indexOf(30));

        ListIterator listIterator = linkedList.listIterator();
        // listIterator.remove();  // cannot call remove() before call next()
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
            listIterator.remove();
            System.out.println("after removed element by iterator : " + linkedList);
        }
    }
}