package com.swasi.play.nullpointer_handling


/**
 * In Kotlin, the type system distinguishes between references that can hold null (nullable references)
 * and those that can not (non-null references).
 *  For example, a normal property can’t hold a null value and will show a compile error.
 *
 * var variable : CustomClass = CustomClass()
 * variable = null //compilation error
 *
 * Instead, we can add a ? after the data type of that property which declares that variable as a nullable property
 * var nullableVariable : CustomClass? = CustomClass()
 * nullableVariable = null //works fine
 *
 * In any case, the nullable property requires a null check every time before utilizing that property or
 * requires a confirmation from the developer that the estimation of that property won’t be null
 * while utilizing it
 *
 * variable.someMethodCall() //works fine as the compiler is sure that
//the variable can’t be null nullableVariable.someMethodCall()
//will highlight compilation error
//as compiler is not sure as nullVariable can be null.
 *
 */

object NullPointerMain {
    @JvmStatic
    fun main(args: Array<String>) {
        handleNullPointerUsingSafeCall()
        hanelNullPointerHandlingUsingAssertion()
        handleNullPointerUsingElvisOperator()
        handleNullPointerUsingElvisOperatorWithIfElse()
        handleNullPointerUsingLetOperator()
        filterOutNullValue()
    }


    private fun handleNullPointerUsingSafeCall() {
        println("handleNullPointerUsingSafeCall")
        val name: String? = null
        val length = name?.length
        println("Length of $name is $length")

        // lets handle in another way using elvis operattor
        val length1 = name?.length ?: 0
        println("Length of $name is $length1")
    }

    /**
     * The !! Operator
    This operator is used to explicitly tell the compiler that the property is not null
    and if it’s null, please throw a null pointer exception (NPE)

    nullableVariable!!.someMethodCall()

     */
    private fun hanelNullPointerHandlingUsingAssertion() {
        print("hanelNullPointerHandlingUsingAssertion")
        var name: String? = null
//        val length = name!!.length // this will throw Exception in thread "main" java.lang.NullPointerException
//        println("Length of $name is $length") // this will not execute
        // handle tthis like below
        val lengthNew = try {
            println("Name is not null and lengtht is ${name!!.length}")
            name!!.length
        } catch (e: java.lang.Exception) {
            println("Name is  null and length is 0")
            0
        }
    }

    // ELVIS OPERATOR
    /**
     * Elvis Operator (?:)
    This one is similar to safe calls except the fact that it can return a non-null value if the calling
    property is null even
    val result = nullableVariable?.someMethodCall()?: fallbackIfNullMethodCall()
     */
    //When we have a nullable reference r, we can say "if r is not null, use it, otherwise use some non-null value x":
    private fun handleNullPointerUsingElvisOperator() {
        print("handleNullPointerUsingElvisOperator ?. ?:")
        val a = "Kotlin"
        val b: String? = null
        println(b?.length)
        println(a?.length)

        val l = b?.length ?: -1
        val l1 = b?.length ?: {
            println("b is null")
            -1
        }
        print(l)
        print(1)
    }

    private fun handleNullPointerUsingElvisOperatorWithIfElse() {
        print("handleNullPointerUsingElvisOperatorWithIfElse")
        var b: String? = "abcd"
        val l1: Int = if (b != null) b.length else -1
        b = null
        val l2: Int = if (b != null) b.length else -1

        print("Length of b When null value $l2")
        print("Length of b When not null value $l2")
    }

    private fun handleNullPointerUsingLetOperator() {
        println("handleNullPointerUsingLetOperator")
        var name: String? = null
        var length = name?.let {
            it.length
        } ?: 0

        println("Length of null is $length")

        name = "Hello Kotlin"
        length = name?.let {
            it.length
        } ?: 0
        println("Length of $name is $length")
    }

    /**
     * There are few ready-made methods to handle null in list
     */
    fun filterOutNullValue() {
        println("Filter out non null values")
        val nullableList: List<Int?> = listOf(1, 2, null, 4)
        val intList: List<Int> = nullableList.filterNotNull()
    }

    fun nullPointerHandlingWithSafeOperation(node: String): String? {
        val parent = node.plus("Sibaprasad") ?: return null
        val name = node.plus("asvav") ?: throw IllegalArgumentException("name expected")
        return name;
    }

}