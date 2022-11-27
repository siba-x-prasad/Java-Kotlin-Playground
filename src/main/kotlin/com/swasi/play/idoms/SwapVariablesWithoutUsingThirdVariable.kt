package com.swasi.play.idoms

fun main() {
    var a = 1
    var b = 2

    println("a =$a b = $b")
    a = b.also { b = a }
    println("after swap a =$a b = $b")

}