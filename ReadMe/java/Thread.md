# Thread
# Java Multithreading Interview Questions & Answers
## 1. What is a thread in Java?

**Answer:**  
A thread is a lightweight subprocess and the smallest unit of execution in Java. Threads share the same memory space but execute independently.

**Example:**
```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
```

2. Difference between Thread and Runnable?
   Thread	Runnable
   Extends Thread class	Implements Runnable interface
   Cannot extend another class	Can extend another class
   Creates a thread by calling start()	Pass to Thread constructor and call start()
3. How to create a thread in Java?
   - By extending the Thread class
   - By implementing the Runnable interface
4. What is the lifecycle of a thread?
   - New
   - Runnable
   - Running
   - Blocked/Waiting
   - Terminated
5. How to stop a thread safely in Java?
- Use a volatile flag or Thread.interrupt() instead of deprecated Thread.stop().
- Example with flag:
```
   class MyThread extends Thread {
       private volatile boolean running = true;
       public void run() {
           while(running) {
                System.out.println("Thread running");
           }
       }
       public void stopThread() {
            running = false;
       }
   }
  ```
6. What is Thread.yield()?
- Thread.yield() hints the scheduler that the current thread is willing to pause and allow other threads of equal priority to run. It's a hint, not a guarantee.
```
for (int i = 0; i < 5; i++) {
System.out.println(Thread.currentThread().getName() + " - " + i);
Thread.yield();
}
```

7. What is Thread.join()?
- join() allows one thread to wait for another thread to finish.
```   Example:
   ```Thread t1 = new Thread(() -> System.out.println("Running t1"));
   t1.start();
   t1.join(); // main thread waits
   System.out.println("t1 finished, main continues");
```
8. Difference between wait(), notify(), and notifyAll()?
-   wait()	Releases the lock and waits for notification
-   notify()	Wakes up one waiting thread
-   notifyAll()	Wakes up all waiting threads
- Example:
```
synchronized(obj) {
   obj.wait();
   obj.notify();
   obj.notifyAll();
   }
```
9. What is a synchronized block/method?
- synchronized ensures mutual exclusion, only one thread can access the block or method at a time.
- Example (method):
```
public synchronized void increment() {
   count++;
   }
   Example (block):
   synchronized(this) {
   count++;
   }
```
10. Difference between process and thread?
```
       Process	Thread
       Heavyweight	Lightweight
       Own memory space	Shared memory with other threads
       Communication via IPC	Communication via shared memory
       Slower to create	Faster to create
```       
11. What is a daemon thread?
- A daemon thread is a background thread that does not prevent JVM from exiting. Common example: Garbage Collector.
```
   Thread t = new Thread(() -> System.out.println("Daemon thread"));
   t.setDaemon(true);
   t.start();
```   
12. What is ThreadPoolExecutor and why use it?
 - Manages a pool of threads to reuse threads instead of creating new ones repeatedly.
 - Reduces overhead and improves performance.
```
    ExecutorService executor = Executors.newFixedThreadPool(3);
    executor.submit(() -> System.out.println("Task running"));
    executor.shutdown();
```    
13. Difference between Callable and Runnable?
```
    Runnable	Callable
    run() method	call() method
    Returns void	Returns a value
    Cannot throw checked exceptions	Can throw checked exceptions
```    
12. What is a deadlock? How to prevent it?
- Deadlock occurs when two or more threads wait indefinitely for each other’s locks.
- Prevention: Avoid nested locks
- Use tryLock() with timeout Lock ordering
13. Difference between synchronized and Lock?
    Synchronized	Lock (ReentrantLock)
    Built-in monitor	Explicit lock
    Simpler	More flexible (tryLock, timed lock, interruptible lock)
    Automatic release	Must unlock manually
14. What are volatile variables?
- Guarantees visibility of changes across threads.
- Ensures that threads read the latest value of the variable.
- private volatile boolean running = true;
15. Explain CyclicBarrier and CountDownLatch
    CountDownLatch: Waits for N threads to finish before continuing.
    CyclicBarrier: Threads wait for each other to reach a common barrier point, can be reused.