package com.swasi.play.collectionsExample

fun main() {
    val map = mapOf<String, String>("siba" to "Name", "Prasad" to "name2")
    val mutableMap = mutableMapOf<String, String>("siba" to "Name", "Prasad" to "name2")
    mutableMap.put("Hi","Hellp")

    mutableMap.forEach {
        println("KEY ${it.key} VALUE = ${it.value}")
    }
}