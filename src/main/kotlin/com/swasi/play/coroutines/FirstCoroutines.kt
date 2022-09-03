package com.swasi.play.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


/**
 * Created by Sibaprasad Mohanty on 01/05/2022.
 * siba.x.prasad@gmail.com
 */

/**
 * A coroutine is an instance of suspendable computation.
 * It is conceptually similar to a thread, in the sense that it takes a block of code to run that works concurrently with the rest of the code.
 * However, a coroutine is not bound to any particular thread. It may suspend its execution in one thread and resume in another one.
 * Coroutines can be thought of as light-weight threads, but there is a number of important differences that make their real-life usage very different from threads.
Run the following code to get to your first working coroutine:
 */


fun main() = runBlocking { // this: CoroutineScope
    launch { // launch a new coroutine and continue
        println("Inside Launch") // print after delay
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
    }
    println("Hello") // main coroutine continues while a previous one is delayed
}

/**
 * launch{ }
 * launch is a coroutine builder.
 * It launches a new coroutine concurrently with the rest of the code, which continues to work independently.
 * That's why Hello has been printed first.
 *
 * delay()
 * delay is a special suspending function.
 * It suspends the coroutine for a specific time.
 * Suspending a coroutine does not block the underlying thread, but allows other coroutines to run and use the underlying thread for their code.
 *
 * runBlocking{}
 * runBlocking is also a coroutine builder that bridges the non-coroutine world of a regular fun main() and the code with coroutines inside of runBlocking { ... } curly braces.
 * This is highlighted in an IDE by this: CoroutineScope hint right after the runBlocking opening curly brace.
 *
 * If you remove or forget runBlocking in this code,
 * you'll get an error on the launch call, since launch is declared only in the CoroutineScope:
 *
 * Unresolved reference: launch
 *
 * The name of runBlocking means that the thread that runs it
 * (in this case — the main thread) gets blocked for the duration of the call,
 * until all the coroutines inside runBlocking { ... } complete their execution.
 * You will often see runBlocking used like that at the very top-level of the application and quite rarely inside the real code, as threads are expensive resources and blocking them is inefficient and is often not desired.
 */







