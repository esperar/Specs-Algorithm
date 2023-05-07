package study_note.recursive_call

fun factorial(num: Int): Int =
    if(num <= 1){
        1
    } else {
        num * factorial(num - 1)
    }

fun main(){
    println(factorial(5))
}