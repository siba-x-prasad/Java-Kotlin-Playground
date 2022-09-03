package com.swasi.play.coroutines.context

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.runBlocking

/**
 * If you observe the code above carefully, you’ll notice this line

runBlocking(CoroutineName("runBlocker") + interception)
 */

fun main() {
    runBlocking(
        CoroutineName("Drop Name") +
            CoroutineName("Taken Name")){

    }
}