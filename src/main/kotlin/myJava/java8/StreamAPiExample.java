package myJava.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPiExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

// Filter even numbers and multiply by 2 using Stream API
        List<Integer> doubledEvenNumbers = numbers.stream() // Create stream
                .filter(n -> n % 2 == 0) // Intermediate operation (filter)
                .map(n -> n * 2) // Intermediate operation (map)
                .collect(Collectors.toList()); // Terminal operation (collect to List)

        System.out.println(doubledEvenNumbers); // Output: [4, 8, 12]
    }
}
