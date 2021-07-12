package Aquarium

fun main(args: Array<String>){
    //extensionExample()
    //staticExample()
    //propertyExample()
    //nullableExample()
}

// extension functions can be called on a class they are defined for without having to modify the original class

// extension functions are really usefull for defining helper functions that shouldn't be part of the core API

// an extension function is defined like a regular function but it has the classname with a dot
// in front of its declaration and it can use the class inside its body with 'this'


// example for defining an extension function
fun String.hasSpaces() : Boolean {
    val found: Char? = this.find{it == ' '}
    return found != null
}

fun String.hasSpaces2() = find { it == ' '} != null

fun extensionExample() {
    println(
    "Does it have space?".hasSpaces()
    )
    println("Does it have space?".hasSpaces2())
}

// only public members of the extended class can be used in an extension function

// extension functions are resolved statically at compile time.
// Therefore when they are called on the casted base class of a
// subclass they think this object is the base class instead of
// the casted subclass and use the extension function defined for the base class.
// Never the lass if an extension function is only defined for a base class
// it can still be called on the subclass
open class AquariumPlant(val color: String, private val size: Int)
class GreenLeafyPlant(size: Int): AquariumPlant("Green", size)

fun AquariumPlant.print() = println("AquariumPlant")
fun GreenLeafyPlant.print() = println("GreenLeafyPlant")

fun staticExample() {
    val plant = GreenLeafyPlant(size = 50)
    plant.print()  // prints GreenLeafyPlant

    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print() // prints AquariumPlant even though it is really a GreenLeafyPlant and GreenLeafyPlant has its own extensionFunction
}

// extension properties
val AquariumPlant.isGreen: Boolean
    get() = color == "Green"

fun propertyExample(){
    val plant = AquariumPlant("Green", 50)
    println(plant.isGreen)
}

// extension functions can be declared on nullable objects
fun AquariumPlant?.pull() {
    this?.apply{ println("removing $this") }
}

fun nullableExample() {
    val plant : AquariumPlant? = null
    plant.pull() // no need to check for null here with ? Operator because extension functions was defined to handle this
    // pull() could even define some default behavior in case its caller is null
}