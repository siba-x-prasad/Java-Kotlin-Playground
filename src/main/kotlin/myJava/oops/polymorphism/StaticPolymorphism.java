package myJava.oops.polymorphism;

public class StaticPolymorphism {

    public static void main(String[] args) {
        StaticPolymorphism staticPolymorphism = new StaticPolymorphism();
        staticPolymorphism.calculateInterest(1000, 8.5f, 5);
        staticPolymorphism.calculateInterest(1000, 8, 5);
    }

    private void calculateInterest(int principleAMount, float interestRate, int numberOfYearYear) {
        float interest = (principleAMount * interestRate * numberOfYearYear) / 100;
        System.out.println("Interest is " + interest);
    }

    private void calculateInterest(int principleAMount, int interestRate, int numberOfYearYear) {
        int interest = (principleAMount * interestRate * numberOfYearYear) / 100;
        System.out.println("Interest is " + interest);
    }

    void sum(int x, int y) {
        System.out.println("Sum of two numbers: " + (x + y));
    }

    void sum(int x, int y, int z) {
        System.out.println("Sum of three numbers: " + (x + y + z));
    }

}
