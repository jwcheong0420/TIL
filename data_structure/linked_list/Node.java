package data_structure.linked_list;

public class Node {
    private Object data;
    public Node next;

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}