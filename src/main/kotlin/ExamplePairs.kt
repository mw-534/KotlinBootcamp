fun main(args: Array<String>){
    examplePairs()
}

fun examplePairs() {

    // pairs are good for having a function return more than one value

    // pair
    val equipment = "fishnet" to "catching fish"
    println(equipment.first)
    println(equipment.second)

    // chaining pairs
    val equipment2 = "fishnet" to "catching fish" to "of big size" to "and strong"
    println(equipment2)
    println(equipment2.first.second)

    // define pairs with parenthesis
    val equipment3 = ("fishnet" to "catching fish") to ("of big size" to "and strong")
    println(equipment3.second.first)

    // destructuring pairs
    val fishnet = "fishnet" to "catching fish"
    val (tool, use) = fishnet
    println("The $tool is a tool for $use.")

    val fishnetString = fishnet.toString()
    println(fishnetString)

    println(fishnet.toList())

    val (tool2, use2) = giveMeATool()
    println(tool2)
    println(use2)
}

fun giveMeATool(): Pair<String, String> {
    return ("fishnet" to "catching")
}