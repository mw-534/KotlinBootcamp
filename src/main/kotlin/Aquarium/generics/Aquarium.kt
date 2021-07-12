package Aquarium.generics

fun main(args: Array<String>){
    genericExample()
}

/*
Building generic classes boils down to the following steps:

- Create a type/class hierarchy. The parent is non-specific and the sub-types/subclasses are specializations.
- There is at least one shared property between the classes/types, and it has a different value depending on the subtype (otherwise, having the sub-types is pointless).
- We then have a class that uses all the subtypes, and performs different actions depending on what the values of the subtype’s properties are.
*/

open class WaterSupply(var needsProcessed: Boolean)

class TapWater : WaterSupply(true) {
    fun addChemicalCleaners(){
        needsProcessed = false
    }
}

class FishStoreWater : WaterSupply(false)

class LakeWater : WaterSupply(true)  {
    fun filter() {
        needsProcessed = false
    }
}

// if T is declared with out e.g. <out T: WaterSupply> then T can only be returned or used as a val but not used as an input parameter
// out gives a compiler error if used as an input parameter. Kotlin can use extra information if a type is declared as out which
// allows to use subclasses of it as well where Kotlin determines that it is safe to use, see example below
// if T is declared with in e.g. <int T: WaterSupply> then T can only be used as a parameter but not as a return type in the class
// only constructors can take out types as an argument but functions can't
class Aquarium<out T: WaterSupply>(val waterSupply: T) {

    fun addWater() {
        check(!waterSupply.needsProcessed){"water supply needs to be processed"}

        println("adding water from $waterSupply")
    }

    fun addWater2(cleaner: Cleaner<T>) {
        if (waterSupply.needsProcessed){
            cleaner.clean(waterSupply)

            println("adding water from $waterSupply")
        }
    }

    // Kotlin uses generic type erasure that means all generic types only exist at compile time
    // at compile time they are replaced by their types and therefore generics don't exist at runtime
    // reified makes sure type is a real type
    // inline turns the function into an inline function that is everytime the function is called
    // it is dropped in the place where the call occurs as if it was written there instead of
    // calling a reference to the place where the code is written
    // the compiler figures out what a type R would have been if the function was written in the
    // place where it was called and uses the real type used there (this is done by keyword reified) instead of a generic
    // if inline and reified wasn't used here Kotlin wouldn't allow the is check with a generic because
    // generics are only known at compile time but not at runtime
    inline fun <reified R: WaterSupply> hasWaterSupplyOfType() = waterSupply is R
}

interface Cleaner<in T: WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner : Cleaner<TapWater> {
    override  fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

// generic functions. T needs to be specified in front of the function name
// because it could also be used in the body of the function and not just as
// a parameter
fun <T: WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean ${aquarium.waterSupply.needsProcessed}")
}

// extension function with generics
inline fun <reified T: WaterSupply> WaterSupply.isOfType() = this is T

// extension function where it is not important on which generic type the function is called therefore use of * which means function will take any generic type
inline fun <reified T: WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is T

fun genericExample() {

    val aquarium = Aquarium<TapWater>(TapWater()) // because of type inference val aquarium = Aquarium(TapWater()) is also possible
    aquarium.waterSupply.addChemicalCleaners()


    val aquarium4 = Aquarium(LakeWater())
    aquarium4.waterSupply.filter() // removing this line make check() in addWater throw an illegal state exception
    aquarium4.addWater()

    val aquarium5 = Aquarium(TapWater())
    addItemTo(aquarium5) // without out in Aquarium<out T: WaterSupply> the addItemTo Method would only except WaterSupply but not TapWater

    val cleaner = TapWaterCleaner()
    aquarium5.addWater2(cleaner)
    isWaterClean(aquarium5)
    aquarium5.hasWaterSupplyOfType<TapWater>() // true
    aquarium5.waterSupply.isOfType<LakeWater>() // false
}