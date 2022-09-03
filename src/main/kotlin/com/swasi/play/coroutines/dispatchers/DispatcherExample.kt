package com.swasi.play.coroutines.dispatchers

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield

/**
 * Dispatcher
 *
 * Like thread, coroutine can be dispatch in different processes to alleviate the Main thread from needing to perform all the processing.
   We use Dispatchers as a parameter to our coroutine launcher (e.g. launch, async, runBlocking)
  as a flag to indicate which processes we like it to be dispatched into.
  Note, dispatcher is also a type of Coroutine Context. e.g. launch(Dispatchers.Main)
 *
 * Dispatchers.Main
    this is the main Thread. Unlike the others, sometimes we have to explicitly define it (e.g. in Test Environment).

  Dispatchers.IO,
    this for the Networking and Disk process. Anything to do with data pulling or pushing.

  Dispatchers.Default,
    this is for any other worker thread that is not Main (i.e. background), and it is automatically assigned.

  Dispatcher.Unconfined,
    this is a special dispatcher that allows the task to change its targeted processes when it suspends and resumes its task.

  newSingleThreadContext,
    allow the user to define its own processes. One has to manually close it after using it.
 *
 */

fun main() = runBlocking(Dispatchers.IO) {

    println("runBlocking pre-yield ${Thread.currentThread()}")

//    launch(Dispatchers.Main) {
//        println(" Dispatchers.Main launch pre-yield ${Thread.currentThread()}")
//        yield()
//        println(" Dispatchers.Main launch pos-yield ${Thread.currentThread()}")
//    }

    launch(Dispatchers.IO) {
        println("Dispatchers.IO  launch pre-yield ${Thread.currentThread()}")
        yield()
        println("Dispatchers.IO launch pos-yield ${Thread.currentThread()}")
    }

    launch(Dispatchers.Default) {
        println("Dispatchers.Default launch pre-yield ${Thread.currentThread()}")
        println("Dispatchers.Default launch pos-yield ${Thread.currentThread()}")
    }

    launch {
        println("Parameter less launch pre-yield ${Thread.currentThread()}")
        println("Parameter less launch pos-yield ${Thread.currentThread()}")
    }

    yield()
    println("runBlocking pos-yield ${Thread.currentThread()}")
}