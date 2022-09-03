package com.swasi.play.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


/**
 In addition to the coroutine scope provided by different builders,
 it is possible to declare your own scope using the coroutineScope builder.
 It creates a coroutine scope and does not complete until all launched children complete.

 runBlocking and coroutineScope builders may look similar because they both wait for their body and all its children to complete.
 The main difference is that the runBlocking method blocks the current thread for waiting,
 while coroutineScope just suspends, releasing the underlying thread for other usages.
 Because of that difference, runBlocking is a regular function and coroutineScope is a suspending function.

You can use coroutineScope from any suspending function.
 For example, you can move the concurrent printing of Hello and World into a suspend fun doWorld() function:
 */
fun main() = runBlocking {
    doWorld1()
}

suspend fun doWorld1() = coroutineScope {  // this: CoroutineScope
    launch {
        delay(1000L)
        println("World!")
    }
    println("Hello")
}