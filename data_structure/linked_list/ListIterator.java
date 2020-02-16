package data_structure.linked_list;

public class ListIterator {
    private Node nextNode;
    private Node lastReturned;
    private int index;

    public ListIterator(Node head) {
        this.nextNode = head;
        this.lastReturned = null;
        this.index = 0;
    }

    public boolean hasNext() {
        return nextNode != null;
    }

    public Object next() {
        lastReturned = nextNode;
        nextNode = nextNode.next;
        index++;
        return lastReturned.getData();
    }

    public void remove() {
    }
}