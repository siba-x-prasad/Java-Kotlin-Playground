package com.swasi.play.coroutines.composingSuspendFunction

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

/**
 * Optionally, async can be made lazy by setting its start parameter to CoroutineStart.LAZY.
 * In this mode it only starts the coroutine when its result is required by await,
 * or if it's Job's start function is invoked. Run the following example:
 */
fun main() = runBlocking{
    val time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
        val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
        // some computation
        one.start() // start the first one
        two.start() // start the second one
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
}

/**
 * OUTPUT
 *
 * The answer is 42
    Completed in 1017 ms
 */