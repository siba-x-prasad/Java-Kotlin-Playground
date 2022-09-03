package com.swasi.play.coroutines.context

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Exception Handling can be done by passing CoroutineExceptionHandler in coroutine builder
 *
 */

fun main() {
    testCoroutineExceptionHandler()
}


fun testCoroutineExceptionHandler() {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("CoroutineExceptionHandler got $exception")
    }

    runBlocking {
        MainScope().launch(handler) {
            launch {
                throw IllegalAccessException("Just testing")
            }
        }.join()
    }
}

/**
 * OUTPUT
 *
 * CoroutineExceptionHandler got java.lang.IllegalStateException: Module with the Main dispatcher is missing.
 *
 */
