package com.swasi.play.idoms


fun main() {
    val abstractClassInstance = object : InstantiateAbstractClass() {
        override fun doSomething() {
            println("Do something")
        }

        override fun sleep() {
            println("Sleep")
        }
    }

    abstractClassInstance.doSomething()
    abstractClassInstance.sleep()
}

abstract class InstantiateAbstractClass {
    abstract fun doSomething()
    abstract fun sleep()
}

interface InterfaceExample {
    fun doSomething()
    fun sleep()
}