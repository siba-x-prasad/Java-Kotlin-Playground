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



