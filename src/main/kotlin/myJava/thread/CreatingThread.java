package myJava.thread;

public class CreatingThread {
    public static void main(String[] args) {
        System.out.println("Starting Thread by Extending Thread Class:");
        MyThread thread = new MyThread();
        thread.start();
        System.out.println("Starting Thread using Runnable Interface:");
        MyImplementedThread runnable = new MyImplementedThread();
        Thread t = new Thread(runnable);
        t.start();
        System.out.println("If we will call run method, it will run like a normal method call:");
        runnable.run();
    }
}

/**
 * This class demonstrates creating a thread by extending the Thread class.
 */
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread: " + i);
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

/**
 * This class demonstrates creating a thread by implementing the Runnable interface.
 */
class MyImplementedThread implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Runnable Thread: " + i);
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}