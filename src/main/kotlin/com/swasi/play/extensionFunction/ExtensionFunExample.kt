package com.swasi.play.extensionFunction

fun main(args: Array<String>) {

    val st1 = Student()
    val res = st1.hasPassed(90)
    println("Result is $res")

    val resScholar  = st1.isScholar(95)
    println("Result is $resScholar")

    val str1 = "Siba"
    val str2 = "Prasad"
    val str3 = "Prasad"

   val str4 =  str1.add(str2,str3)

    println("Addition of he BOVE STRING IS $str4")

    val  num3 = 123
    val greaterNum = num3.isGreaterNumber(13)
    println("The greater number is $greaterNum")




}

fun Student.isScholar(mark:Int):String{
    val result = if (mark>90){
        println("He is a Scholar")
        "Scholar"
    }
    else{
        println("He is a Not Scholar")
        "Not Scholar"
    }
    return result
}

class Student{

    fun hasPassed(mark:Int):String{
        var result:String = if(mark>30) {
            println("Passed inside Function")
            "Passed"
        }
        else{
            println("Failed inside Function")
            "fail"
        }
        return result
    }

}


fun String.add(str1:String,str2:String):String{
    return this + str1 + str2
}

fun Int.isGreaterNumber(num:Int):Int{
   val result:Int =  if(this > num){

       this
   }
    else{
       num
   }
    return result
}