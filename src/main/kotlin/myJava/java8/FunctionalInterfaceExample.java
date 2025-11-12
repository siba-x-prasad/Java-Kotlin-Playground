package myJava.java8;

@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        // Using a lambda expression to implement the functional interface
        Greeting greet = name -> System.out.println("Hello, " + name);
        greet.sayHello("World");
    }
}
