# Java 8

- Lambda expressions
- Method references
- Functional interfaces
- Stream API
- Default methods
- Base64 Encode Decode
- Static methods in interface
- Optional class
- Collectors class
- ForEach() method
- Nashorn JavaScript Engine
- Parallel Array Sorting
- Type and Repeating Annotations
- IO Enhancements
- Concurrency Enhancements

## Lambda Expression

- Lambda expression helps us to write our code in functional style.
- It provides a clear and concise way to implement SAM interface(Single Abstract Method) by using an
  expression.
- It is very useful in collection library in which it helps to iterate, filter and extract data.

## Functional Interface

- Lambda expression provides implementation of functional interface.
- An interface which has only one abstract method is called functional interface.
- Java provides an annotation @FunctionalInterface, which is used to declare an interface as
  functional interface.

## Why use Lambda Expression

- To provide the implementation of Functional interface.
- Less coding.

## Lambda Syntax

```
    (argument-list) -> {body}
```

- Java lambda expression is consisted of three components.
-
    1) Argument-list: It can be empty or non-empty as well.
-
    2) Arrow-token: It is used to link arguments-list and body of expression.
-
    3) Body: It contains expressions and statements for lambda expression.

- No Parameter Syntax

```
    () -> {  
    //Body of no parameter lambda  
    }  
```

- One Parameter Syntax

```
    (p1) -> {  
        //Body of single parameter lambda  
    }  
```

- Two Parameter Syntax

```
    (p1,p2) -> {  
        //Body of multiple parameter lambda  
    }  
```

## Default Method

- Default methods in Java 8 also known as defender methods allow Java developers to add new methods
  to the existing interfaces in their code without breaking their current implementation.
- Default methods enable you to add new functionality to existing interfaces and ensure binary
  compatibility with code written for older versions of those interfaces.

```
public interface LambdaWithMultipleFunctions {
    abstract void print(String name);
    default void printAge(int age){
        System.out.println("My Age is "+age);
    }
}
```

## @FunctionalInterface annotation

- It's not mandatory to mark the functional interface with @FunctionalInterface annotation, the
  compiler doesn't throw any error.
- But it's good practice to use @FunctionalInterface annotation to avoid the addition of extra
  methods accidentally.

```
@FunctionalInterface
public interface LambdaWithReturntype {
    abstract int sum(int a, int b);
}
```

- By defining this annotation, other developers came to know this before adding any other abstract
  method.

## Method Reference

- Java provides a new feature called method reference in Java 8.
- Method reference is used to refer method of functional interface.
- It is compact and easy form of lambda expression. Each time when you are using lambda expression
  to just referring a method, you can replace your lambda expression with method reference.
- In this tutorial, we are explaining method reference concept in detail.

- Types of Method References
- There are following types of method references in java:

1. Reference to a static method.
2. Reference to an instance method.
3. Reference to a constructor.

```
interface Sayable{  
    void say();  
}  
public class MethodReference {  
    public static void saySomething(){  
        System.out.println("Hello, this is static method.");  
    }  
    public static void main(String[] args) {  
        // Referring static method  
        Sayable sayable = MethodReference::saySomething;  
        // Calling interface method  
        sayable.say();  
    }  
}  
```

# Java 8 Features

Java 8, released in March 2014, introduced major language enhancements and API changes. It brought functional programming features, new APIs, and improvements to concurrency and performance. This README lists the key features of Java 8 along with brief introductions and examples.

---

## 1. Lambda Expressions

* Enable passing behavior (functions) as parameters.
* Makes code concise and readable.

```
List<String> names = Arrays.asList("John", "Jane", "Jack");
names.forEach(name -> System.out.println(name));
```

---

## 2. Functional Interfaces

* Interfaces with a single abstract method (SAM) used with lambda expressions.
* Can be annotated with `@FunctionalInterface`.

```
@FunctionalInterface
interface Calculator {
    int add(int a, int b);
}

Calculator calc = (a, b) -> a + b;
System.out.println(calc.add(5, 3));
```

---

## 3. Streams API

* Provides a functional approach to process collections of objects.
* Supports operations like `map`, `filter`, `reduce`.

```
List<Integer> numbers = Arrays.asList(1,2,3,4,5);
int sum = numbers.stream()
                 .filter(n -> n % 2 == 0)
                 .mapToInt(Integer::intValue)
                 .sum();
System.out.println(sum); // 6
```

---

## 4. Method References

* Shorter way to refer to methods or constructors.

```
List<String> names = Arrays.asList("John", "Jane", "Jack");
names.forEach(System.out::println);
```

---

## 5. Default Methods in Interfaces

* Interfaces can have methods with a default implementation.

```
interface Vehicle {
    default void start() {
        System.out.println("Vehicle started");
    }
}

class Car implements Vehicle {}
new Car().start(); // Vehicle started
```

---

## 6. Optional Class

* Helps to avoid `NullPointerException`.
* Represents a value that may or may not be present.

```
Optional<String> name = Optional.ofNullable(null);
System.out.println(name.orElse("Default Name"));
```

---

## 7. New Date and Time API (java.time)

* Provides immutable and thread-safe classes for date and time.

```
LocalDate today = LocalDate.now();
LocalDate birthday = LocalDate.of(1990, Month.JANUARY, 1);
Period age = Period.between(birthday, today);
System.out.println(age.getYears());
```

---

## 8. Nashorn JavaScript Engine

* Allows embedding JavaScript code within Java applications.

```
ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
engine.eval("print('Hello from JavaScript')");
```

---

## 9. Parallel Streams

* Stream API can run operations in parallel for performance improvements.

```
List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
int sum = numbers.parallelStream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
System.out.println(sum);
```

---

## 10. Collectors API

* Supports aggregation operations on streams like `groupingBy`, `joining`, `partitioningBy`.

```
List<String> names = Arrays.asList("John", "Jane", "Jack");
String result = names.stream().collect(Collectors.joining(", "));
System.out.println(result); // John, Jane, Jack
```


## Summary
* **Functional programming:** Lambda expressions, Streams API, Method references
* **Better API for collections and data:** Optional, Collectors
* **Immutable and thread-safe date-time handling:** java.time
* **Improved interface flexibility:** Default and static methods
* **Parallel processing:** Parallel Streams
