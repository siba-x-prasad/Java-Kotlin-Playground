package com.swasi.play.objectAndClass.abstractClass

import kotlin.properties.Delegates

open class MyAbstractClassMain1 {

    open lateinit var testInit: String
    var testDelegate by Delegates.notNull<String>()
    open fun myPrint() {

    }
}

class MyClass : MyAbstractClassMain1() {

    override var testInit: String
        get() = super.testInit
        set(value) {}

    override fun myPrint() {
        super.myPrint()
    }
}