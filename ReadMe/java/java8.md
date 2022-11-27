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
- Java provides an anotation @FunctionalInterface, which is used to declare an interface as
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
