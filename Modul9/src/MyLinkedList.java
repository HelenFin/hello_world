public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Object data;
        Node next;
        Node prev;

        Node(Node prev, Object data, Node next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public MyLinkedList() {
        size = 0;
    }

    public void add(Object value) {
        Node l = tail;
        Node newNode = new Node(l, value, null);
        tail = newNode;
        if (l == null)
            head = newNode;
        else
            l.next = newNode;
        size++;
    }

    public void remove(int index) {
        Node x = getNode(index);
        Node next = x.next;
        Node prev = x.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.data = null;
        size--;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);

        Node x;
        if (index < (size >> 1)) {
            x = head;
            for (int i = 0; i < index; i++)
                x = x.next;
        } else {
            x = tail;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
        }
        return x;
    }

    public void clear() {
        for (Node x = head; x != null; ) {
            Node next = x.next;
            x.data = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        return getNode(index).data;
    }
}
