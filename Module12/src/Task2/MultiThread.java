package Task2;

import java.util.LinkedList;
import java.util.Queue;

public class MultiThread {
    private int n;
    private int current = 1;
    private Queue<String> queue = new LinkedList<>();

    public MultiThread(int n) {
        this.n = n;
    }

    public synchronized void fizz() throws InterruptedException {
        while (current <= n) {
            if (current % 3 == 0 && current % 5 != 0) {
                queue.add("fizz");
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void buzz() throws InterruptedException {
        while (current <= n) {
            if (current % 5 == 0 && current % 3 != 0) {
                queue.add("buzz");
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void fizzbuzz() throws InterruptedException {
        while (current <= n) {
            if (current % 3 == 0 && current % 5 == 0) {
                queue.add("fizzbuzz");
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void number() throws InterruptedException {
        while (current <= n) {
            if (current % 3 != 0 && current % 5 != 0) {
                queue.add(Integer.toString(current));
                current++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public void printQueue() {
        while (!queue.isEmpty()) {
            System.out.print(queue.poll());
            if (!queue.isEmpty()) {
                System.out.print(", ");
            }
        }
    }

    public static void main(String[] args) {
        MultiThread fizzBuzz = new MultiThread(15);

        Thread a = new Thread(() -> {
            try {
                fizzBuzz.fizz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread b = new Thread(() -> {
            try {
                fizzBuzz.buzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread c = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread d = new Thread(() -> {
            try {
                fizzBuzz.number();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        a.start();
        b.start();
        c.start();
        d.start();

        try {
            a.join();
            b.join();
            c.join();
            d.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fizzBuzz.printQueue();
    }
}
    
