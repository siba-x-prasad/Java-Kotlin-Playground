package spm.kotlin.world.basic


/**
 * is used to check the type of the data type
 * !is opposite of is
 * as operator is an unsafe type cast operator
 * as? is a safe typecast operator
 *
 */

fun main() {
    val name = "Siba"
    val nameAsString : String = name as String

    val age = 32
//    val ageAsString = age as String
//    println("$age after converting to string is $ageAsString")

    // another way to handle this
    val age1 = 32
    val age1AsString = age1 as? String
    println("$age1 after converting to string is $age1AsString")


}

fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // `obj` is automatically cast to `String` in this branch
        return obj.length
    }

    // `obj` is still of type `Any` outside of the type-checked branch
    return null
}

fun getStringLength1(obj: Any): Int? {
    if (obj !is String) return null

    // `obj` is automatically cast to `String` in this branch
    return obj.length
}

