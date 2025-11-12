package myJava.java8;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        String name = null;
// Use Optional.ofNullable to handle potential nulls gracefully
        Optional<String> optionalName = Optional.ofNullable(name);

// Provide a default value if the name is absent
        String result = optionalName.orElse("Default Name");
        System.out.println(result); // Output: Default Name

// Execute an action only if the value is present
        optionalName.ifPresent(n -> System.out.println("Hello " + n)); // Does nothing
    }
}
