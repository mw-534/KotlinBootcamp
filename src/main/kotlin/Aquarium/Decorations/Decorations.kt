package Aquarium.Decorations

fun main(args: Array<String>) {
    makeDecorations()
}

fun makeDecorations() {

    val d1 = Decorations("granite")
    println(d1)

    val d2 = Decorations("slate")
    println(d2)

    val d3 = Decorations("slate")
    println(d3)

    println(d1.equals(d2))
    println(d3.equals(d2))

    val d4 = d3.copy()
    println(d3)
    println(d4)

    val d5 = Decorations2("crystal", "wood", "diver")
    val ( rocks: String, wood: String, diver: String ) = d5 // decomposition - signature of val ( ... ) must match that of the decomposed class
    println(rocks)
    println(wood)
    println(diver)

}

// data modifies the toString() of the class
// to print the properties as key-value pairs
// instead of the address of the object
// it also provides a equals() to compare content of instances of the class
// it provides copy() which creates a new object with the same values
data class Decorations(val rocks: String) {}

data class Decorations2(val rocks: String, val wood: String, val diver: String){}