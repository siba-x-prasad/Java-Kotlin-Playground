package com.swasi.play.coroutines.context

import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

/**
 * Sometimes, we would like to have our coroutine switching between the Context,
 * while being in the same coroutine.
 * We can do so using withContext to do so.
 */

fun main() {
    testSwitchContext()
}


fun testSwitchContext() {
    newSingleThreadContext("Ctx1").use { ctx1 ->
        newSingleThreadContext("Ctx2").use { ctx2 ->
            runBlocking(ctx1) {
                println("Started in ctx1 $coroutineContext")
                withContext(ctx2) {
                    println("Working in ctx2 $coroutineContext")
                }
                withContext(ctx1) {
                    println("Working in ctx1 $coroutineContext")
                }
                println("Back to ctx1 $coroutineContext")
            }
        }
    }
}