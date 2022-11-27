package myJava.oops.polymorphism;

public class DynamicPolymorphism {
    public static void main(String[] args) {
        Bike b = new Splendor();//upcasting
        b.run();
        Bike b1 = new Bike();//upcasting
        b1.run();
    }
}

class Bike {
    void run() {
        System.out.println("running");
    }
}

class Splendor extends Bike {
    void run() {
        System.out.println("running safely with 60km");
    }
}