package myJava.thread;

/**
 * Two Threads can communicate with each other by using wait(), notify() and notifyAll() methods.
 *  The Thread which is required updation it has to call wait() method on the
 * required object then immediately the Thread will entered into waiting state.
 * The Thread which is performing updation of object, it is responsible to give notification by calling notify() method.
 * After getting notification the waiting Thread will get those updations.
 *
 * wait()	Causes the current thread to release the lock and wait until another thread calls notify() or notifyAll() on the same object. Must be called inside a synchronized block.
 * notify()	Wakes up one thread that is waiting on the object’s monitor.
 * notifyAll()	Wakes up all threads waiting on the object’s monitor.
 */

import java.util.LinkedList;
import java.util.Queue;

class SharedQueue {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int LIMIT = 5;

    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == LIMIT) {
            wait(); // wait until space is available
        }
        queue.add(value);
        System.out.println("Produced: " + value);
        notify(); // wake up consumer
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // wait until an item is available
        }
        int value = queue.poll();
        System.out.println("Consumed: " + value);
        notify(); // wake up producer
        return value;
    }
}

class Producer extends Thread {
    private final SharedQueue queue;

    public Producer(SharedQueue queue) {
        this.queue = queue;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                queue.produce(i);
                Thread.sleep(200); // simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    private final SharedQueue queue;

    public Consumer(SharedQueue queue) {
        this.queue = queue;
    }

    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                queue.consume();
                Thread.sleep(500); // simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class InterThreadCommunication {
    public static void main(String[] args) {
        SharedQueue queue = new SharedQueue();
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        producer.start();
        consumer.start();
    }
}

