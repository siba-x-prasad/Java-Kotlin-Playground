package com.swasi.play.coroutines.context

import kotlinx.coroutines.*
import kotlin.coroutines.Continuation
import kotlin.coroutines.ContinuationInterceptor
import kotlin.coroutines.CoroutineContext

/**
 * Continuation Interceptor
    The Continuation Interceptor allows one to define how coroutines should continue.
 */

fun main() {
    testContinuationInterceptor()
}

fun testContinuationInterceptor() {
    val interception = object: ContinuationInterceptor {
        override val key: CoroutineContext.Key<*>
            get() = ContinuationInterceptor

        override fun <T> interceptContinuation(
            continuation: Continuation<T>
        ): Continuation<T> {
            println("  ## Interception Setup for${continuation.context[Job]} ##")
            return Continuation(continuation.context) {
                println("  ~~ Interception for {continuation.context[Job]} ~~")
                continuation.resumeWith(it)
            }
        }
    }

    runBlocking(CoroutineName("runBlocker") + interception) {
        println("Started runBlocking")
        launch(CoroutineName("launcher")) {
            println("Started launch")
            delay(10)
            println("End launch")
        }
        delay(10)
        println("End runBlocking")
    }
}

/**
 * OUTPUT
 *
 *   ## Interception Setup forBlockingCoroutine{Active}@5700d6b1 ##
~~ Interception for {continuation.context[Job]} ~~
Started runBlocking
## Interception Setup forStandaloneCoroutine{Active}@71318ec4 ##
~~ Interception for {continuation.context[Job]} ~~
Started launch
End launch
~~ Interception for {continuation.context[Job]} ~~
End runBlocking
 */
