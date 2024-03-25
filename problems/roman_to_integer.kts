val roman = mapOf(
    "I" to 1,
    "V" to 5,
    "X" to 10,
    "L" to 50,
    "C" to 100,
    "D" to 500,
    "M" to 1000
)

val prevRoman = mapOf<String, String>(
    "V" to "I",
    "X" to "I",
    "L" to "X",
    "C" to "X",
    "D" to "C",
    "M" to "C"
)

fun convertToInteger(str: String): Int {
    var result = 0
    var prevChar = ""
    str.forEach {
        val s = it.toString()

        result += roman[s]?:0

        if (prevChar == (prevRoman[s]?:"-")) {
            result -= ((roman[prevChar]?:0)*2)
        }
        prevChar = s

    }
    return result
}

fun convertToIntegerOptimal(str: String): Int {
    var current = 0
    var prev = 0
    var result = 0
    str.forEach {
        val s = it.toString()
        current = roman[s]?:0

        if (current < prev) {
            result -= current
        } else {
            result += current
        }

        prev = current
    }

    return result
}

println(convertToInteger("LVIII"))
println(convertToIntegerOptimal("MCMXCIV"))
