package com.swasi.play.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 *
 * A coroutineScope builder can be used inside any suspending function to perform multiple concurrent operations.
 * Let's launch two concurrent coroutines inside a doWorld suspending function:
 *
 */


// Sequentially executes doWorld followed by "Done"
fun main() = runBlocking {
    doWorld2()
    println("Done")
}

// Concurrently executes both sections
suspend fun doWorld2() = coroutineScope { // this: CoroutineScope
    launch {
        delay(2000L)
        println("World 2")
    }
    launch {
        delay(1000L)
        println("World 1")
    }
    println("Hello")
}

/**
 * Both pieces of code inside launch { ... } blocks execute concurrently,
 * with World 1 printed first, after a second from start,
 * and World 2 printed next, after two seconds from start.
 * A coroutineScope in doWorld completes only after both are complete,
 * so doWorld returns and allows Done string to be printed only after that:

OUTPUT

Hello
World 1
World 2
Done
 */