# Kotlin Keywords

- in
- !in
- as
- as?
- is
- is?
- for
- while
- whe
- step
- elvis Operator => ?:  (a?.length ?: 0)

## Delegation

- https://kotlinlang.org/docs/delegation.html
- Kotlin supports “delegation” design pattern by introducing a new keyword “by”.
- Using this keyword or delegation methodology, Kotlin allows the derived class to access all the
  implemented public methods of an interface through a specific object.

```
    var p: String by Delegate()
    
    val myVar: String by lazy {
       "Hello"
    }
    
    var name: String by Delegates.observable("Welcome to Tutorialspoint.com") {
      prop, old, new ->
      println("$old -> $new")
   }
```