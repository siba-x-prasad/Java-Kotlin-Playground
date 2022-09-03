package spm.kotlin.world.classesAndObjects


/**
 * Created by Sibaprasad Mohanty on 29/04/2022.
 * siba.x.prasad@gmail.com
 */


class PersonWithConstructor(val name: String) {
    val children: MutableList<PersonWithConstructor> = mutableListOf()

    constructor(name: String, parent: PersonWithConstructor) : this(name) {
        parent.children.add(this)
    }
}