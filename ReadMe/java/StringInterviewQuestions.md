# 💬 Java String Interview Questions — From Basics to Advanced

Strings are one of the most frequently discussed topics in Java interviews.  
They are **immutable**, **widely used**, and involve many concepts like **memory management**, **pooling**, and **performance optimization**.

This document covers **Java String interview questions** from beginner to advanced, with clear examples and explanations.

---

## 🧩 Table of Contents

1. [Basic String Questions](#1-basic-string-questions)
2. [Intermediate String Questions](#2-intermediate-string-questions)
3. [Advanced String Questions](#3-advanced-string-questions)
4. [StringBuilder and StringBuffer](#4-stringbuilder-and-stringbuffer)
5. [Common Coding Examples](#5-common-coding-examples)

---

## 1. 🧱 Basic String Questions

### 1️⃣ What is a `String` in Java?
- A `String` in Java is an **object** representing a sequence of characters.
- It is **immutable**, meaning once created, it cannot be modified.

**Example:**
```
String s = "Hello";
String t = new String("World");
```
2) Why are Strings immutable in Java?
- For security (used in passwords, class loading, etc.).
- For caching and reusability in the String pool.
- For thread-safety (immutable objects are inherently safe).
- Example:
```
String s1 = "Java";
s1.concat("Lang");
System.out.println(s1); // Output: Java (not JavaLang)
```
3) What is the String Constant Pool (SCP)?
- The String pool is a special memory region inside the heap.
- When a string literal is created, JVM checks if it already exists in the pool.
- Example:
```
String s1 = "Hello";
String s2 = "Hello";
System.out.println(s1 == s2); // true (same object in pool)
```
4) What is the difference between == and .equals() for Strings?
- Operator	  Compares	                     Example
-   ==	      References (memory location)	s1 == s2
-  .equals()  Values (content)	            s1.equals(s2)
- Example:
```
    String a = new String("Test");
    String b = "Test";
    System.out.println(a == b);       // false
    System.out.println(a.equals(b));  // true
    5️⃣ How to create a String in Java?
    String literal = "Hello"; // Stored in String pool
    String object = new String("Hello"); // Stored in heap memory
```
️
## Intermediate String Questions
6) What happens when you use + to concatenate Strings?
- The compiler internally uses StringBuilder for optimization in a single statement.
- Example:
```
String s = "Hello" + "World"; // Compiled as new StringBuilder().append("Hello").append("World").toString();
```
7) How do you compare two Strings ignoring case?
```   
String s1 = "Java";
   String s2 = "java";
   System.out.println(s1.equalsIgnoreCase(s2)); // true
```   
8) What are some commonly used String methods?
- Method	Description	Example
- length()	Returns length	s.length()
- charAt(int index)	Returns character at position	s.charAt(0)
- substring(int start, int end)	Returns part of string	s.substring(1,4)
- contains(String str)	Checks substring existence	s.contains("abc")
- toUpperCase() / toLowerCase()	Case conversion	s.toUpperCase()
- trim()	Removes whitespace	s.trim()
- split(String regex)	Splits string	s.split(",")
9) How to convert a String to a character array or byte array?
```
String s = "Java";
   char[] chars = s.toCharArray();
   byte[] bytes = s.getBytes();
```   
10) What is the difference between String, StringBuilder, and StringBuffer?
- Type	        Mutable	        Thread-Safe	      Performance
- String	     ❌ No	          ✅ Yes	         Slow (creates new object each time)
- StringBuilder	 ✅ Yes	          ❌ No	             Fastest
- StringBuffer	 ✅ Yes	          ✅ Yes	         Slightly slower than StringBuilder
##  Advanced String Questions
11) How does intern() method work?
- It ensures that a String refers to the object in the String pool.
```
Example:
   String s1 = new String("Java");
   String s2 = s1.intern();
   String s3 = "Java";

System.out.println(s2 == s3); // true
```
12. How are Strings stored in memory?
- String literals go to String Constant Pool (SCP).
- new String() creates a separate object in the heap.
13) What is a memory leak with Strings?
- If you store many temporary or large Strings (e.g., in StringBuilder) and don’t clear references, they remain in memory until GC runs.
14) How to reverse a String efficiently?
```
String s = "Hello";
String reversed = new StringBuilder(s).reverse().toString();
System.out.println(reversed); // olleH
```
15) Why are Strings used in switch statements?
- From Java 7 onwards, String can be used in switch.
- Internally uses hashCode() and equals().
```
Example:
String lang = "Java";
switch (lang) {
    case "Java": System.out.println("Java selected"); break;
    case "Python": System.out.println("Python selected"); break;
}
```
## 🧱 StringBuilder and StringBuffer
16) When should you use StringBuilder?
- When you need to modify or concatenate Strings frequently.
- Example: building dynamic SQL queries, HTML strings, or logs.
- Example:
```
StringBuilder sb = new StringBuilder();
   sb.append("Java").append(" ").append("Rocks!");
   System.out.println(sb.toString());
```   
17) Difference between StringBuffer and StringBuilder?
- StringBuffer is synchronized (thread-safe).
- StringBuilder is not synchronized (faster, for single-threaded use).
5. 🧠 Common Coding Examples
   ✅ Reverse words in a sentence
   String input = "Java is powerful";
   String[] words = input.split(" ");
   StringBuilder reversed = new StringBuilder();
   for (int i = words.length - 1; i >= 0; i--) {
   reversed.append(words[i]).append(" ");
   }
   System.out.println(reversed.toString().trim()); // powerful is Java
   ✅ Check if a String is a palindrome
   String s = "madam";
   String reversed = new StringBuilder(s).reverse().toString();
   System.out.println(s.equals(reversed)); // true
   ✅ Count occurrences of a character
   String s = "banana";
   long count = s.chars().filter(ch -> ch == 'a').count();
   System.out.println(count); // 3
   ✅ Remove duplicates from a String
   String s = "programming";
   StringBuilder sb = new StringBuilder();
   s.chars().distinct().forEach(c -> sb.append((char)c));
   System.out.println(sb); // progamin
   ✅ Find the first non-repeating character
   String s = "swiss";
   for (char c : s.toCharArray()) {
   if (s.indexOf(c) == s.lastIndexOf(c)) {
   System.out.println(c);
   break;
   }
   }
   📚 References