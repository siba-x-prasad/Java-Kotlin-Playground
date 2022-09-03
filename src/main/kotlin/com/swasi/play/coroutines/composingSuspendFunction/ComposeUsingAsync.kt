package com.swasi.play.coroutines.composingSuspendFunction

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 *
 */

fun main()  = runBlocking {
    val time = measureTimeMillis {
        val one = async { doSomething1() }
        val two = async { doSomething2() }
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}

suspend fun doSomething1() :  Int{
    delay(1000)
    return 13
}

suspend fun doSomething2() :  Int{
    delay(1000)
    return 13
}