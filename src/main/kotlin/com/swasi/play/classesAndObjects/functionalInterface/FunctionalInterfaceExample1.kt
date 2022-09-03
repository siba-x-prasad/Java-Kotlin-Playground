package spm.kotlin.world.classesAndObjects.functionalInterface


/**
 * Created by Sibaprasad Mohanty on 30/04/2022.
 * siba.x.prasad@gmail.com
 */

fun main() {
// Creating an instance of a class
    val isEven = object : IntPredicate {
        override fun accept(i: Int): Boolean {
            return i % 2 == 0
        }
    }

    val isEvenWithLambda = IntPredicate { i -> i % 2 == 0 }

    println("Is 7 even? - ${isEven.accept(7)}")
}

fun interface KRunnable {
    fun invoke()
}

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}