package com.swasi.play.delegatesInKotlin

import kotlin.properties.Delegates

fun main(args: Array<String>) {

    val eagle = Eagle(23)
    eagle.flyAndFindFood()

    val cuckoo = Cuckoo(eagle)
    cuckoo.flyAndFindFood()

    // delegation
    val user = UserDelegation()
    user.name = "Hello"
    user.name = "Hello World"
}

interface BirdInterface {
    fun flyAndFindFood()
}

class Eagle(val age: Int) : BirdInterface {
    override fun flyAndFindFood() {
        println("I am an eagle of age $age i am flying and finding food")
    }
}

class Cuckoo(b: BirdInterface) : BirdInterface by b {
    override fun flyAndFindFood() {
        println("I am an Cockoo and i am flying and finding food")
    }
}

class UserDelegation {
    var name: String by Delegates.observable("Welcome to Tutorialspoint.com") { prop, old, new ->
        println("$old -> $new")
    }
}