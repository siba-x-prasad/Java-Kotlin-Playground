package com.swasi.play.coroutines.basics

import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    GlobalScope.launch { // launch a new coroutine in background and continue
        delay(1000L)
        println("World!")
    }
    println("Hello,") // main thread continues here immediately
    runBlocking {     // but this expression blocks the main thread
        delay(5000L)  // ... while we delay for 2 seconds to keep JVM alive
    }
    print("Siba")
}
// OUTPUT
/**
 * Hello,
 * world!
 * siba
 */