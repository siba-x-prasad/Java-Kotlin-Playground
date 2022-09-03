package com.swasi.play.coroutines.jobs

import kotlinx.coroutines.*


/**
 * To better manage a Coroutine, a job is provided when we launch (or async etc).
 *
 */
fun main() = runBlocking {
    val job = launch {
        try {
            println("launch job")
            delay(1000)
            println("finish job")
        } catch (e: CancellationException) {
            println("cancel job")
        }
    }
    yield() // to start the launch
    job.cancel()
}