package myJava.java8.lambdas;

public interface LambdaWithMultipleFunctions {
    abstract void print(String name);

    default void printAge(int age) {
        System.out.println("My Age is " + age);
    }
}
