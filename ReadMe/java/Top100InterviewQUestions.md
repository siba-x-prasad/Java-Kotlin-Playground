# Top 100 Interview questions
## Core Java
- **What are the main features of Java?**
- **Explain Java’s memory management.**
- https://medium.com/@3eid/deep-dive-into-java-memory-management-heap-stack-metaspace-and-garbage-collection-df6548fe6860
- What is the difference between JDK, JRE, and JVM?
- **What are Java primitive data types?**
- **Explain Java’s object-oriented concepts.**
- **What is the difference between an interface and an abstract class?**
- **What is method overloading and overriding?**
- **Explain the difference between == and .equals().**
- **What is the difference between final, finally, and finalize?**
- **What is used instead of finalize now ?**
- java.lang.ref.Cleaner
- try-with-resources / AutoCloseable (Java 7+)
- **What are static blocks and static methods?**
- A static block is a block of code inside a class that is executed only once when the class is loaded into memory by the JVM. It is mainly used to initialize static variables or perform class-level setup.
- A static method belongs to the class rather than an instance. You can call it without creating an object of the class.
- **Explain the concept of constructor overloading.**
- **What is the difference between String, StringBuilder, and StringBuffer?**
- **What is the difference between shallow copy and deep copy?**
- A shallow copy of an object copies the values of the fields as they are.
- If the field is primitive, its value is copied.
- If the field is a reference to another object, the reference is copied, not the object itself.
- Implication: Changes made to the referenced objects in the copy affect the original object.
- A deep copy creates a completely independent object along with copies of all objects referenced by it.
- Changes in the copy do not affect the original object.

- **Explain the this and super keywords.**
- **What is a singleton class and how to implement it?**
- **What is the difference between == and equals()?**
- **What is immutability? How to make a class immutable?**
- **What are wrapper classes in Java?**
- **Explain autoboxing and unboxing.**
- Autoboxing is the automatic conversion of a primitive type into its corresponding wrapper class object by the Java compiler. 
- This happens implicitly, so you don’t need to manually create wrapper objects.
- Unboxing is the automatic conversion of a wrapper class object back into its corresponding primitive type by the Java compiler.
- **What are the different types of inner classes?**
- **What is the difference between abstract class and interface?**
- **How does Java achieve polymorphism?**
- **What is type casting in Java?**
- **Explain upcasting and down casting.**
- **What is the difference between transient, volatile, and synchronized keywords?**
## Collections Framework
- **What are the main interfaces of the Java Collections Framework?**
- **Explain the difference between List, Set, and Map.**
- **What is the difference between ArrayList and LinkedList?**
# Difference Between ArrayList and LinkedList in Java

## 1. Definition

| List Type      | Description                                                                                                                                               |
|----------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------|
| **ArrayList**  | A resizable array implementation of the `List` interface. Stores elements in a dynamic array.                                                             |
| **LinkedList** | A doubly linked list implementation of the `List` and `Deque` interfaces. Each element is a node containing data and pointers to previous and next nodes. |

---

## 2. Internal Data Structure

| Feature                       | ArrayList           | LinkedList                     |
|-------------------------------|---------------------|--------------------------------|
| **Underlying data structure** | Dynamic array       | Doubly linked list             |
| **Element storage**           | Contiguous memory   | Nodes connected by links       |
| **Access by index**           | Fast (O(1))         | Slow (O(n))                    |
| **Memory usage**              | Lower (just values) | Higher (stores extra pointers) |

---

## 3. Performance Comparison

| Operation                     | ArrayList                    | LinkedList                    |
|-------------------------------|------------------------------|-------------------------------|
| **Access (get/set)**          | ✅ O(1) — direct index access | ❌ O(n) — sequential traversal |
| **Insertion at end**          | ✅ O(1) (amortized)           | ✅ O(1)                        |
| **Insertion in middle/start** | ❌ O(n) — elements shifted    | ✅ O(1) — update node links    |
| **Deletion in middle/start**  | ❌ O(n) — elements shifted    | ✅ O(1) — unlink nodes         |
| **Iteration**                 | Fast (cache-friendly)        | Slower (not cache-friendly)   |

---

### 🧠 Summary
- **ArrayList** is better for **random access and iteration**.
- **LinkedList** is better for **frequent insertions and deletions**.

- **What is the difference between HashMap and Hashtable?**
- How does HashMap work internally?
- **What is the difference between HashMap and TreeMap?**
# Difference Between HashMap and TreeMap in Java

## 1. Definition

| Map Type    | Description                                                                                                                                |
|-------------|--------------------------------------------------------------------------------------------------------------------------------------------|
| **HashMap** | A hash-table-based implementation of the `Map` interface that stores key-value pairs with **no guaranteed order** of keys.                 |
| **TreeMap** | A Red-Black Tree-based implementation of the `NavigableMap` interface that stores key-value pairs in **sorted (ascending) order of keys**. |

---

## 2. Internal Data Structure

| Feature                       | HashMap                                          | TreeMap                                               |
|-------------------------------|--------------------------------------------------|-------------------------------------------------------|
| **Underlying data structure** | Hash table                                       | Red-Black Tree (self-balancing binary search tree)    |
| **Ordering of keys**          | No order (random)                                | Keys are sorted (natural or custom order)             |
| **Null keys/values**          | Allows **one null key** and multiple null values | Does **not allow null keys**, but allows null values  |
| **Key comparison**            | Uses `hashCode()` and `equals()`                 | Uses `compareTo()` (natural ordering) or `Comparator` |
| **Performance (average)**     | `O(1)` for `get()` and `put()`                   | `O(log n)` for `get()` and `put()`                    |
| **Performance (worst case)**  | `O(n)` when hash collisions occur                | `O(log n)` (guaranteed by tree balance)               |

---

## 3. Performance Comparison

| Operation               | HashMap        | TreeMap                      |
|-------------------------|----------------|------------------------------|
| **Insertion (`put`)**   | ✅ O(1) average | ❌ O(log n)                   |
| **Lookup (`get`)**      | ✅ O(1) average | ❌ O(log n)                   |
| **Deletion (`remove`)** | ✅ O(1) average | ❌ O(log n)                   |
| **Iteration order**     | Unordered      | Sorted by keys               |
| **Memory usage**        | Lower          | Higher (tree node structure) |

## 4. When to Use

| Scenario                                          | Recommended Map                         |
|---------------------------------------------------|-----------------------------------------|
| Need **fast lookups and insertions**              | ✅ **HashMap**                           |
| Need **sorted keys** or **range queries**         | ✅ **TreeMap**                           |
| Need **ordering flexibility (custom Comparator)** | ✅ **TreeMap**                           |
| Need **thread-safe access**                       | Use `ConcurrentHashMap` instead of both |

## 🧠 Summary

- **HashMap** is best for **performance and unordered data**.
- **TreeMap** is best when you need **sorted keys** or **navigable operations** like `firstKey()`, `lastKey()`, `subMap()`.
- Both **implement the `Map` interface**, but their internal mechanics and use cases differ significantly.

- What is ConcurrentHashMap and when is it used?
- **Explain the difference between Queue and Deque.**
- **What is a PriorityQueue and how does it work?**
- **Explain the difference between Iterator and ListIterator.**
- **What is the difference between Comparable and Comparator?**
- **How to make a collection thread-safe?**
- **What is the difference between CopyOnWriteArrayList and Collections.synchronizedList()?**
- **Explain WeakHashMap and its use cases.**
- `WeakHashMap` is a class in Java that implements the `Map` interface and stores key-value pairs **using weak references for keys**.  
- It is part of the `java.util` package and was introduced to help manage memory more efficiently.
- In a `WeakHashMap`, if a key object is **no longer referenced elsewhere in the application**, it becomes **eligible for garbage collection**, and the corresponding entry is **automatically removed** from the map.
- **What is the difference between Set implementations: HashSet, LinkedHashSet, TreeSet?**
- **How does LinkedHashMap maintain insertion order?**
- **Explain the fail-fast behavior of Java collections.**
- **What is the difference between Vector and ArrayList?**
- **Explain the NavigableMap interface.**
- **How does EnumSet work?**
## Multithreading & Concurrency
- **Explain Java threads and how to create them.**
- **What is the difference between Runnable and Callable?**
- **What is the difference between Thread and ExecutorService?**
- **Explain synchronized blocks and methods.**
- **What is a deadlock? How to prevent it?**
- **What is livelock and starvation?**
- **What is the difference between wait(), notify(), and notifyAll()?**
- **Explain ReentrantLock and its advantages.**
- **What are atomic operations in Java?**
- **Explain volatile keyword in concurrency.**
- **What is a thread pool? How does it work?**
- **What are CountDownLatch and CyclicBarrier?**
- **What is Semaphore in Java?**
- **Explain ConcurrentHashMap internal working.**
- **What are ForkJoinPool and Parallel Streams?**
- **Difference between synchronized and Lock interface?**
- **Explain ThreadLocal in Java.**
- **Difference between yield() and sleep().**
- **How to handle thread safety in collections?**
- **Explain Executors.newFixedThreadPool() vs newCachedThreadPool().**
- **How to stop a thread in Java?**
- Thread.stop method is deprecated
- Method 1: Using a Volatile Flag.
- Method 2: Using Thread.interrupt()
- Method 3: Using ExecutorService
## Java Memory Management & Garbage Collection
Explain the Java memory model (Heap, Stack, Metaspace).
What is garbage collection in Java?
Types of garbage collectors in Java (Serial, Parallel, G1, ZGC, etc.).
What is the difference between strong, weak, soft, and phantom references?
Explain finalize() method.
What are memory leaks in Java?
What is PermGen and Metaspace?
How does Java manage object allocation in heap?
Difference between stack memory and heap memory.
How to optimize memory usage in Java?
## Java 8 & Above Features
Explain Lambda expressions in Java.
What are functional interfaces?
Difference between Predicate, Function, Consumer, and Supplier.
Explain Streams API.
What is the difference between map() and flatMap()?
What are Optional and its use cases?
What are default and static methods in interfaces?
Difference between sequential and parallel streams.
What is method reference in Java 8?
Explain Collectors in Streams API.
How to handle checked exceptions in lambda?
What is the difference between peek() and map() in streams?
Explain CompletableFuture.
Difference between forEach and map in Streams.
What are the new features in Java 9, 10, 11, and 17? (modules, var, etc.)
Design Patterns & Best Practices
Explain Singleton pattern and its implementations.
What is Factory pattern?
Explain Observer pattern.
What is Decorator pattern?
Explain Builder pattern.
What is Dependency Injection?
Explain MVC design pattern.
What is the difference between DAO and Repository patterns?
Explain the Strategy pattern.
What are best practices for writing maintainable Java code?