# Kotlin Interview Questions
- 1: What is Kotlin?
- A: Kotlin is a statically-typed language that runs on the Java Virtual Machine. It can seamlessly interoperate with Java and is considered an alternative to the standard Java compiler.

2. Is Kotlin better than Java?
- A: It’s simpler and much cleaner than Java, as it’s more concise and uses fewer lines of code in order to solve the same problems. Besides being generally more efficient and effective, Kotlin is safer in the sense that it prevents certain common coding errors. As a result, there are fewer app crashes and system failures. Kotlin comes with some features that aren’t available in Java, such as smart casts, operator overloading, data classes, null safety, coroutines, to name just a few.

3. What are extension functions in Kotlin?
- A: It’s a mechanism that allows extending a class without the need to inherit from the class or use Decorator or other design patterns.

4. What is null safety?
- A: This is a feature that prevents a null reference exception, the equivalent of Java’s NullPointerException in real time. 

5. Is there a ternary operator like in Java?
   A: No, there isn’t, but what a ternary operator does can be achieved through an if-else expression.

6. What’s the difference between val and var in Kotlin?
   A: Both are used for declaring a variable. However, while val is a final variable that is immutable and can be initialized only once, var is a general variable that can be assigned multiple times.

7. What are the basic data types in Kotlin?
   A: Numbers, characters, Booleans, arrays, and strings.

8. How many constructors are there in Kotlin?
   A: A constructor’s main role is to initialize the properties of a class. In Kotlin, there can be a primary constructor and one or more secondary constructors.

9. What are the extension methods that Kotlin provides to the Java.io file list?
   A:

bufferedReader():read contents of a file to BufferedReader
readBytes() : read contents of a file to ByteArray
readText(): read contents of a file to a single String
forEachLine() : read a file line by line in Kotlin
readLines(): read lines in a file to List
10. What are the structural expressions in Kotlin?
    A: There are three structural expressions:

Return: helps to return from the closest function or an anonymous function.
Break:  helps to terminate the closest enclosing loop.
Continue: helps proceed to the next step of the closest enclosing loop. 

## Interview Questions for Senior
1. What is the difference between const and val?
   A: Const is a keyword used to define compile-time constants, while val is used to define runtime constants.

2. Is it possible to migrate code from Java to Kotlin?
   A: Yes, it is. IntelliJ IDEA is a tool that can help you do that.

3. What are data classes in Kotlin?
   A data class is similar to a regular class with certain additional functionalities. For example, in order to store data items in Java, it’s necessary to create a class by setting the variables. In Kotlin, all it takes is adding keyword data to the class, and the compiler will automatically generate a default getter and setter. So, basically, there’s no need to write or generate the extensive boilerplate code. 
4. What modifiers are available in Kotlin?
   A: Kotlin offers four visibility modifiers:

Private: visible inside this class and all its members only.
Protected: the same as private, but visible in subclasses too.
Internal: visible inside the same module
Public: by default, all the declarations are visible to everyone.
5. What is a string in Kotlin?
   A:  It’s a basic data type. Strings are immutable and Kotlin has two types of string literals:

Raw strings, which are delimited by a triple quote and can contain newlines, arbitrary text, and any other character.   
Escaped strings, which handle special characters by escaping them.
6. What is the Init Block?  
   A: It’s the initializer block and the code inside of it is executed when the primary constructor is instantiated.

7. Is new a keyword in Kotlin?
   A: No, it’s not and it doesn’t have to be used to instantiate a class.

8. Are there primitives in Kotlin?
   In a nutshell, there are no out-of-the-box primitives in Kotlin – they can’t be created at a code level. Given that Kotlin has been designed to cooperate with Java and the JVM seamlessly, certain types like int or float can act like primitives in certain cases.

9. Is there an equivalent for switch in Kotlin?
   A: Yes, there is. The When keyword is used instead.

10. What are deconstructing declarations?
    A: Kotlin comes with a functionality that allows developers to assign multiple values to variables. This kind of syntax allows for creating multiple variables that can be used independently at once.

## Interview Questions from - https://www.fullstack.cafe/blog/kotlin-interview-questions
1.  How to initialize an array in Kotlin with values?
- In Java an array can be initialized such as:
```
    int numbers[] = new int[] {10, 20, 30, 40, 50}
```
- How does Kotlin's array initialization look like?
```
    val numbers: IntArray = intArrayOf(10, 20, 30, 40, 50)
```
2. How to create singleton in Kotlin?
```  
object SomeSingleton
```
- The above Kotlin object will be compiled to the following equivalent Java code:
```
    public final class SomeSingleton {
    public static final SomeSingleton INSTANCE;
    
    private SomeSingleton() {
        INSTANCE = (SomeSingleton)this;
        System.out.println("init complete");
    }
    
    static {
        new SomeSingleton();
        }
    }
```
3. What is a data class in Kotlin?
- We frequently create classes whose main purpose is to hold data. In Kotlin, this is called a data class and is marked as data:
```
    data class User(val name: String, val age: Int)
```
- To ensure consistency and meaningful behavior of the generated code, data classes have to fulfill the following requirements:
- The primary constructor needs to have at least one parameter;
- All primary constructor parameters need to be marked as val or var;
- Data classes cannot be abstract, open, sealed or inner;

4. What is basic difference between fold and reduce in Kotlin? When to use which?
- fold takes an initial value, and the first invocation of the lambda you pass to it will receive that initial value and the first element of the collection as parameters.
```
    listOf(1, 2, 3).fold(0) { sum, element -> sum + element }
```
- The first call to the lambda will be with parameters 0 and 1.
- Having the ability to pass in an initial value is useful if you have to provide some sort of default value or parameter for your operation.
- reduce doesn't take an initial value, but instead starts with the first element of the collection as the accumulator (called sum in the following example)
```
listOf(1, 2, 3).reduce { sum, element -> sum + element }
```
- The first call to the lambda here will be with parameters 1 and 2. 
5. What is the difference between var and val in Kotlin?
- var is like general variable and it's known as a mutable variable in kotlin and can be assigned multiple times.
- val is like Final variable and it's known as immutable in Kotlin and can be initialized only single time.

6. Where should I use var and where val?
- Use var where value is changing frequently. For example while getting location of android device:
- var integerVariable : Int? = null
- Use val where there is no change in value in whole class. For example you want set textview or button's text programmatically.
- val stringVariables : String = "Button's Constant or final Text"

7. Explain advantages of when vs switch in Kotlin
- In Java we use switch but in Kotlin, that switch gets converted to when. When has a better design. It is more concise and powerful than a traditional switch. when can be used either as an expression or as a statement.
- Some examples of when usage:
- Two or more choices
```
    when(number) {
        1 -> println("One")
        2, 3 -> println("Two or Three")
        4 -> println("Four")
        else -> println("Number is not between 1 and 4")
    }
```
- "when" without arguments
```
when {
number < 1 -> print("Number is less than 1")
number > 1 -> print("Number is greater than 1")
}
```
- Any type passed in "when"
```
    fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }
```
- Smart casting
```
    when (x) {
        is Int -> print("X is integer")
        is String -> print("X is string")
    }
```
- Ranges
```
    when(number) {
        1 -> println("One") //statement 1
        2 -> println("Two") //statement 2
        3 -> println("Three") //statement 3
        in 4..8 -> println("Number between 4 and 8") //statement 4
        !in 9..12 -> println("Number not in between 9 and 12") //statement 5
        else -> println("Number is not between 1 and 8") //statement 6
    }
```
8. Explain the null safety in Kotlin
9. Explain what is wrong with that code?
```
class Student (var name: String) {
    init() {
        println("Student has got a name as $name")
    }

    constructor(sectionName: String, var id: Int) this(sectionName) {
    }
}
```
- The property of the class can’t be declared inside the secondary constructor.. This will give an error because here we are declaring a property id of the class in the secondary constructor, which is not allowed.
```
class Student (var name: String) {
    var id: Int = -1
    init() {
        println("Student has got a name as $name")
    }
    
    constructor(secname: String, id: Int) this(secname) {
        this.id = id
    }
}
```
10. How is it recommended to create constants in Kotlin?
- In Kotlin, if you want to create the local constants which are supposed to be used with in the class then you can create it like below:
```
val MY_CONSTANT_1 = "Constants1"
// or
const val MY_CONSTANT_2 = "Constants2"
```
- Like val, variables defined with the const keyword are immutable. 
- The difference here is that const is used for variables that are known at compile-time.
- Also avoid using companion objects. Behind the hood, getter and setter instance methods are created for the fields to be accessible. 
- Calling instance methods is technically more expensive than calling static methods. 
- Instead define the constants in object:
```
    object DbConstants {
        const val TABLE_USER_ATTRIBUTE_EMPID = "_id"
        const val TABLE_USER_ATTRIBUTE_DATA = "data"
    }
```
11. How would you refactor this code using apply?
``` 
class Message(message: String, signature: String) {
    val body = MessageBody()
    
    init {
        body.text = message + "\n" + signature
    }
}
```
- You can write:
````
class Message(message: String, signature: String) {
    val body = MessageBody().apply {
        text = message + "\n" + signature
    }
}
````
12. May you use IntArray and an Array<Int> is in Kotlin interchangeably?
- Array<Int> is an Integer[] under the hood, while IntArray is an int[].
- This means that when you put an Int in an Array<Int>, it will always be boxed (specifically, with an Integer.valueOf() call). In the case of IntArray, no boxing will occur, because it translates to a Java primitive array.
- So no, we can't use them interchangeably.

13. Rewrite this code in Kotlin
- Can you rewrite this Java code in Kotlin?
```
public class Singleton {
    private static Singleton instance = null;
    private Singleton(){
    
    }
    private synchronized static void createInstance() {
    if (instance == null) {
        instance = new Singleton();
    }
}
public static Singleton getInstance() {
    if (instance == null) createInstance();
    return instance;
}
```
- - 
- Using Kotlin:
```
object Singleton
```

14. What are coroutines in Kotlin?
- Unlike many other languages with similar capabilities, async and await are not keywords in Kotlin and are not even part of its standard library.
- kotlinx.coroutines is a rich library for coroutines developed by JetBrains. It contains a number of high-level coroutine-enabled primitives, including launch, async and others. Kotlin Coroutines give you an API to write your asynchronous code sequentially.
- The documentation says Kotlin Coroutines are like lightweight threads. They are lightweight because creating coroutines doesn’t allocate new threads. Instead, they use predefined thread pools, and smart scheduling. Scheduling is the process of determining which piece of work you will execute next.
- Additionally, coroutines can be suspended and resumed - -execution. This means you can have a long-running task, which you can execute little-by-little. You can pause it any number of times, and resume it when you’re ready again.

15. What are the advantages of Kotlin over Java?
- Basically for me less thinking required to write kotlin equivalent to most java code:
- data class
  - java: you have to write getters and setters for each thing, you have to write hashCode properly (or let IDE auto generate, which you have to do again every time you change the class), toString (same problem as hashcode) and equals (same problem as hashCode). or you could use lombok, but that comes with some quirky problems of its own. record types are hopefully on the way. *kotlin: data class does it all for you.
  - getter and setter patterns
  - java: rewrite the getter and setter for each variable you use it for
  - kotlin: don't have to write getter and setter, and custom getter and setter take a lot less typing in kotlin if you do want to. also delegates exist for identical getters\setters

- abstract vs open classes
  - java: you have to make an abstract class implementation
  - kotlin: open class lets you make an inheritable class while also being usable itself. nice mix of interface and regular class imo

- extension functions
  - java: doesnt exist
  - kotlin: does exist, makes functions more clear in usage and feels more natural.

- null
  - java: Anything but primitives can be null at any time.
  - kotlin: you get to decide what can and cant be null. allows for nice things like inline class

- singleton
  - java: Memorize singleton pattern
  - kotlin: object instead of class

- generics
  - java: Theyre alright, nothing fancy
  - kotlin: Reified generics (you can access the actual type), in and out for covariance

- named parameters
  - java: does not exist, easy to break api back-compatibility if you arent careful.
  - kotlin: does exist, easy to preserve api back-compatiblity.

- primary constructor
  - java: does not have per-se, you still have to define everything inside the class
  - kotlin: very nice to be able to quickly write a constructor without any constructor function or extra needless declarations

17.  What is lateinit in Kotlin and when would you use it?
- lateinit means late initialization. If you do not want to initialize a variable in the constructor instead you want to initialize it later on and if you can guarantee the initialization before using it, then declare that variable with lateinit keyword. It will not allocate memory until initialized. You cannot use lateinit for primitive type properties like Int, Long etc.
-  lateinit var test: String
```
fun doSomething() {
    test = "Some value"
    println("Length of string is "+test.length)
    test = "change value"
}
```
- There are a handful of use cases where this is extremely helpful, for example:
- Android: variables that get initialized in lifecycle methods;
- Using Dagger for DI: injected class variables are initialized outside and independently from the constructor;
- Setup for unit tests: test environment variables are initialized in a @Before - annotated method;
- Spring Boot annotations (eg. @Autowired).


18. What is a purpose of Companion Objects in Kotlin?
- Unlike Java or C#, Kotlin doesn’t have static members or member functions. If you need to write a function that can be called without having a class instance but needs access to the internals of a class, you can write it as a member of a companion object declaration inside that class.
```
class EventManager {
    companion object FirebaseManager {
    }  
}
```
- val firebaseManager = EventManager.FirebaseManager
- The companion object is a singleton. The companion object is a proper object on its own, and can have its own supertypes - and you can assign it to a variable and pass it around. If you're integrating with Java code and need a true static member, you can annotate a member inside a companion object with @JvmStatic.

19. What is the Kotlin double-bang !! operator?
- The not-null assertion operator !! converts any value to a non-null type and throws a KotlinNullPointerException exception if the value is null.
- Consider:
```
fun main(args: Array<String>) {
    var email: String?
    email = null
    println(email!!)
}
```
- This operator should be used in cases where the developer is guaranteeing – it allows you to be 100% sure that its value is not null.

20. What is the difference between suspending vs. blocking?
- A blocking call to a function means that a call to any other function, from the same thread, will halt the parent’s execution. Following up, this means that if you make a blocking call on the main thread’s execution, you effectively freeze the UI. Until that blocking calls finishes, the user will see a static screen, which is not a good thing.
- Suspending doesn’t necessarily block your parent function’s execution. If you call a suspending function in some thread, you can easily push that function to a different thread. In case it is a heavy operation, it won’t block the main thread. If the suspending function has to suspend, it will simply pause its execution. This way you free up its thread for other work. Once it’s done suspending, it will get the next free thread from the pool, to finish its work.

21. What is the difference between List and Array types?
- The major difference from usage side is that Arrays have a fixed size while (Mutable)Listcan adjust their size dynamically. Moreover Array is mutable whereas List is not.
- Furthermore kotlin.collections.List is an interface implemented among others by java.util.ArrayList. It's also extended by kotlin.collections.MutableListto be used when a collections that allows for item modification is needed.
- On the jvm level Array is represented by arrays. List on the other hand is represented by java.util.List since there are no immutable collections equivalents available in Java.

22. What is the difference between const and val?
- consts are compile time constants. Meaning that their value has to be assigned during compile time, unlike vals, where it can be done at runtime.
- This means, that consts can never be assigned to a function or any class constructor, but only to a String or primitive.
- For example:
```
const val foo = complexFunctionCall()   //Not okay
val fooVal = complexFunctionCall()      //Okay

const val bar = "Hello world"           //Also okay
```
23. What is the difference between open and public in Kotlin?
- The open keyword means “open for extension“. The open annotation on a class is the opposite of Java's final: it allows others to inherit from this class.
- If you do not specify any visibility modifier, public is used by default, which means that your declarations will be visible everywhere. public is the default if nothing else is specified explicitly.

24. What is the equivalent of Java static methods in Kotlin?
- Place the function in the companion object.
```
class Foo {
    public static int a() { return 1; }
}
```
- will become:
```
class Foo {
    companion object {
        fun a() : Int = 1
    }
}
```
- to run
- Foo.a();
- Another way is to solve most of the needs for static functions with package-level functions. They are simply declared outside a class in a source code file. The package of a file can be specified at the beginning of a file with the package keyword. Under the hood these "top-level" or "package" functions are actually compiled into their own class. In the above example, the compiler would create a class FooPackage with all of the top-level properties and functions, and route all of your references to them appropriately.

25. What is the purpose of Unit-returning in functions? Why is VALUE there? What is this VALUE?
- Explain what is the purpose of Unit-returning in functions? Why is VALUE there? What is this VALUE?
```
fun printHello(name : String?) : Unit {
    if (name != null)
        print("Hello, $name!")
    else
        print("Hi there!")
    // We don't need to write 'return Unit.VALUE' or 'return', although we could
}
```
26. What will be result of the following code execution?
- What will be the output?
```
val aVar by lazy {
    println("I am computing this value")
    "Hola"
}
fun main(args: Array<String>) {
    println(aVar)
    println(aVar)
}
```
- For lazy the first time you access the Lazy property, the initialisation (lazy() function invocation) takes place. The second time, this value is remembered and returned:
```
I am computing this value
Hola
Hola
```
- 27. When to use lateinit over lazy initialization in Kotlin?
- There are some simple rules to determined if you should use one or the other for properties initialisation:
- If properties are mutable (i.e. might change at a later stage) use lateInit
- If properties are set externally (e.g. need to pass in some external variable to set it), use lateinit. There’s still workaround to use lazy but not as direct.
- If they are only meant to initialized once and shared by all, and it’s more internally set (dependent on variable internal to the class), then use lazy. Tactically, you could still use lateinit, but using lazy would better encapsulate your initialization code.
- Also compare:
- lateinit var	by lazy
- Can be initialized from anywhere the object seen from.	Can only be initialized from the initializer lambda.
- Multiple initialization possible.	Only initialize single time.
- Non-thread safe. It’s up to user to initialize correctly in a multi-threaded environment.	Thread-safety by default and guarntees that the initializer is invoked by once.
- Can only be used for var.	Can only be used for val.
- Not eligible for nonnull properties.	Not eligible for nonnull properties.
- An isInitialized method added to check whether the value has been initialized before.	Property never able to un-initialized.
- Not allowed on properties of primitive types.	Allowed on properties of primitive types.

28. When would you use Elvis operator in Kotlin?
- The Elvis operator is part of many programming languages, e.g. Kotlin but also Groovy or C#. The Elvis operator is the ternary operator with its second operand omitted.
```
    x ?: y // yields `x` if `x` is not null, `y` otherwise.
    If x isn't null, then it will be returned. If it is null, then the y will be returned.
```

29. How to create empty constructor for data class in Kotlin?
30. How would you override default getter for Kotlin data class?
31. What are Object expressions in Kotlin and when to use them?
32. What is Coroutine Scope and how is that different from Coroutine Context?
33. What is inline class in Kotlin and when do we need one? Provide an example.
34. How Kotlin coroutines are better than RxKotlin/RxJava?
35. How to implement Builder pattern in Kotlin?
36. Imagine you moving your code from Java to Kotlin. How would you rewrite this code in Kotlin?
37. What is The Billion Dollar Mistake?
38. What is the difference between * and Any in Kotlin generics?
39. What is the difference between launch/join and async/await in Kotlin coroutines?

## Coroutines Interview Questtions
- What is Coroutines ?
- Difference between Coroutines and  Thread ?
- What is suspend function  in coroutines
- What is coroutine Launcher ?
- what   is run blocking in coroutines
- Difference between   delay  and  Thread.sleep ?
- What  is  Scope in Coroutines ?
- What  is Context in Coroutines ?
- How to  combine the result of 2 couroutines result
- Use of async and await in coroutines
- What is Dispatcher
- How to transfer the result from coroutines to main thread/ ui thread.
- Exception handling in coroutines
- What are Jobs in coroutines and  where it's used
- How to cancel a Coroutine
- What is flow
- How to create a flow
- StateFlow and SharedFlow
- MutableSharedFlow
- MutableStateFlow
- What is Channel
- https://proandroiddev.com/kotlin-flows-in-android-summary-8e092040fb3a
- 