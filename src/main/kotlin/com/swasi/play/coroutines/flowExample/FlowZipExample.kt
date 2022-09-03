package spm.kotlin.world.coroutines.flowExample

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking


/**
 * Created by Sibaprasad Mohanty on 06/05/2022.
 * siba.x.prasad@gmail.com
 */

fun main() = runBlocking {
    val flow = flowOf(1, 2, 3).onEach { delay(10) }
    val flow2 = flowOf("a", "b", "c", "d").onEach { delay(15) }
    flow.zip(flow2) { i, s -> i.toString() + s }.collect {
        println(it)
    }
}