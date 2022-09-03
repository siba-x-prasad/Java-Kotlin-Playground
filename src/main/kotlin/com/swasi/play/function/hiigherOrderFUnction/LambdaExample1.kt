package com.swasi.play.function.hiigherOrderFUnction

fun main() {
    higherOrderFunctionWithoutParameterButReturnType(lambdaWithoutParameterButReturnType)

    higherOrderFunctionWithNoReturnTypeNoParameterLambda(lambdaNoParameterNoReturnType)

    higherOrderFunctionWithParameterButNoReturnType(lambdaWithParameterButNoReturnType)

    higherOrderFunctionCallingLambdaWithInputAndReturnType(12, 23, lambdaWithInputAndReturnType)
}

val lambdaWithoutParameterButReturnType: () -> String = {
    "My Name is Sibaprasad"
}

private fun higherOrderFunctionWithoutParameterButReturnType(lambda: () -> String) {
    val result = lambda()
    println("Return result from Lamnda is -> $result")
}

val lambdaNoParameterNoReturnType: () -> Unit = {
    print("Printing Lambda  without parameter and  without return type")
}

private fun higherOrderFunctionWithNoReturnTypeNoParameterLambda(lambda: () -> Unit) {
    lambda()
}

val lambdaWithParameterButNoReturnType: (Int, String) -> Unit = { integerInput, stringInput ->
    println("My Name is $stringInput & my Age is $integerInput")
}

private fun higherOrderFunctionWithParameterButNoReturnType(lambda: (Int, String) -> Unit) {
    // calling lambda
    lambda(33, "Sibaprasad")
}

val lambdaWithInputAndReturnType: (Int, Int) -> Int = { input1, input2 ->
    input1 + input2
}

private fun higherOrderFunctionCallingLambdaWithInputAndReturnType(
    input1: Int,
    input2: Int,
    lambda: (Int, Int) -> Int
) {
    val result = lambda(input1, input2)
    println("Sum of $input1 & $input2 is $result")
}