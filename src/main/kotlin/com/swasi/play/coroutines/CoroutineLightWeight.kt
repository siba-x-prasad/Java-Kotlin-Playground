package com.swasi.play.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.time.LocalDateTime
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

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

fun observeTickerFLow() {
    tickerFlow(5.seconds)
        .map { LocalDateTime.now() }
        .distinctUntilChanged { old, new ->
            old.minute == new.minute
        }
        .onEach {
            //
        }
//        .launchIn(viewModelScope) // or lifecycleScope or other
}

fun tickerFlow(period: Duration, initialDelay: Duration = Duration.ZERO) = flow {
    delay(initialDelay)
    while (true) {
        emit(Unit)
        delay(period)
    }
}
