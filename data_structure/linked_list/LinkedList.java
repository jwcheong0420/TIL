package data_structure.linked_list;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public class ListIterator {
        private Node nextNode;
        private int nextIndex;
        private Node lastReturned;

        public ListIterator() {
            this.nextNode = LinkedList.this.head;
            this.nextIndex = 0;
            this.lastReturned = null;
        }

        public boolean hasNext() {
            return nextNode != null;
        }

        public Object next() {
            lastReturned = nextNode;
            nextNode = nextNode.next;
            nextIndex++;
            return lastReturned.getData();
        }

        public void remove() {
            if (nextIndex <= 0) {
                throw new IllegalStateException();
            }
            LinkedList.this.remove(nextIndex - 1);
            nextIndex--; // index가 하나씩 앞으로 당겨진다
        }
    }

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    private Node node(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public void addFirst(Object input) {
        Node node = new Node(input);

        node.next = head;
        head = node;

        if (tail == null) {
            tail = node;
        }

        size++;
    }

    public void addLast(Object input) {
        if (size == 0) {
            addFirst(input);
        } else {
            Node node = new Node(input);

            tail.next = node;
            tail = node;

            size++;
        }
    }

    public void add(Object input, int index) {
        if (index == 0) {
            addFirst(input);
        } else {
            Node prev = node(index - 1);

            Node node = new Node(input);
            node.next = prev.next;
            prev.next = node;
            if (node.next == null) {
                tail = node;
            }
            size++;
        }
    }

    public Object get(int index) {
        Node node = node(index);
        return node.getData();
    }

    public Object getLast() {
        Node node = node(size - 1);
        return node.getData();
    }

    public Object removeFirst() {
        if (head == null) {
            return null;
        }

        Node tmp = head;
        Object removedData = tmp.getData();
        head = tmp.next;
        size--;

        if (tmp.next == null) {
            tail = tmp;
        }

        return removedData;
    }

    public Object removeLast() {
        if (head == null) {
            return null;
        } else if (head == tail) {
            return removeFirst();
        }

        Node last = node(size - 2);
        Object removedData = last.next.getData();
        last.next = null;
        tail = last;
        size--;
        return removedData;
    }

    public Object remove(int index) {
        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node prev = node(index - 1);
            Node tmp = prev.next;
            prev.next = tmp.next;
            size--;

            return tmp.getData();
        }
    }

    public int indexOf(Object input) {
        int index = 0;
        Node tmp = head;
        while (tmp.getData() != input) {
            index++;
            tmp = tmp.next;
            if (tmp == null) {
                return -1;
            }
        }

        return index;
    }

    public ListIterator listIterator() {
        return new ListIterator();
    }

    @Override
    public String toString() {
        if (head == null) {
            return "[]";
        }

        String str = "[";
        Node node = head;
        while (node.next != null) {
            str += node + ", ";
            node = node.next;
        }
        str += node + "]";

        return str;
    }
}