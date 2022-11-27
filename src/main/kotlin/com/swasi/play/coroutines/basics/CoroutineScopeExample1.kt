package com.swasi.play.coroutines.basics

import kotlinx.coroutines.*

fun main() = runBlocking {

}

suspend fun showSomeData() = coroutineScope {
    val data = async(Dispatchers.IO) { // <- extension on current scope
//        ... load some UI data for the Main thread ...thread
    }

    withContext(Dispatchers.Main) {
//        doSomeWork()
        val result = data.await()
//        display(result)
    }
}