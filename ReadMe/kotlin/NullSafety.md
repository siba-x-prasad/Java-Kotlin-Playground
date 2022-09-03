# Null Safety
1) Safe Call Operator( ?. )
2) Not-Null Assertion( !! )
3) Elvis Operator( ?: )
4) Safe Call with let ( ?.let{...} )

- **Safe Call Operator( ?. )**:Checks if the property is not null before performing any operations.
- **Not-Null Assertion( !! )** : Explicitly tells the compiler that the property is not null and if it’s null, please throw a null pointer exception (NPE)
- **Elvis Opeartor( ?: )**: It's like ternary operator in java. If property is not null then left expression is returned otherwise right.
- **Safe Call with let ( ?.let{...} )**: It will execute the let block only if property is not null

## Safe call Operator (?.let)
- If we use safe call operator on a variable, if it's not null, then only the expression will be executed
```
var name : String ? = null
val length = name?.length
```


## How to handle Null using let operator
```
var myName : String? = null

myName?.let {
            println("My Name is $myName")
        } ?: println("My Name is Null")
```
- In the  above case if myName is null then it will go inside the block else it will print the statement after elvis operator.

## **? and !! operator**
- We can declare any variable using **?** and **!!** operator or without using any operator at all.
- **var a:String? ="abc"**, when we declare any variable with ? operator, this means , the variable can be null anytime. We use ? operator for null safety. We have to assign value to the variable we declare with ? and also have to define the datatype of the variable. Otherwise it will show compile time error.
- ```print(a?.length())``` - if a is null , it will print nothing
- Else it will print the length of the string
- At the compile time, the compiler force us to handle the null pointer while doing any operation on the null values like
- when we declare any variable like , question mark after the Datatype. that means you are saying that the value may be null some time.
```var a:String? ="abc"```
- here we are saying the compiler that the variable a can hold null.When we will do any operation on the variable a, the compiler will show compilertime error to handle null pointer exception.
```
println(a.length)  // it will show compile time error that the value can be null
println(a!!.length) // it will not show any error now, because we handle Null pointer exceptin
```
- In the above case if a is null, it will through null pointer exception. If we handle using try cache, it will be okay else it will crash.
```
fun parseInt(str: String): Int? {
    // ...
}
```
- This function explains that the return type can be null, so you have to handle
## variable without ? operator
```
var a:String = "SIba"
a = null// it will show compile time error saying that the variable can be null.
```
## Use of !! - null assertion operator (!!)**
- The third option is for NPE-lovers: the not-null assertion operator (!!) converts any value to a non-null type and throws an exception if the value is null.
- We can write b!!, and this will return a non-null value of b (e.g., a String in our example) or throw an NPE if b is null:
 - ```val l = b!!.length```
- Thus, if you want an NPE, you can have it, but you have to ask for it explicitly, and it does not appear out of the blue.
## late init
- when we declare any variable as lateinit, this means the variable will be initialize later.
- If the variable is not assigned any value and we trying to use the variable, it will show runtime error. that is lateinit property variableName has not been initialized
- Here is how to declare lateinit variable
```
lateinit var name1:String
```
- here is the example how to use it
```
println(name1.length) // it will show runtime error , that the variable is not initialized or assigned any value
name1 = "Sibaprasad"
println(name1.length)  // it will print the length of the variable without any error. because this variable is assigned value later with "Sibaprasad"
```

