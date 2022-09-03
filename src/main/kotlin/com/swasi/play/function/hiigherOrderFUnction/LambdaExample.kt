package com.swasi.play.function.hiigherOrderFUnction

val lambdaWithNoReturnType = {
    println("This is a lambda expression  without returning any parameter")
}

fun main() {
    callingLambdaWithoutAnyReturnType(lambdaWithNoReturnType)
    callingLambdaWithParameter(lambdaWithParameter)
    callingLambdaWithInputAndReturnType(lambdaWithParameterAndReturnType)
}

private fun callingLambdaWithoutAnyReturnType(lambda: () -> Unit) {
    lambda()
}

val lambdaWithParameter: (Int) -> Unit = { input -> println("My Age is $input") }

private fun callingLambdaWithParameter(lambda: (value: Int) -> Unit) {
    lambdaWithParameter(32)
}

val lambdaWithParameterAndReturnType: (Int, Int) -> Int = { input1, input2 ->
    input1 + input2
}

private fun callingLambdaWithInputAndReturnType(lambda: (Int, Int) -> Int) {
    val input1 = 12
    val input2 = 13
    val result = lambda(input1, input2)
    println("Sum of $input1 & $input1 is $result")
}




