package Aquarium

// special purpose classes



// has a different implementation of toString(), gives special methods equals() and copy() to the class and enables decomposition
data class Decos(val name : String)



// object declares a singleton class
object MobyDickWhale {

    val author = "Herman Melville"

    fun jump() {
        // ...
    }
}



// Kotlin makes sure only one enum is instantiated
// use:  Color.BLUE
enum class Color(val rgb : Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}



// sealed class allows inheritance from it only if the subclass
// is in the same file
// this is useful if you want to make sure there are only a
// fixed number of subclasses. Useful when returning success or error from an API
sealed class Seal

class SeaLion() : Seal()
class Walrus() : Seal()

// because the parameter below is a sealed class Kotlin knows
// that the list of subclasses in the when statement
// is exhaustive. If a subclass would be missing the compiler
// would state an error asking to provide the missing subclasses or
// add an else
fun matchSeal(seal: Seal): String {
    return when (seal) {
        is Walrus -> "Walrus"
        is SeaLion -> "sea Lion"
    }
}