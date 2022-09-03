package com.swasi.play.coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {
    repeat(100_000) { // launch a lot of coroutines
        launch {
            delay(5000L)
            print("=>")
        }
    }
    repeat(100_000) { // launch a lot of coroutines
        launch {
            delay(5000L)
            print("*")
        }
    }
}