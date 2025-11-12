package myJava.java8.lambdas;

public class UseOfLambda {
    public static void main(String[] args) {
        // Here is the example without using Lambda
        int width = 10;
        //without lambda, Drawable implementation using anonymous class
        Drawable d = new Drawable() {
            public void draw() {
                System.out.println("Drawing Without Lambda " + width);
            }
        };
        d.draw();
        //Using lambda, Drawable implementation using anonymous class
        Drawable lambdaDrawable = () -> {
            System.out.println("Drawing Using Lambda " + width);
        };
        lambdaDrawable.draw();

        System.out.println("Functional Interface with Default method");
        // calling lambda with Multiple functions in Interface
        LambdaWithMultipleFunctions lf = (String name) -> {
            System.out.println("Printing argument lambda" + name);
        };
        lf.print("Siba prasad");
        lf.printAge(23);

        System.out.println("Lambda with Return type");
        LambdaWithReturnType lambdaWithReturntype = (a, b) -> {
            System.out.println("Returning the sum of " + a + " And " + b);
            return a + b;
        };

        int result = lambdaWithReturntype.sum(12, 13);
        System.out.println("Sum is " + result);

    }
}
