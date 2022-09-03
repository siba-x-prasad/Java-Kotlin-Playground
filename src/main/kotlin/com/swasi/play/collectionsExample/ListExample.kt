package com.swasi.play.collectionsExample

fun main() {
    val listOfNames = listOf<String>("Siba", "Prasad", "Mohanty")
    val listOfNamesMutable = mutableListOf<String>()
    listOfNamesMutable.add("Siba")
    listOfNamesMutable.add("Prasad")
    listOfNamesMutable.add("Mohanty")
    listOfNamesMutable.forEach {
        println(it)
    }

    val numbersIterator = listOfNamesMutable.iterator()
    while (numbersIterator.hasNext()) {
        println(numbersIterator.next())
    }

    val numbers = listOf("one", "two", "three", "four")
    val listIterator = numbers.listIterator()
    while (listIterator.hasNext()) listIterator.next()
    println("Iterating backwards:")
    while (listIterator.hasPrevious()) {
        print("Index: ${listIterator.previousIndex()}")
        println(", value: ${listIterator.previous()}")
    }

    val mutableNumbers = mutableListOf("one", "two", "three", "four")
    val mutableIterator = mutableNumbers.iterator()
    mutableIterator.next()
    mutableIterator.remove()
    println("After removal: $numbers")

    println("=======++SEQUENCE===========")
    val numbers1 = listOf("one", "two", "three", "four")
    val numbersSequence = numbers1.asSequence()
    numbersSequence.forEach {
        println(it)
    }

}