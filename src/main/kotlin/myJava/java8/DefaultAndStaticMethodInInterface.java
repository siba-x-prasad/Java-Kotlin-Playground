package myJava.java8;

public class DefaultAndStaticMethodInInterface {
    public static void main(String[] args) {
        // Usage:
        Car myCar = new Car();
        myCar.start();
        myCar.turnHornOn(); // Uses the default implementation
        System.out.println(Vehicle.getProducer()); // Call the static method
    }
}

interface Vehicle {
    void start(); // Abstract method

    default void turnHornOn() { // Default method with implementation
        System.out.println("Beep beep!");
    }

    static String getProducer() { // Static method in the interface
        return "Generic Motors";
    }
}

class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started.");
    }
}

