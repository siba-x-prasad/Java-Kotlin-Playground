package spm.kotlin.world.classesAndObjects


/**
 * Created by Sibaprasad Mohanty on 29/04/2022.
 * siba.x.prasad@gmail.com
 */

class InterfaceInheritanceExample {

}

interface Named {
    val name: String
}

interface Person1 : Named {
    val firstName: String
    val lastName: String

    override val name: String get() = "$firstName $lastName"
}

data class Employee(
    // implementing 'name' is not required
    override val firstName: String,
    override val lastName: String
) : Person1