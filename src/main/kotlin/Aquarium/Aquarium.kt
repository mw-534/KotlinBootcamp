package Aquarium

import kotlin.math.PI

open class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) { // this is the default constructor

    // all access modifiers are public by default. But limiting access is possible
    // using the usual access modifiers
    // private - only visible inside the file
    // internal - only visible inside the module
    // a module is a set of kotlin files compiled together
    // so internal means visible everywhere inside the project but not from outside of it
    // protected - like private but also accessible to subclasses

    // these 3 are properties too, Kotlin creates getters for these automatically
    // these variables can also be declared in the constructor directly with their default values
    //var width : Int = 20
    //var height : Int = 40
    //var length: Int = 100

    /*var volume : Int
        get() {
            return width * height * length / 1000
        }
        private set(value) { height = (value * 1000) / (width * length) }
        */

    open var volume : Int
        get() = width * height * length / 1000
        set(value) { height = (value * 1000) / (width * length) }

    open var water = volume * 0.9 // needs to be put below volume because members get initialized in the order they're defined

    // if more than one constructor is needed
    // constructor has to be used together
    // with this() where this() calls the
    // default constructor
    constructor(numberOfFish: Int): this() {

        val water : Int = numberOfFish * 2000 // cm3
        val tank : Double = water + water * 0.1
        height = ( tank / (length * width)).toInt()
    }
}

// inheritance: to make a class able to have subclasses it needs to be specified as open explicitly
// the same needs to be done for any member that should be inherited too (protected would also work)
// the explicit declaration as open is forced by Kotlin to avoid leaking class information accidentally
class TowerTank() : Aquarium() {

    override var water = volume * 0.8

    override var volume : Int
        get() = (width * height * length / 1000 * PI).toInt()
        set(value) {
            height = (value * 1000) / (width * length)
        }
}

// labels can have any name it's just important to mark them with the @ e.g. myLabel@ for marked expression and break@myLabel for jump statement
// any expression can be marked with a label
// example labeled break
fun labels() {
    label@ for (i in 1..100) {
        for (j in 1..100) {
            if (j > 10) break@label  // jumps to the label instead of just  breaking the current loop.
        }
    }
}