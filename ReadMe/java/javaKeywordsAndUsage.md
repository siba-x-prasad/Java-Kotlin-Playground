# Java Keywords and Their Usage
1). 🧮 Data Types
     Keyword	Description
1.    byte	    8-bit integer type
2.    short	    16-bit integer type
3.    int	    32-bit integer type
4.    long	    64-bit integer type
5.    float	    32-bit floating-point type
6.    double	64-bit floating-point type
7.    char	    16-bit Unicode character
8.    boolean	Represents true or false values
9.    void	    Specifies that a method does not return a value

2). 🔁 Control Flow
- Keyword	Description
- if	    Executes a block if a condition is true
- else	    Executes a block if the condition in if is false
- switch	Allows multiple conditional branches
- case	    Defines a branch in a switch statement
- default	Defines the default branch in a switch
- while	    Loops while a condition is true
- do	    Executes a loop body before checking condition
- for	    Used for looping a specific number of times
- break	    Exits from a loop or switch statement
- continue	Skips to the next iteration of a loop
- return	Exits a method and optionally returns a value
3. ⚙️ Modifiers
- Keyword	   Description
- public	   Accessible from any other class
- private	   Accessible only within the same class
- protected	   Accessible within the package and subclasses
- static	   Belongs to the class rather than an instance
- final	       Used for constants, prevents inheritance or overriding
- abstract	   Defines abstract classes or methods (must be implemented by subclasses)
- synchronized Ensures thread safety for methods or blocks
- native	   Indicates a method is implemented in native (non-Java) code
- transient	   Prevents serialization of a variable
- volatile	   Indicates a variable’s value may change unexpectedly (thread-related)
4. ⚠️ Exception Handling
- Keyword	Description
- try	    Defines a block of code to test for exceptions
- catch	    Handles exceptions thrown by try block
- finally	Block that always executes (cleanup code)
- throw	    Used to explicitly throw an exception
- throws	Declares exceptions a method might throw
5. 🧱 Classes, Objects, and Methods
- Keyword	Description
- class	    Defines a class
- interface	Defines an interface
- enum	    Defines an enumeration
- new	    Creates new objects
- this	    Refers to the current instance of a class
- super	    Refers to the parent class or constructor
6. 🧬 Inheritance and Polymorphism
- Keyword	  Description
- extends	  Indicates inheritance from a superclass
- implements  Used by a class to implement an interface
- instanceof  Tests whether an object is an instance of a specific class
7. 📦 Packages and Imports
- Keyword	Description
- package	Defines a namespace (group of related classes)
- import	Imports other Java packages or classes
8. 🔢 Literals and Constants
- Keyword	Description
- true	    Boolean literal for truth
- false	    Boolean literal for falsehood
- null	    Represents the absence of a reference
9. ⏱️ Multithreading
- Keyword	    Description
- synchronized	Used to lock an object for thread safety
- volatile	    Indicates a variable is shared across threads
10. ⚙️ Other Keywords
- Keyword	Description
- assert	Used for debugging; tests assumptions in code
- default	Specifies default method in interface (Java 8+)
- record	Defines a compact data carrier class (Java 14+)
- sealed	Restricts which classes can extend or implement a class/interface (Java 15+)
- permits	Used with sealed to specify allowed subclasses
- var	    Implicitly infers local variable types (Java 10+)
- yield	    Used in switch expressions to return a value (Java 14+)