# Java 17 Features
# Java 17 Features

Java 17 is a Long-Term Support (LTS) release, released in September 2021. It brings both language and JVM enhancements. This README lists the key features of Java 17 along with brief introductions and examples.

---

## 1. Sealed Classes

* Allow a class or interface to restrict which other classes can extend or implement it.
* Useful for modeling finite hierarchies.

```java
public sealed class Shape permits Circle, Rectangle {}
final class Circle extends Shape {}
final class Rectangle extends Shape {}
```

---

## 2. Pattern Matching for `instanceof`

* Simplifies type checking and casting.

```
Object obj = "Hello, Java 17";
if (obj instanceof String s) {
    System.out.println(s.toUpperCase());
}
```

---

## 3. Enhanced `switch` Expressions

* Switch can now return values and use arrow syntax.

```java
int day = 3;
String type = switch (day) {
    case 1, 7 -> "Weekend";
    default -> "Weekday";
};
```

---

## 4. Text Blocks

* Multiline string literals with `"""`.

```java
String json = """
{
    "name": "John",
    "age": 30
}
""";
```

---

## 5. Records

* Immutable data classes that automatically generate getters, equals, hashCode, and toString.

```
public record Point(int x, int y) {}
Point p = new Point(5, 10);
System.out.println(p.x()); // 5
```

---

## 6. Foreign Function & Memory API (Incubator)

* Provides a safer way to interact with native code, replacing JNI.

```java
// Example requires additional setup (Incubator module)
```

---

## 7. Strong Encapsulation of JDK Internals

* Internal APIs like `sun.misc.Unsafe` are strongly encapsulated by default.

---

## 8. Deprecations and Removals

* Removal of Applet API
* Removal of Experimental AOT and JIT Compiler
* Deprecation of RMI Activation system

---

## 9. Enhanced Pseudo-Random Number Generators

* New interface for pluggable and better random generators.

```
RandomGenerator r = RandomGenerator.of("L64X128MixRandom");
System.out.println(r.nextInt());
```

---

## 10. New macOS Rendering Pipeline

* Uses Apple Metal API instead of OpenGL for better rendering performance.

---

## 11. macOS/AArch64 Port

* Java now runs natively on Apple Silicon without Rosetta.

---

## 12. Deprecate Security Manager

* Security Manager and its API are deprecated for removal.

---

## 13. Sealed Interfaces

* Interfaces can now restrict which classes implement them.

```java
public sealed interface Vehicle permits Car, Truck {}
```

---

## 14. Other JVM and Performance Enhancements

* Garbage Collector improvements (G1, ZGC)
* Stronger encapsulation of internal APIs
* General performance and stability improvements

---

## Summary

Java 17 focuses on:

* **Modern language features:** Records, Sealed Classes, Pattern Matching
* **Cleaner code:** Enhanced switch, Text Blocks
* **JVM improvements:** Performance, Mac M1 support, RandomGenerator API
* **Deprecations/removals:** Applet, Security Manager, unsafe internal APIs
