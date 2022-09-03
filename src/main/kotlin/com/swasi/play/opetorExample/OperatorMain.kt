package com.swasi.play.opetorExample

object OperatorMain {

    @JvmStatic
    fun main(args: Array<String>) {
//        operator10()
//        operator11()

        useOfLazy()

        useOfLet()

        useOfRun()

        useOfAlso()

        useOfApply()

        useOfWith()

        funUseof_is_as()

        // Collections Operators
        useOfFIlter()
        useOfMap()
        useOfZip()
        useOfAssociate()
        useOfFlatten()
        stringRepresentationOfList()
        // we will get to know different type of operator

    }

    // as
    fun funUseof_is_as() {

        var obj = "siba"

        if (obj is String) {
            print(obj.length)
        }

        if (obj !is String) { // same as !(obj is String)
            print("Not a String")
        } else {
            print(obj.length)
        }


        if (obj !is String) return
        print(obj.length) // x is automatically cast to String

        // use of AS

        val x: String

    }

    // in
    fun operator7() {
        var obj: Any = 123
        when (obj) {
            in 1..6 -> {
                print("its between 1 o 6")
            }
            is Int -> print(1 + 1)
            is String -> print("asdasd")
            is IntArray -> print("asdasda")
        }
    }

    // ===
    fun operator8() {
        val a: Int = 10000
        println(a === a) // Prints 'true'
        val boxedA: Int? = a
        val anotherBoxedA: Int? = a
        println(boxedA === anotherBoxedA) // !!!Prints 'false'!!!
    }

    // ==
    fun operator9() {
        val a: Int = 10000
        println(a == a) // Prints 'true'
        val boxedA: Int? = a
        val anotherBoxedA: Int? = a
        println(boxedA == anotherBoxedA) // Prints 'true'
    }

    // is
    fun operator10() {
        val a = "sibaprasad"

        println("a is String = ${a is String}") // Prints 'true'
        // println("a is String = ${a is Int}") // Prints false
    }

    // @loop
    fun operator11() {
        loopouter@ for (i in 1..10) {

            innerLoop@ for (j in 1..5) {
                if (i == 8) {
                    break@loopouter
                } else if (j == 3) {
                    break@innerLoop
                }
                if (j == 2) {
                    continue@innerLoop
                }
                println("$i ${j}")
            }

        }
    }

    fun useOfDelegate() {
        println("============use of Delegate==========")
        //  var p: String by Delegates()

    }


    /**
     *
     */
    private fun useOfLazy() {
        println("============use of lazy==========")
        val lazyValue: String by lazy {
            println("computed!")
            "Hello"
        }
        println(lazyValue)
    }
// computed
// Output =  Hello


    /**
     * let
    let is a non-monadic version of map:
    It accepts objects as parameters and returns the result of the lambda.
    Super-useful for conversions:

    - > It doesnot change the object, it only return the value that applied condition
     */

    private fun useOfLet() {
        println("========== use of LET ==============")
        val person = Person("Edmund", 42)
        println(person)
        val result = person.let { it.age * 2 }
        println(person)
        println(result)
    }
    /** OUTPUT
     * Person(name=Edmund, age=42)
    Person(name=Edmund, age=42)
    84
     */

    /**
     * run
    run is another com.swasi.play.function literal with receiver.
    It is used with lambdas that do not return values,
    but rather just create some side-effects:
     */

    private fun useOfRun() {

        println("==========use of RUN==============")

        val person = Person("Edmund", 42)
        val result = person.run { age * 2 }
        println(person)
        println(result)
    }
    /** OUTPUT
     * Person(name=Edmund, age=42)
    84
     */

    /**
     * also
    With this com.swasi.play.function, you say “also do this with the object.”
    I often use it to add debugging to the call chains or to do some additional processing:
     */

    private fun useOfAlso() {
        println("==========use of ALSO==============")
        val person = Person("Edmund", 42)
        println(person)
        val result = person.also { person ->
            person.age = 50
            person.name = person.name.capitalize()
        }
        println("After apply ALso Operator , result is $result")
        println("After apply ALso Operator , the object is $person")
    }
    /** OUTPUT
     *  Person(name=Edmund, age=42)
    After apply ALso Operator , result is Person(name=Edmund, age=50)
    After apply ALso Operator , the object is Person(name=Edmund, age=50)
     */

    /**
     * apply
    apply is used for post-construction configuration.
    It is a com.swasi.play.function literal with receiver: The object is not passed as a parameter,
    but rather as this.
    An object passed in such way is called the receiver.
     */

    private fun useOfApply() {
        println("==========use of APPLY==============")
        val person = Person("Edmund", 42)
        println(person)
        val result = person.apply { age = 50 }
        println("After apply " + person)
        println("The Result " + result)
    }

    /** OUTPUT
     *  Person(name=Edmund, age=42)
    After apply Person(name=Edmund, age=50)
    The Result Person(name=Edmund, age=50)
     */

    /**
     * with
    According to Kotlin idioms, with should be used to call multiple methods on an object.
     */

    private fun useOfWith() {
        println("==========use of WITH==============")
        val person = Person("Edmund", 42)
        val result = with(person) {
            age * 2
        }
        println(person)
        println(result)
    }

    /** OUTPUT
     *
     * Person(name=Edmund, age=42)
    84
     */
    private fun useOfFIlter() {
        println("==========use of FILTER==============")
        val originalMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3)

        val filteredMap = originalMap.filter { it.value < 2 }

        println(filteredMap) // {key1=1}
        // original map has not changed
        println(originalMap) // {key1=1, key2=2, key3=3}
    }

    private fun useOfMap() {
        println("==========use of Map==============")

        val list1 = listOf(1, 2, 3, 4, 5, 6)
        val transform: (Int) -> Int = { it * it }
        val result = list1.map(transform)
        print(result)

        val list = listOf<String>("Siba", "Prasad", "Mohanty")
        val listNames = list.map {
            it + "Hello"
        }
        listNames.forEach {
            println(it)
        }
    }

    private fun useOfZip() {
        println("==========use of Zip==============")
        val colors = listOf("red", "brown", "grey")
        val animals = listOf("fox", "bear", "wolf")

        val combinedResult = colors zip animals
        combinedResult.forEach {
            println(it)
        }
//        println(colors zip animals)

        val twoAnimals = listOf("fox", "bear")
        println(colors.zip(twoAnimals))
    }

    private fun useOfAssociate() {
        println("========== use of associate ==============")
        val numbers = listOf("one", "two", "three", "four")

        println(numbers.associateBy { it.first().uppercaseChar() })

        val result: Map<Char, String> = numbers.associateBy { it.first().uppercaseChar() }

        println(numbers.associateBy(keySelector = { it.first().uppercaseChar() }, valueTransform = { it.length }))
    }

    private fun useOfFlatten() {
        println("========== use of Flatten ==============")
        // combine collection of collections to a list
        val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
        val result: List<Int> = numberSets.flatten()
        result.forEach {
            print(" $it")
        }
    }

    private fun useOfFlatMap() {
        println("========== use of Flat Map ==============")
        val containers = listOf(
            listOf("one", "two", "three"),
            listOf("four", "five", "six"),
            listOf("seven", "eight")
        )
    }

    private fun stringRepresentationOfList() {
        println()
        println("========== String Representation of Collections in Kotlin ==============")

        val numbers = listOf("one", "two", "three", "four")
        println(numbers)
        println(numbers.joinToString())
        val listString = StringBuffer("The list of numbers: ")
        numbers.joinTo(listString)
        println(listString)

        println(numbers.joinToString(separator = " | ", prefix = "start: ", postfix = ": end"))

        val numbersDigit = (1..100).toList()
        println(numbersDigit.joinToString(limit = 10, truncated = "<...>"))

        println(numbers.joinToString { "Element: ${it.uppercase()}"})
    }
}