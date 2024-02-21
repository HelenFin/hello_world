import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {

    public static void main(String[] args){
        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(2);
        myQueue.add(5);
        myQueue.add(7);
        myQueue.add(8);
        myQueue.add(9);
        System.out.println(myQueue);

        Queue<String> myStringQueue = new LinkedList<>();
        myStringQueue.offer("Hello");
        myStringQueue.offer("my");
        myStringQueue.offer("World");
        System.out.println(myStringQueue);

        int positionOne = myQueue.poll();
        System.out.println("Removed element with poll() in Queue is the first element " + positionOne);

        int positionTwo = myQueue.remove();
        System.out.println("Removed element in Queue is the first element " + positionTwo);

        String firstElement = myStringQueue.element();
        System.out.println("The first element with element() is " + firstElement);

        String anotherFirstElement = myStringQueue.peek();
        System.out.println("The first element with peek() is " + anotherFirstElement);

        Iterator<Integer> iterator = myQueue.iterator();
        while (iterator.hasNext()){
            Integer iteratedQueue = iterator.next();
            System.out.println(iteratedQueue);
        }

    }


}
