# Interface

## Interface Interview Question

-
    1. What is an interface in Java?
-
    - Ans:An interface in Java is a mechanism that is used to achieve complete abstraction. It is
      basically a kind of class that contains only constants and abstract methods.

-
    2. Can we define private and protected modifiers for data members (fields) in interfaces?
-
    - Ans:No, we cannot define private and protected modifiers for variables in interface because
      the fields (data members) declared in an interface are by default public, static, and final.

-
    3. Which modifiers are allowed for methods in an Interface?
-
    - Ans:Only abstract and public modifiers are allowed for methods in interfaces.

-
    4. Suppose A is an interface. Can we create an object using new A()?
- Ans:No, we cannot create an object of interface using new operator. But we can create a reference
  of interface type and interface reference refers to objects of its implementation classes.

-
    5. Can we define an interface with a static modifier?
- Ans:Yes, from Java 8 onwards, we can define static and default methods in an interface. Prior to
  Java 8, it was not allowed.

6. Suppose A is an interface. Can we declare a reference variable a with type A like this: A a;

- Ans:Yes.

-
    7. Can an interface extends another interface in Java?
- Ans:Yes, an interface can extend another interface.

-
    8. Can an interface implement another interface?
- Ans:No, an interface cannot implement another interface.

-
    9. Is it possible to define a class inside an interface?
- Ans:Yes, we can define a class inside an interface.

-
    10. Which of the following is a correct representation of interface?
- a)

```
public abstract interface A {
    abstract void m1() {};
    }
```

- b)

```
public abstract interface A {
    void m1();
    }
```

- c)

```
abstract interface A extends B, C {
    void m1();
    }
```    

- d)

```
abstract interface A extends B, C {
    void m1(){};
    }
```

- e)

```
abstract interface A {
        m1();
    }
```

- f)

```
interface A {
        void m1();
    }
```

- g)

```
interface A {
    int m1();
    }
```

- h)

```
public interface A {
    void m1();
    }
        public class B implements A {
    }
```

- i)

```
public interface A {
        void m1();
    }
    Public interface B {
        void m1();
    }
    public interface C extends A, B {
        void m1();
    }
```

- Ans:b, c, f, g, i.

-
    11. Identify the error in the following code.
- a)

```
interface A {
    void m1();
}
public class B implements A {
    void m1(){
        System.out.println("One"); 	
    }
}
```

- Ans:We cannot reduce the visibility of inherited method from interface A.

- b)

```
interface A {
    A() { }
    void m1();
}
public abstract class B implements A {
    public void m1(){
        System.out.println("One"); 	
    }
}
```

- Ans:An interface cannot have a constructor.

- c)

```
interface A {
    int x;
    void m1();
}
public class B implements A {
    int x = 20;
    public void m1(){
        System.out.println("One"); 	
    }
}
```

- Ans:A variable in an interface must be initialized at the time of declaration.


-
    12. What will be the output of the following program?

```
interface A {
    int x = 10;
    void m1();
}
public class B implements A {
    int x = 20;
    public void m1(){
        System.out.println("One"); 	
    }
}
public class Test {
public static void main(String[] args){
        A a = new B();
        a.m1();
        System.out.println(a.x);
    }
}
```

- Ans:Output: One, 10.

-
    13. Can an interface extend multiple interfaces?
- Ans:Yes, an interface can extend multiple interfaces.

-
    14. Can an interface has instance and static blocks?
- Ans:No.

-
    15. What will be the output of the following program?

```
interface A {
    int x = 10;
}
interface B {
    int x = 20;
}
interface C extends A, B {
    int x = 30;
public static void main(String[] args){
        int a = A.x;
        int b = B.x;
        int c = C.x;
        
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
```

- Ans:Output: 10, 20, 30

-
    16. What happens if a class has implemented an interface but has not provided implementation for
        that method defined in Interface?
- Ans:The class has to be declared with an abstract modifier. This will be enforced by the Java
  compiler.

-
    17. Why an Interface method cannot be declared as final in Java? Or, Can a method within an
        interface be marked as final?
- Ans:Not possible. Doing so will result the compilation error problem. This is because a final
  method cannot be overridden in java. But an interface method should be implemented by another
  class.
- So, the interface method cannot be declared as final. The modifiers such as public and abstract
  are only applicable for method declaration in an interface.

-
    18. Can an interface be final?
- Ans:No. Doing so will result compilation error problem.

-
    19. Why an interface cannot have a constructor?
- Ans:Inside an interface, a constructor cannot be called using super keyword with hierarchy.

-
    20. Why an Interface can extend more than one Interface but a Class can’t extend more than one
        Class?
- Ans:We know that Java doesn’t allow multiple inheritance because a class extends only one class.
  But an Interface is a pure abstraction model. It does not have inheritance hierarchy like classes.
- Therefore, an interface allows to extend more than one Interface.

-
    21. What is the use of interface in Java? Or, why do we use an interface in Java?
- Ans:There are many reasons to use interface in java. They are as follows:

- a. An interface is used to achieve fully abstraction.
- b. Using interfaces is the best way to expose our project’s API to some other project.
- c. Programmers use interface to customize features of software differently for different objects.
- d. By using interface, we can achieve the functionality of multiple inheritance.

-
    22. Is it necessary to implement all abstract methods of an interface?
- Ans:Yes, all the abstract methods defined in interface must be implemented.

-
    23. Can we define a variable in an interface? What type it should be?
- Ans:Yes, we can define variable in an interface that must be implicitly static and final.

-
    24. Can we re-assign a value to a variable of interface?
- Ans:No, variables defined inside the interface are static and final by default. They are just like
  constants. We can’t change their value once they got.

-
    25. What is the difference between abstract class and interface in Java?
- Ans:Refer to this tutorial: 12 Difference between Abstract class and Interface in Java

-
    26. What is the difference between class and interface in Java?
- Ans:Refer to this tutorial: Difference between Class and Interface in Java

-
    27. What is a Marker Interface in Java?
- Ans:An Interface that doesn’t have any data members or methods is called marker interface in java.
  For example, Serializable, Cloneable, Remote, etc.

-
    28. What is a Nested interface?
- Ans:An interface declared inside another interface is called nested interface. By default, it is
  static in nature. It is also known as static interface.

-
    29. Can we reduce the visibility of interface method while overriding?
- Ans:No, while overriding any interface methods, we must use public only. This is because all
  interface methods are public by default. We cannot reduce the visibility while overriding them.

-
    30. Can we define an interface inside a method as local member?
- Ans:No, we can’t define an interface as local member of a method like local inner class.

-
    31. Will the code compiled successfully? If yes, what will be the output?

```
interface A {
    void m1(int x, double y);
    void m2(String z);
}
class B implements A {
    public void m1(int x, double y) {
        System.out.println("Hello");	 
    }
    public void m2(String z){
        System.out.println("Java");	 
    }
    void m3() {
        System.out.println("Hello Java!");	 
    }
}
public class Test {
    public static void main(String[] args){
        B b = new B();
        b.m1(20, 10.0);
        b.m2(null);
        b.m3();
    }
}
```

- Ans:Yes, the code will be compiled successfully. The output is Hello, Java, Hello Java!.