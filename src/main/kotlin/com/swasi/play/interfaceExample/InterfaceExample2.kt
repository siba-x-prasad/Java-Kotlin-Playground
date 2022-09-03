package com.swasi.play.interfaceExample

fun main() {

    // by using interface reference
    val interfaceReference = object : InterfaceWithLambda {
        override fun addition(num1: Int, num2: Int): Int {
            return num1 + num2
        }
    }

    val result = interfaceReference.addition(5, 6)
    println("Sum of 5 & 6 is $result")
    interfaceReference.printMyName("Kotlin")

    // now converting functional interface to lambda and calling
    val interfaceToLambda: (Int, Int) -> Int = { num1, num2 -> num1 + num2 }
    val result1 = interfaceToLambda(5, 6)
    println("Sum of 5 , 6 using lambda $result1")

}

interface InterfaceWithLambda {
    fun addition(num1: Int, num2: Int): Int
    fun printMyName(name: String) {
        println("Hello $name")
    }
}