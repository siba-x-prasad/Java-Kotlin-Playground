package com.swasi.play.coroutines.basics

import kotlinx.coroutines.*


/**
 * Created by Sibaprasad Mohanty on 01/05/2022.
 * siba.x.prasad@gmail.com
 */

fun main() { runBlocking { // this: CoroutineScope
        println("First line inside run blocking")
        launch { doWorld() }
        doWorldWithoutSuspend()
        println("Hello")
    }
}

// this is your first suspending function
suspend fun doWorld() {
    println("Suspend World!1")
    delay(1000L)
    println("Suspend World!")
}

@OptIn(DelicateCoroutinesApi::class)
fun doWorldWithoutSuspend() {
    GlobalScope.launch {
        println("World!1")
        delay(1000L)
        println("World!")
    }
}

/**
 *
First line inside run blocking
Hello
World!1
World!
 */