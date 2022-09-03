package com.swasi.play.coroutines.jobs

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * IF error occur in child job, then parent job also cancelled
 */
fun main() = runBlocking {
    val parentJob = launch {
        try {
            println("launch parent job")
            val childJob = launch {
                try {
                    println("launch child job")
                    delay(500)
                    throw Exception()
                } catch (e: CancellationException) {
                    println("cancel child job")
                }
            }
            delay(1000)
            println("finish parent job")
        } catch (e: CancellationException) {
            println("cancel parent job")
        }
    }
}

/**
 * OUTPUT

    launch parent job
    launch child job
    cancel parent job
 */



/**
 * IF parent job error occur, then  child job is also got cancelled.
 *

runBlocking {
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
            throw Exception()
            println("finish parent job")
        } catch (e: CancellationException) {
            println("cancel parent job")
        }
    }
}

launch parent job
launch child job
cancel child job

 */