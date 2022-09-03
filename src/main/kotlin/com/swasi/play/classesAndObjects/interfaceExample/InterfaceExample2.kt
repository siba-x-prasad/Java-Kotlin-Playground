package spm.kotlin.world.classesAndObjects


/**
 * Created by Sibaprasad Mohanty on 29/04/2022.
 * siba.x.prasad@gmail.com
 */

fun main() {
    val interfaceExample2 = InterfaceExample2()
    interfaceExample2.foo()
    println("Value of propertyWithImplementation ${interfaceExample2.propertyWithImplementation}")
    println("Value of prop is ${interfaceExample2.prop}")
}

interface MyInterface {
    val prop: Int // abstract

    val propertyWithImplementation: String
        get() = "foo"

    fun foo() {
        print(prop)
    }
}

class InterfaceExample2 : MyInterface {
    override val prop: Int = 29
}