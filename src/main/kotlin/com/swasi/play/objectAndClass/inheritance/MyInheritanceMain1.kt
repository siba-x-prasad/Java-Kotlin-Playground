package com.swasi.play.objectAndClass.inheritance

import kotlin.properties.Delegates

internal object  MyInheritanceMain1 {

    lateinit var testInit: String
    var testDelegate by Delegates.notNull<String>()
    @JvmStatic
    fun main(args: Array<String>) {

    }
}