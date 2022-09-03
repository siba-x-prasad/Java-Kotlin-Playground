package spm.kotlin.world.classesAndObjects.interfaceExample


/**
 * Created by Sibaprasad Mohanty on 30/04/2022.
 * siba.x.prasad@gmail.com
 */

fun main() {
    val d = D()
    d.foo()
    d.bar()

    val c = C()
    c.bar()
    c.foo()

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