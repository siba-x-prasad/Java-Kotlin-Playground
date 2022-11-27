# Polymorphism

- Polymorphism is the ability of an object to take on different forms.
- In Java, polymorphism refers to the ability of a class to provide different implementations of a
  method, depending on the type of object that is passed to the method.
- To put it simply, polymorphism in Java allows us to perform the same action in many ways.
- Any Java object that can pass more than one IS-A test is polymorphic in Java.
- Therefore, all the Java objects are polymorphic as it has passed the IS-A test for their own type
  and for the class Object.

## Polymorphism Types

- Static Polymorphism/ Static Binding/ Compile time polymorphism
- Dynamic Polymorphism/ Dynamic Binding/ Run time polymorphism

## Static Polymorphism/ Static Binding/ Compile time polymorphism

- If 2 methods have same method name but different method signature in same class is known as method
  Overloading.
- The method signature is the combination of the method name and the parameter list.
- If it's decided which method will be called at compile time is known as Static Binding
- Method Overloading is known as Static Binding

## Dynamic Polymorphism/ Dynamic Binding/ Run time polymorphism

- If it's decided which method will be called at Run time is known as Dynamic Binding
- Method Overloading is known as Dynamic Binding

## Interview Questions

- **How Java compiler differentiate between methods in Compile time Polymorphism?**
- Ans: During compilation, Java compiler differentiates multiple methods having the same name by
  their signatures.
- **What is Runtime Polymorphism (Dynamic Polymorphism)?**
- Ans: A polymorphism where object binding with methods happens at runtime is called runtime
  polymorphism.
- In runtime polymorphism, the behavior of a method is decided at runtime.
- JVM (Java Virtual Machine) binds the method call with method definition/body at runtime and
  invokes the relevant method during runtime when the method is called.
- This happens because objects are created at runtime and the method is called using an object of
  the class.

- **Is it possible to implement runtime polymorphism by data members in Java?**
- Ans: No, we cannot implement runtime polymorphism by data members in java.

- **What are the differences between compile-time polymorphism and runtime polymorphism in java?**
- Ans: There are three main differences between compile-time polymorphism and runtime polymorphism
  that are as follows:
- a) In the compile-time polymorphism, the behavior of a method is decided at compile-time. Hence,
  Java compiler binds method calls with method definition/body during compilation.
- In runtime polymorphism, the behavior of a method is decided at runtime, JVM binds the method call
  with method definition at runtime and invokes the relevant method during runtime when the method
  is called.
- b) Compile time polymorphism is also known as early binding because the binding is performed at
  compile time.
- Runtime polymorphism is also known as late binding because the binding is performed at runtime.
- c) Compile time polymorphism can be achieved via method overloading.
- Runtime polymorphism can be achieved via method overriding.

- **What is Binding in Java?**
- Ans: The connecting (linking) between a method call and method definition is called binding in
  java.

- **What are the types of binding in Java?**
- There are two types of binding in java. They are as follows:
- a. Static Binding (also known as Early Binding).
- b. Dynamic Binding (also known as Late Binding).

- **What is Static binding in Java?**
- The binding that happens during compilation is called static binding in java. This binding is
  resolved at the compiled time by the compiler.

- **How Java compiler performs static binding?**
- Java compiler just checks which method is going to be called through reference variable and method
  definition exists or not.
- It does not check the type of object to which a particular reference variable is pointing to it.

- **Why static binding is also called early binding in Java?**
- Static binding is also called early binding because it takes place before the program actually
  runs.

- **Give an example of static binding.**
- An example of static binding is method overloading.

- **What is Dynamic binding in Java?**
- The binding which occurs during runtime is called dynamic binding in java. This binding is
  resolved based on the type of object at runtime.

- **How JVM performs dynamic binding in Java?**
- In the dynamic binding, the actual object is used for binding at runtime. JVM resolved the method
  calls based on the type of object at runtime. The type of object cannot be determined by the
  compiler.

- **Why Dynamic binding is also called late binding in java?**
- Dynamic binding is also called late binding or runtime binding because binding occurs during
  runtime.

- **Give an example of dynamic binding in Java.**
- An example of dynamic binding is method overriding.

- **What is the difference between static binding and dynamic binding in Java?**
- Refer to this tutorial: Polymorphism in Java OOPs with Example

- **Why binding of private, static, and final methods are always static binding in Java?**
- Static binding is better performance-wise because java compiler knows that all such methods cannot
  be overridden and will always be accessed by object reference variable.
- Hence, the compiler doesn’t have any difficulty in binding between a method call and method
  definition.
- That’s why binding for such methods is always static.

