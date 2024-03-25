fun reverse(x: Int): Int {
    var num = x
    var reversed = 0
    
    while (num != 0) {
        val digit = num % 10 // get the last digit
        if (reversed > Int.MAX_VALUE / 10 || (reversed == Int.MAX_VALUE / 10 && digit > 7)) return 0
        if (reversed < Int.MIN_VALUE / 10 || (reversed == Int.MIN_VALUE / 10 && digit < -8)) return 0
        reversed = reversed * 10 + digit // put the last digit to first, by multiplying to 10
        num /= 10 // subtract the digit by dividing by 10
    }
    
    return reversed
}

fun main() {
    val x1 = 123
    val x2 = -123
    val x3 = 120
    val x4 = 0
    
    println(reverse(x1)) // Output: 321
    println(reverse(x2)) // Output: -321
    println(reverse(x3)) // Output: 21
    println(reverse(x4)) // Output: 0
}

main()