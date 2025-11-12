# Java Interview Questions
## 🧠 Section 1 – Core Java & OOP (10 minutes)
1). What’s the difference between == and .equals() in Java? When should you override .equals() and .hashCode()?
- == is used for reference comparison, checking if two references point to the same object in memory.
- .equals() is used for value comparison, checking if two objects are logically equivalent.
- You should override .equals() and .hashCode() when you want to define a custom equality logic for your objects, especially when they are used in collections like HashMap or HashSet.
2). Explain immutability in Java. How would you create a truly immutable class?
- Immutability means that once an object is created, its state cannot be changed. To create a truly immutable class:
  - Declare the class as final to prevent subclassing.
  - Make all fields private and final.
  - Do not provide setter methods.
  - Ensure that any mutable objects passed to the constructor are cloned or copied.
  - Provide only getter methods that return copies of mutable objects.
3). Can you describe the class loading process in Java?
- The class loading process in Java involves three main steps:
  - Loading: The class loader reads the .class file and loads it into memory.
  - Linking: This step involves verification (checking the bytecode), preparation (allocating memory for static variables), and resolution (resolving symbolic references).
  - Initialization: The class is initialized by executing static initializers and static blocks.
4). What is the difference between composition and inheritance? Which do you prefer and why?
- Inheritance is a "is-a" relationship where a subclass inherits properties and behaviors from a superclass. 
- Composition is a "has-a" relationship where a class contains references to other classes as its members.
- Preference depends on the use case, but composition is often preferred for its flexibility and ability to promote code reuse without the tight coupling that inheritance can introduce.
- Is-a example: Dog is a Animal (Inheritance)

```
// Superclass (Parent Class)
class Animal {
    public void walk() {
        System.out.println("Animal is walking");
    }
}

// Subclass (Child Class) - uses "extends"
class Dog extends Animal {
    public void bark() {
        System.out.println("Woof!");
    }
}

// Main class to run the example
public class InheritanceDemo {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.walk();  // Accessing inherited method
        myDog.bark();  // Accessing Dog's own method
    }
}
```
- Has-a example: Car has an Engine (Composition)
```
// Define an interface for flexibility
interface VehicleEngine {
    void start();
}

class PetrolEngine implements VehicleEngine {
    @Override
    public void start() {
        System.out.println("Starting petrol engine...");
    }
}

class ElectricEngine implements VehicleEngine {
    @Override
    public void start() {
        System.out.println("Starting electric engine...");
    }
}

class FlexibleCar {
    // Depend on the interface, not a concrete implementation
    private VehicleEngine engine; 

    public FlexibleCar(VehicleEngine engine) {
        this.engine = engine;
    }
    
    // Method to change the engine dynamically
    public void setEngine(VehicleEngine engine) {
        this.engine = engine;
    }

    public void startCar() {
        this.engine.start();
    }
}

public class FlexibleCompositionDemo {
    public static void main(String[] args) {
        // Create a car with a petrol engine
        FlexibleCar car = new FlexibleCar(new PetrolEngine());
        car.startCar(); 

        // Change the engine to electric at runtime
        car.setEngine(new ElectricEngine());
        car.startCar(); 
    }
}
```
5). What is the difference between final, finally, and finalize()?
- final: A keyword used to declare constants, prevent method overriding, and prevent inheritance of classes.
- finally: A block used in exception handling to execute code regardless of whether an exception occurred or not.
- finalize(): A method in the Object class that is called by the garbage collector before an object is destroyed. It is used for cleanup operations but is deprecated in recent Java versions due to unpredictability.
## ⚙️ Section 2 – Multithreading & Concurrency (10 minutes)
6). How does the synchronized keyword work internally in Java?
- The synchronized keyword in Java is used to control access to a block of code or method by multiple threads. 
- When a thread enters a synchronized block or method, it acquires a lock (monitor) on the specified object or class. 
- Other threads attempting to enter the same synchronized block or method must wait until the lock is released.
- Internally, Java uses monitors to implement synchronization. 
- Each object has an associated monitor that tracks which thread holds the lock. 
- When a thread exits the synchronized block or method, it releases the lock, allowing other waiting threads to acquire it.
7). What are the key differences between wait(), notify(), and notifyAll()?
- wait(): Releases the lock and waits for notification.
- notify(): Wakes up one waiting thread.
- notifyAll(): Wakes up all waiting threads.
8). What are volatile variables? When do you use them?
- Volatile variables are variables that are declared with the volatile keyword. They ensure visibility of changes to variables across threads. When a variable is declared as volatile, reads and writes to that variable are directly done to and from the main memory, ensuring that all threads see the most up-to-date value.
- Use volatile when you have a variable that is accessed by multiple threads and you want to ensure visibility without using synchronized blocks, especially for flags or state indicators.
9). What’s the difference between Thread and Runnable?
- Thread is a class that represents a thread of execution in Java. It can be instantiated and started directly.
- Runnable is an interface that defines a single method, run(), which contains the code to be executed by a thread. Runnable is implemented by classes whose instances are intended to be executed by a thread.
- Using Runnable allows for better separation of task definition and thread management, and it enables the use
10). How do you handle thread synchronization in Java without using synchronized?
- You can handle thread synchronization in Java without using synchronized by using:
- Locks from the java.util.concurrent.locks package, such as ReentrantLock, which provide more advanced synchronization capabilities.
- Atomic variables from the java.util.concurrent.atomic package, such as AtomicInteger, which provide lock-free thread-safe operations on single variables.
- Concurrent collections from the java.util.concurrent package, such as ConcurrentHashMap, which are designed for concurrent access without explicit synchronization.
- Using higher-level concurrency constructs like CountDownLatch, Semaphore, or CyclicBarrier to manage thread coordination.
## 📦 Section 3 – Collections & Generics (10 minutes)
11). How does a HashMap work internally? What happens if two keys have the same hash code?
- A HashMap works by using a hash function to compute an index (bucket) in an array where the key-value pair will be stored. 
- When a key-value pair is added, the hash code of the key is calculated, and the corresponding bucket is determined. 
- If two keys have the same hash code (collision), they are stored in the same bucket using a linked list or a balanced tree (in case of many collisions) to store multiple entries.
- When retrieving a value, the hash code is computed again to find the bucket, and then the linked list or tree is traversed to find the exact key.
12). What are ConcurrentHashMap and its advantages over a synchronized HashMap?
- ConcurrentHashMap is a thread-safe variant of HashMap that allows concurrent access by multiple threads without locking the entire map.
- It achieves this by dividing the map into segments, allowing multiple threads to read and write to different segments simultaneously.
- Advantages over synchronized HashMap:
  - Higher concurrency: Multiple threads can operate on different segments without blocking each other.
  - Better performance: Reduced contention and improved throughput in multi-threaded environments.
  - Non-blocking reads: Read operations do not require locking, allowing for faster access.
13). What’s the difference between fail-fast and fail-safe iterators?
- Fail-fast iterators throw a ConcurrentModificationException if the underlying collection is modified while iterating. Examples include iterators from ArrayList and HashMap.
- Fail-safe iterators do not throw exceptions when the collection is modified during iteration. They work on a copy of the collection, allowing safe iteration. Examples include iterators from CopyOnWriteArrayList and ConcurrentHashMap.
14). Can you explain Generics type erasure?
- Generics type erasure is a process by which the Java compiler removes all generic type information during compilation.
- This means that generic types are replaced with their upper bound (usually Object) or the first bound specified.
- Type erasure allows for backward compatibility with older versions of Java that do not support generics, but it also means that generic type information is not available at runtime.
15). How would you sort a list of custom objects using Java Streams?
- You can sort a list of custom objects using Java Streams by using the sorted() method along with a Comparator. Here’s an example:
```

List<Person> people = Arrays.asList(
    new Person("Alice", 30),
    new Person("Bob", 25),
    new Person("Charlie", 35)
);


List<Person> sortedPeople = people.stream()
    .sorted(Comparator.comparingInt(Person::getAge))
    .collect(Collectors.toList());
```
## 🧩 Section 4 – Java 8–21 Features (10 minutes)
16). What are Streams in Java 8, and how do they differ from collections?
- Streams provide a functional approach to processing sequences of elements, allowing for operations like map, filter, and reduce. 
- They are lazy, meaning operations are not executed until a terminal operation is invoked, and they can be parallelized easily.
- Collections are data structures that store elements and provide methods for adding, removing, and accessing them
17). What are default and static methods in interfaces?
- Default methods are methods in interfaces that have a default implementation. 
- They allow adding new methods to interfaces without breaking existing implementations.
- Static methods in interfaces are methods that belong to the interface itself and can be called without an instance of the interface.
18). Explain records, sealed classes, and pattern matching (Java 16–21 features).
- **Records:** Introduced in Java 16, records are a special kind of class that is concise and immutable by default. 
- They are used to model data as simple data carriers with automatically generated methods like equals(), hashCode(), and toString().
- **Sealed Classes:** Introduced in Java 17, sealed classes restrict which other classes can extend or implement them. 
- This allows for more controlled inheritance hierarchies.
- **Pattern Matching:** Introduced in Java 16 and enhanced in later versions, pattern matching simplifies type checks and casts. 
- It allows you to match an object against a pattern and extract its components in a more concise way.
19). What are Virtual Threads (JEP 444)? How can they improve performance?
- Virtual Threads, introduced in Java 19 as a preview feature, are lightweight threads that are managed by the Java Virtual Machine (JVM) rather than the operating system.
- They allow for a large number of concurrent threads with minimal overhead, improving scalability and performance for I/O-bound applications.
- Virtual Threads can help reduce context-switching costs and improve resource utilization, making it easier to write concurrent applications.
20). Can you show an example of switch expression and text block?
- Switch Expression:
```
int day = 3;
String type = switch (day) {
    case 1, 7 -> "Weekend";
    default -> "Weekday";
};
```
## ☕ Section 5 – Spring Boot / Microservices (15 minutes)
21). How does Spring Boot auto-configuration work internally?
- Spring Boot auto-configuration works by using the @EnableAutoConfiguration annotation, which triggers the auto-configuration mechanism.
- It scans the classpath for specific libraries and configurations, and based on the presence of certain classes and beans, it automatically configures Spring beans and settings.
- Auto-configuration classes are defined in the spring-boot-autoconfigure module and are conditionally applied using @Conditional annotations.
22). Explain the difference between @Component, @Service, @Repository, and @Controller, @RestController.
- **@Component:** A generic stereotype for any Spring-managed component. 
- It is the base annotation for all other stereotypes.
- **@Service:** A specialization of @Component, used to indicate that a class is a service layer component. 
- It is typically used for business logic.
- **@Repository:** A specialization of @Component, used to indicate that a class is a data access layer component. 
- It provides additional functionality for exception translation.
- **@Controller:** A specialization of @Component, used to indicate that a class is a web controller in the MVC pattern. 
- It handles HTTP requests and returns views or data.
- **@RestController:** A combination of @Controller and @ResponseBody, used to create RESTful web services. 
- It automatically serializes return values to JSON or XML.
23). What are Spring Profiles and how are they used for environment management?
- Spring Profiles allow you to define different configurations for different environments (e.g., development, testing, production).
- You can annotate beans or configuration classes with @Profile to specify which profile they belong to.
- Profiles can be activated using application properties, command-line arguments, or environment variables, enabling you
24). How would you handle pagination and filtering in a REST API using Spring Data JPA?
- You can handle pagination and filtering in a REST API using Spring Data JPA by leveraging the Pageable interface and Query methods.
- For pagination, you can define a method in your repository that accepts a Pageable parameter, which allows you to specify page number, size, and sorting.
- For filtering, you can create custom query methods in your repository that accept filter criteria as parameters.
- In your controller, you can use these repository methods to return paginated and filtered results to the client.
25). What strategies do you use to make your Spring Boot microservices fault tolerant?
- Implementing Circuit Breaker patterns using libraries like Resilience4j or Hystrix to prevent cascading failures.
- Using retries with exponential backoff for transient failures.
- Implementing bulkheads to isolate different parts of the system.
- Using fallback methods to provide default responses when a service is unavailable.
- Monitoring and alerting to detect and respond to failures quickly.
26). What is Circuit Breaker pattern and how is it implemented (Resilience4j / Hystrix)?
- The Circuit Breaker pattern is a design pattern used to detect failures and encapsulate the logic of preventing a failure from constantly recurring during maintenance, temporary external system failure, or unexpected system difficulties.
- It works by wrapping a function call in a circuit breaker object, which monitors for failures.
- When the failure threshold is reached, the circuit breaker trips, and subsequent calls to the function return a default response or throw an exception without executing the function.
- Implementation can be done using libraries like Resilience4j or Hystrix, which provide annotations and configurations to easily apply the circuit breaker
27). How do you implement asynchronous processing in Spring Boot?
- You can implement asynchronous processing in Spring Boot by using the @Async annotation on methods that you want to execute asynchronously.
- You need to enable asynchronous processing by adding the @EnableAsync annotation to a configuration class.
- The method annotated with @Async will run in a separate thread, allowing the caller to continue without waiting for the method to complete.
- You can also configure a custom Executor to manage the thread pool for asynchronous tasks.
28). How do you handle API versioning in microservices?
- API versioning in microservices can be handled using several strategies:
  - URI Versioning: Including the version number in the URL path (e.g., /api/v1/resource).
  - Request Parameter Versioning: Using a query parameter to specify the version (e.g., /api/resource?version=1).
  - Header Versioning: Using custom headers to indicate the version (e.g., X-API-Version: 1).
  - Content Negotiation: Using the Accept header to specify the version (e.g., application/vnd.myapi.v1+json).
- The choice of strategy depends on the specific requirements and preferences of the development team.
## 🧮 Section 6 – Performance, Memory & Best Practices (10 minutes)
29). How do you find and fix a memory leak in a Java application?
- To find and fix a memory leak in a Java application, you can follow these steps:
  - Use profiling tools like VisualVM, YourKit, or Eclipse MAT to monitor memory usage and identify objects that are not being garbage collected.
  - Analyze heap dumps to identify objects that are retaining references and preventing garbage collection.
  - Look for common causes of memory leaks, such as static collections, unclosed resources, or listeners that are not removed.
  - Refactor the code to eliminate unnecessary references and ensure proper resource management (e.g., closing streams, removing listeners).
  - Test the application again to verify that the memory leak has been resolved.
30). What’s the difference between Heap, Stack, and Metaspace memory?
- Heap: The heap is the runtime data area where Java objects are allocated. It is shared among all threads and is managed by the garbage collector.
- Stack: The stack is a memory area that stores method call frames, local variables, and method parameters. Each thread has its own stack, and it operates in a last-in-first-out (LIFO) manner.
- Metaspace: Metaspace is the memory area that stores class metadata. It replaced the PermGen space in Java 8 and is allocated from native memory, allowing for dynamic resizing.
31). What tools do you use for profiling and GC analysis?
- Common tools for profiling and GC analysis include:
  - VisualVM: A visual tool for monitoring and profiling Java applications.
  - YourKit: A commercial Java profiler with advanced features for memory and CPU profiling.
  - Eclipse Memory Analyzer (MAT): A powerful tool for analyzing heap dumps and identifying memory leaks.
  - JConsole: A monitoring tool that comes with the JDK for monitoring JVM performance and memory usage.
  - Java Flight Recorder (JFR): A profiling tool built into the JDK for low-overhead performance monitoring.
32). How do you tune JVM parameters for a high-performance Spring Boot application?
- To tune JVM parameters for a high-performance Spring Boot application, you can consider the following:
  - Set the initial and maximum heap size using -Xms and -Xmx parameters based on the application's memory requirements.
  - Use the G1 Garbage Collector (-XX:+UseG1GC) for low-latency applications.
  - Configure garbage collection logging (-Xlog:gc*) to monitor GC behavior and identify performance bottlenecks.
  - Adjust thread stack size (-Xss) if necessary, especially for applications with many threads.
  - Enable class data sharing (-Xshare:class) to reduce startup time and memory footprint.
  - Monitor and analyze application performance regularly to fine-tune JVM settings as needed.
33). What is the difference between WeakReference, SoftReference, and PhantomReference?
- WeakReference: Objects referenced by WeakReference can be garbage collected when there are no strong references to them. They are typically used for caches where you want to allow the garbage collector to reclaim memory when needed.
- SoftReference: Objects referenced by SoftReference are less likely to be garbage collected than those referenced by WeakReference. They are used for memory-sensitive caches, where the garbage collector will only reclaim them when memory is low.
- PhantomReference: Objects referenced by PhantomReference are not accessible and are used to determine when an object has been finalized and is ready for garbage collection. They are typically used for cleanup operations after an object has been collected.
34). Describe a real-world performance optimization you implemented in production.
- In a previous project, we noticed that our Spring Boot application was experiencing high latency during peak traffic times. After profiling the application, we identified that database queries were a significant bottleneck.
- To optimize performance, we implemented the following changes:
  - Introduced caching using Redis to store frequently accessed data, reducing the number of database calls.
  - Optimized database queries by adding appropriate indexes and rewriting complex queries for better performance.
  - Implemented connection pooling to manage database connections more efficiently.
  - As a result, we saw a significant reduction in response times and improved overall application performance during peak loads.
## Java Memory Management
# ☕ Java Memory Management — Steps and Best Practices

Java uses **automatic memory management**, meaning developers don’t need to manually allocate or free memory.  
However, understanding and managing memory usage properly is critical for **performance**, **scalability**, and **stability**.

---

## 🧩 Table of Contents

1. [Understand Java Memory Structure](#1-understand-java-memory-structure)
2. [Object Creation and Lifetime](#2-object-creation-and-lifetime)
3. [Avoid Memory Leaks](#3-avoid-memory-leaks)
4. [Use Efficient Data Structures](#4-use-efficient-data-structures)
5. [Manage Large Objects Carefully](#5-manage-large-objects-carefully)
6. [Use Weak References Wisely](#6-use-weak-references-wisely)
7. [Tune the Garbage Collector](#7-tune-the-garbage-collector)
8. [Monitor and Profile Memory Usage](#8-monitor-and-profile-memory-usage)
9. [Finalize and Clean Up Resources](#9-finalize-and-clean-up-resources)
10. [Summary of Best Practices](#10-summary-of-best-practices)

---

## 1. 🧠 Understand Java Memory Structure

Java memory is divided mainly into two areas:

| Area                                  | Description                                                                    |
|---------------------------------------|--------------------------------------------------------------------------------|
| **Heap Memory**                       | Stores objects and their related data. Managed by the Garbage Collector (GC).  |
| **Stack Memory**                      | Stores method calls and local variables. Automatically managed via LIFO order. |
| **Metaspace (or PermGen pre-Java 8)** | Stores class metadata and method definitions.                                  |
| **Native Memory**                     | Used by JVM internals and native code (like JNI).                              |

**Action:**  
✅ Know what goes where — use the heap for objects, stack for method data.

---

## 2. 🧱 Object Creation and Lifetime

Every object you create consumes heap space.  
Excessive or unnecessary object creation can lead to **memory bloat**.

**Steps:**
- Reuse objects where possible (e.g., use `StringBuilder` instead of concatenation in loops).
- Avoid creating objects in frequently called methods unnecessarily.
- Use **immutable objects** wisely (they’re safe but can create many instances).

**Example:**
```
// Inefficient
for (int i = 0; i < 1000; i++) {
    String s = new String("Hello"); // Creates new object each time
}

// Efficient
String s = "Hello"; // Uses string pool
```
3. 🚫 Avoid Memory Leaks
- Memory leaks occur when objects are no longer needed but remain referenced, preventing GC from reclaiming them.
- Steps:
- Always close streams, sockets, and database connections.
- Remove listeners, observers, or callbacks when not needed.
- Be careful with static references — they live for the JVM lifetime.
- Avoid holding long-lived references in caches or collections.
- Example:
```
try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
   // Safe: reader auto-closed after block
   }
```   
4. 📊 Use Efficient Data Structures
- Choosing the right data structure can drastically affect memory usage.
- Steps:
- Use ArrayList instead of LinkedList for better memory locality.
- Use EnumSet instead of HashSet when storing enum constants.
- Set initial capacity for collections when size is known to reduce resizing.
- Example:
   ```Map<String, Integer> map = new HashMap<>(1000); // Avoids resizing overhead```
5. 🧩 Manage Large Objects Carefully
- Large objects (like images, large arrays, or collections) can quickly fill the heap.
- Steps:
- Nullify references once you’re done using them.
- Load large data lazily (on demand).
- Use streaming APIs instead of loading entire files into memory.
- Example:
   ```image = null; // Hint GC that image is no longer needed```
6. 🪶 Use Weak References Wisely
- Java provides reference types to help control how GC treats objects:
- Reference Type	Description
- StrongReference	Normal reference; object not eligible for GC
- SoftReference	    GC collects when memory is low
- WeakReference	    GC collects when no strong references exist
- PhantomReference	Used for advanced cleanup before object reclamation
- Use Case:
- Caches or temporary data storage can use WeakReference or SoftReference.
7. ⚙️ Tune the Garbage Collector
- Java provides various GC algorithms (G1, ZGC, Shenandoah, etc.).
- You can tune the GC to optimize performance.
- Steps:
- Use JVM options:
   - -Xms512m -Xmx2g     # Set min and max heap size
   - -XX:+UseG1GC        # Use G1 Garbage Collector
- Monitor GC pauses and memory usage via tools like JVisualVM, JConsole, or GC logs.
8. 📈 Monitor and Profile Memory Usage
- Regularly monitor memory usage to identify leaks or inefficiencies.
- Tools:
- 🧩 JVisualVM – Visualize heap and GC activity
- 🪟 Eclipse MAT (Memory Analyzer Tool) – Detect memory leaks
-  🔍 JConsole – Monitor JVM memory and thread usage
-  🧠 Flight Recorder & Mission Control – Advanced performance profiling (JDK built-in)
9. 🧹 Finalize and Clean Up Resources
- Garbage collection handles memory, but not system resources like files, sockets, or database connections.
- Steps:
- Implement AutoCloseable or use try-with-resources.
- Avoid overriding finalize() (deprecated) — use Cleaner or PhantomReference if needed.
- Example:
```
try (Connection conn = DriverManager.getConnection(url)) {
// Safe and clean
}
```
## How to Improve Performance in Java Applications
- 