public class MyLinkedList{
    static class Node {

        int data;
        Node previous;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

        Node head = null;
        Node tail = null;

        public void insert(int data){
            Node newNode = new Node(data);

            if(head == null){
                head = newNode;
                tail = newNode;
                head.previous = null;
                tail.next = null;
            }
            else{
                tail.next = newNode;
                newNode.previous = tail;
                tail = newNode;
                tail.next = null;
            }
        }

        public void displayList(){
            Node current = head;
            if(head == null){
                System.out.println("The given list is empty");
            }
            else{
                System.out.println("The data in the doubly linked list: ");
                while (current != null){
                    System.out.print(current.data + " ");
                    current = current.next;
                }
            }
        }


    public static void main(String[] args){
        MyLinkedList newList = new MyLinkedList();
        newList.insert(10);
        newList.insert(50);
        newList.insert(70);
        newList.insert(80);
        newList.insert(60);
        newList.displayList();
    }

}
