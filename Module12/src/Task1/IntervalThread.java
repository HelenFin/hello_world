package Task1;

public class IntervalThread {

    public static void main(String[] args) {
        new Thread(() -> {
            long startTime = System.currentTimeMillis();
            while (true) {
                long timeAfterBeginning = (System.currentTimeMillis() - startTime) / 1000;
                System.out.println(timeAfterBeginning + " seconds are gone");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("The thread is interrupted");
                    break;
                }
            }
        }).start();

        new Thread(() -> {
            try {
                while (true) {
                    Thread.sleep(5000);
                    System.out.println("5 seconds are gone in " +
                            "second Thread");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("The thread is interrupted");
            }
        }).start();

    }
}



