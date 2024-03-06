public class MyQueue {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(Object value) {
        Node newNode = new Node(value);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek() {
        if (head == null) return null;
        return head.data;
    }

    public Object poll() {
        if (head == null) return null;
        Object data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return data;
    }
}

