package spm.kotlin.world.classesAndObjects


/**
 * Created by Sibaprasad Mohanty on 29/04/2022.
 * siba.x.prasad@gmail.com
 */

fun main() {
    val class1 = Class1()
    class1.bar()
    class1.foo()
}

class Class1 : InterfaceExample1 {
    override fun bar() {
        // body
    }

    override fun foo() {
        super.foo()
        println("Inside foo of Class1")
    }
}

interface InterfaceExample1 {
    fun bar()
    fun foo() {
        println("Inside foo of Interface1")
    }
}