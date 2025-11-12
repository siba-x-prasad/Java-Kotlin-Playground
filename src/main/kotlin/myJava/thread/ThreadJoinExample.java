package myJava.thread;


/**
 * Join():
 * If a Thread wants to wait until completing some other Thread then we should go for join() method.
 * Example: If a Thread t1 executes t2.join() then t1 should go for waiting state until completing t2.
 * After completing t2, t1 will get chance for execution.
 *
 */
public class ThreadJoinExample {
    public static void main(String[] args) throws InterruptedException {
        MyJoinThread t1 = new MyJoinThread("Thread-1");
        MyJoinThread t2 = new MyJoinThread("Thread-2");
//        t1.setThread(t2);
//        t2.setThread(t1);

        t1.start();
        t2.start();

        // Wait for t1 to finish before continuing
        t1.join();

        System.out.println("t1 has finished. Main thread resumes...");

        // Wait for t2 as well
        t2.join();
        System.out.println("t2 has finished. Main thread ends.");
    }
}

class MyJoinThread extends Thread {
    private String name;
    private MyJoinThread thread;

    public void setThread(MyJoinThread thread) {
        this.thread = thread;
    }

    MyJoinThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " - " + i);
            if (i == 3) {
                /*try {
                    System.out.println( thread.name+" joined, "+ name+" is waiting for "+ thread.name+" to finish.");
                    thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }*/
            }
            try {
                Thread.sleep(500); // simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
