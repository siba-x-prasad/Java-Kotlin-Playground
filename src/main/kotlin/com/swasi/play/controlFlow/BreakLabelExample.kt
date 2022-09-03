package spm.kotlin.world.controlFlow


/**
 * Created by Sibaprasad Mohanty on 29/04/2022.
 * siba.x.prasad@gmail.com
 */

fun main() {
    loopOuter@ for (i in 1..100) {
        loopInner@ for (j in 1..100) {
            println("i = $i J = $j")
            if (i ==10) break@loopOuter
            if (j ==10) break@loopInner
        }
    }
}