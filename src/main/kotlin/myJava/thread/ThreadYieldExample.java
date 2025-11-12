package myJava.thread;

// This class is a placeholder for future implementations of thread methods that prevent execution.

/**
 * yield(), join(), sleep() and other thread methods that can affect thread execution can be demonstrated here in the future.
 * yield() -
 * yield() method causes "to pause current executing Thread for giving the chance of remaining waiting Threads of same priority"
 * If all waiting Threads have the low priority or if there is no waiting Threads then the same Thread will be continued its execution.
 * The Thread which is yielded when it get chance once again for execution is depends on mercy of the Thread scheduler.
 *

 * sleep() - Causes the currently executing thread to sleep for a specified number of milliseconds.
 */

class MyYieldThread extends Thread {
    private String name;

    MyYieldThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " - " + i);

            // Yield control to other threads
            if (i == 3) {
                System.out.println(name + " is yielding...");
                Thread.yield();
            }
        }
    }
}

public class ThreadYieldExample {
    public static void main(String[] args) {
        Thread t1 = new MyYieldThread("Thread-1");
        Thread t2 = new MyYieldThread("Thread-2");

        t1.start();
        t2.start();
    }
}
