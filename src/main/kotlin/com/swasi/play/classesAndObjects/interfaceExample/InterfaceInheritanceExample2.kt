package spm.kotlin.world.classesAndObjects


/**
 * Created by Sibaprasad Mohanty on 29/04/2022.
 * siba.x.prasad@gmail.com
 */

fun main() {

}

interface A {
    fun foo() { print("A") }
    fun bar()
}

interface B {
    fun foo() { print("B") }
    fun bar() { print("bar") }
}

class C : A {
    override fun bar() { print("bar") }
}

class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super<B>.bar()
    }
}