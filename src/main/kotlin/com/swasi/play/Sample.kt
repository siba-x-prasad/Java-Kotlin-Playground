package com.swasi.play

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    for (i in 1..5) {
        println(i)
        myDelay(i)
    }
}

suspend fun myDelay(inputTime: Int) {
    delay(inputTime * 1000L)
}