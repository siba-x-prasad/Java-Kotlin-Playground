package myJava.thread;

public class ThreadByUsingThreadClass {

    public static void main(String[] args) {
        MyThread1 thread1 = new  MyThread1();
        thread1.start();
        MyThread2 thread2 = new  MyThread2();
        thread2.start();
    }

}


class MyThread1 extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("Inside MyThread1");
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("Inside MyThread2");
    }
}
