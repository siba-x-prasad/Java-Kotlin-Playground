package com.swasi.play.interfaceExample

fun main() {
    // Creating an instance of a class
    val isEven = object : IntPredicate {
        override fun accept(i: Int): Boolean {
            return i % 2 == 0
        }
    }

    // the above can be converted to lambda
    val isEvenLambda = IntPredicate { i -> i % 2 == 0 }

    val input = 4
    val result  = isEven.accept(input)
    println("Is $input even : $result")
}

// Only one abstract method in an interface is known as functional interface
fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

// Interface can have val, variables without initialization, concrete methods(With  function body), abstract  methods
// property can not be initialized inside interface
interface KotlinInterface{
    var age : Int
    val name: String
    private fun printName(){
        println("My name is $name")
    }
    fun abstractMethod1()
    fun abstractMethod2()

}