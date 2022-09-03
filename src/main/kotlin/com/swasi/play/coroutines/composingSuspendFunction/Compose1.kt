package com.swasi.play.coroutines.composingSuspendFunction

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


/**
 * Sequential by default
 *
 * In this case the 2 suspend function is running one after another
 * first doSomethingUsefulOne and later doSomethingUsefulTwo will execute and at the end the result will be combined
 */
fun main() = runBlocking {

    println("The answer is 1 ${doSomethingUsefulOne() + doSomethingUsefulOne()}")

    val time = measureTimeMillis {
        val one = doSomethingUsefulOne()
        val two = doSomethingUsefulTwo()
        println("The answer is ${one + two}")
    }
    println("Completed in $time ms")

}

suspend fun doSomethingUsefulOne(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}