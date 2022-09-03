package com.swasi.play.coroutines.context

import kotlinx.coroutines.*

fun main()  {
    testCoroutineName()
}

fun testCoroutineName() {
    runBlocking {
        launch(CoroutineName("My-Own-Coroutine")) {
            println(coroutineContext)
        }
    }
}