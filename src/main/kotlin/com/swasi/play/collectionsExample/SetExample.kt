package com.swasi.play.collectionsExample

fun main() {
    val set = setOf<String>("Siba", "Prasad")
    println("Iterate Set in Kotlin")
    set.forEach {
        println(it)
    }

    println("Mutable Set in Kotlin")
    val mutableSetOf = mutableSetOf<String>()
    mutableSetOf.add("Siba")
    mutableSetOf.add("Prasad")
    mutableSetOf.add("Siba")
    println("Iterate Mutable Set in Kotlin")
    mutableSetOf.forEach {
        println(it)
    }
}