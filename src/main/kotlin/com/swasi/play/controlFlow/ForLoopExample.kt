package spm.kotlin.world.controlFlow


/**
 * Created by Sibaprasad Mohanty on 29/04/2022.
 * siba.x.prasad@gmail.com
 */

fun main() {
    val list = listOf<String>("siba","Prasad","Mohanty")
    // access item in collection using forloop
    for(item in list){
        println(item)
    }
    // Access items from a range
    val ints = 1..5
    for (item: Int in ints) {
        print(item)
    }

    for (i in 1..3) {
        println(i)
    }

    for (i in 6 downTo 0 step 2) {
        println(i)
    }

    // Access index from an array using forloop
    val array = arrayOf(1,2,3,4,5,6)
    for (i in array.indices) {
        println(array[i])
    }

    val arrayValue = arrayOf<String>("Siba","Prasad", "Mohanty")
    for ((index,value) in arrayValue.withIndex()) {
        println("Item at Index $index is $value")
    }
}