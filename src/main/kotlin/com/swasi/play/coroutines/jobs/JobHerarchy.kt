package com.swasi.play.coroutines.jobs

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Job can be hierarchical
 * If a launch is triggered in another coroutine (under the same scope context),
 * the job of the launch will be made the child job of the coroutine.
 *
 * When parent job cancel, children’s jobs are canceled as well.
 *However, if we cancel the child’s job, the parent’s job continues on.
 */

fun main() = runBlocking {
    val parentJob = launch {
        try {
            println("launch parent job")
            val childJob = launch {
                try {
                    println("launch child job")
                    delay(1000)
                    println("finish child job")
                } catch (e: CancellationException) {
                    println("cancel child job")
                }
            }
            delay(500)
            childJob.cancel()
            delay(500)
            println("finish parent job")
        } catch (e: CancellationException) {
            println("cancel parent job")
        }
    }
    delay(500)
//    parentJob.cancel()
}

/**
 * OUTPUT
 *
 *launch parent job
launch child job
cancel child job
cancel parent job
 */