package Aquarium

// difference between val and const
// const val is assigned at compile time so it can't take results of a function
// val is assigned at runtime so it can be set to the result of a function
// const val can only be declared outside of a class or in object special class

const val rocks = 3

val number = 5

const val num = 5

fun complexFunctionCall(){}

val result = complexFunctionCall()

const val CONSTANT = "top-level constant"

object Constants {
    const val CONSTANT2 = "object constant"
}

val foo = Constants.CONSTANT2

// to define a constant inside a class it needs to be wrapped in a companion object
// object special class is initialized lazily that means when it is first used
// companion object is initialized when the class is instantiated

class MyClass {

    companion object {
        const val CONSTANT3 = "constant inside a class"
    }
}