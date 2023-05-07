package study_note.recursive_call

fun factorial(num: Int): Int =
    if(num <= 1){
        1
    } else {
        num * factorial(num - 1)
    }

fun fibo(num: Int): Int {
    if (num == 1) {
        return num
    }

    return if (num % 2 == 1) {
        fibo((3 * num) + 1)
    } else {
        fibo(num / 2)
    }
}

fun func(num: Int): Int{
    if(num == 1){
        return 1
    }
    if(num == 2){
        return 2
    }
    if(num == 3){
        return 4
    }

    return func(num - 1) + func(num - 2) + func(num - 3)
}

fun main(){
    println(factorial(5))
    println(fibo(5))
    println(func(5))
}