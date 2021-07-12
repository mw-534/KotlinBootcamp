package Aquarium

class Fish(val friendly: Boolean = true, volumeNeeded: Int) {
// volumeNeeded has no var or val so Kotlin won't create a property from it
// this is useful if we want to declare helper variables which can be set in the constructor
// but can't be called as a property on the object
// this is very important when inheriting because specifying a property that already exists
// in the base class would hide it but by declaring a variable without var or val in
// the constructor of the subclass it can be passed to the property in the constructor
// of the base class


    // it is good practice in Kotlin to only make on primary constructor and define optional values in it
    // instead of making multiple constructors with different parameter combinations which would be done in
    // other languages. As constructor body for primary constructor use init blocks
    // it is good practice to use helper methods instead of multiple constructors

    val size: Int

    init {
        println("first init block")
    }

    constructor(): this(true, 9) {
        println("running secondary constructor")
    }

    // init is a block of code that executes on construction, just like a constructor
    // init blocks always run before secondary constructors (that is any constructor except the primary one defined with class keyword
    // multiple init constructors are executed in the order they are defined in the class (top to bottom)
    init {
        if (friendly) {
            size = volumeNeeded
        }
        else {
            size = volumeNeeded * 2
        }
    }

    init {
        println("constructed fish of size $volumeNeeded final size ${this.size}")
    }

    init {
        println("last init block")
    }
}

// instead of making multiple constructors create a helper method instead to keep class simple with a clean API
// to be able to call the make function it is important to put it outside of the class definition
fun makeDefaultFish() = Fish(true, 50)

fun fishExample() {
    val fish = Fish(true, 20)
    // println("Is this fish friendly? ${fish.friendly}. It needs volume ${fish.volumeNeeded}") // fish.volumeNeeded would give an error here because it is not a property
    println("Is this fish friendly? ${fish.friendly}. It needs volume ${fish.size}")
}