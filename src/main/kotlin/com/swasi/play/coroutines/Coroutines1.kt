package com.swasi.play.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


/**
 * Created by Sibaprasad Mohanty on 01/05/2022.
 * siba.x.prasad@gmail.com
 */

fun main() = runBlocking { // this: CoroutineScope
    println("First line inside run blocking")
    launch { doWorld() }
    println("Hello")
}

// this is your first suspending function
suspend fun doWorld() {
    println("World!1")
    delay(1000L)
    println("World!")
}