package myJava.thread;

public class ThreadMethods {
    public static void main(String[] args) {
        Thread.currentThread().getPriority(); // it will be 5 by default
        // 1-10 (1-Minimum Priority, 10-Maximum Priority, 5-Normal Priority)
        Thread.currentThread().setPriority(7);
        System.out.println("Current Thread Name: " + Thread.currentThread().getName());
        System.out.println("Current Thread Priority: " + Thread.currentThread().getPriority());

        MyThreadMethods myThreadMethods = new MyThreadMethods();
        Thread thread = new Thread(myThreadMethods);
        thread.setName("My Custom Thread");
        thread.setPriority(9);
        thread.start();
    }
}


// You can add methods demonstrating various thread methods here in the future
class MyThreadMethods implements Runnable {
    @Override
    public void run() {
        // Implementation of thread methods can be added here
        for (int i = 1; i <= 5; i++) {
            System.out.println("MyThreadMethods is running: " + i);
            System.out.println("Thread is running with name: " + Thread.currentThread().getName());
            try {
                Thread.sleep(300); // Sleep for 300 milliseconds
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

    }
}