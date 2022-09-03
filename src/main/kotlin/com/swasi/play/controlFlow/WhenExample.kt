package spm.kotlin.world.controlFlow


/**
 * Created by Sibaprasad Mohanty on 29/04/2022.
 * siba.x.prasad@gmail.com
 */

fun main() {
    val x = 12
    when (x) {
        1 -> print("x == 1")
        2 -> print("x == 2")
        else -> {
            print("x is neither 1 nor 2")
        }
    }

    val month = getMonth(1)
    println(month)
    val month1 = getMonth(-1)
    println(month1)


    when (Color.GREEN) {
        Color.RED -> println("red")
        Color.GREEN -> println("green")
        Color.BLUE -> println("blue")
        else -> println("not Any Color") // 'else' is required
        // 'else' is not required because all cases are covered
    }

    when (x) {
        0, 1 -> print("x == 0 or x == 1")
        else -> print("otherwise")
    }

    when (x) {
        x.toInt() -> print("s encodes x")
        else -> print("s does not encode x")
    }

    val validNumbers = 1..10

    when (x) {
        in 1..10 -> print("x is in the range")
        in validNumbers -> print("x is valid")
        !in 10..20 -> print("x is outside the range")
        else -> print("none of the above")
    }

    fun hasPrefix(x: Any) = when(x) {
        is String -> x.startsWith("prefix")
        else -> false
    }

    when {
        x.isOdd() -> print("x is odd")
        x.isEven() -> print("y is even")
        else -> print("x+y is odd")
    }

/*    fun Request.getBody() =
        when (val response = executeRequest()) {
            is Success -> response.body
            is HttpError -> throw HttpException(response.status)
        }*/

}

fun Int.isOdd() = this%2 != 0
fun Int.isEven() = this%2 == 0

enum class Color {
    RED, GREEN, BLUE
}

private fun getMonth(monthNumber : Int) : String{
   return  when (monthNumber) {
        1 -> "January"
        2 -> "February"
        else -> {
            println("It's not a month")
            "Not a Month"
        }
    }
}