package Aquarium5

import Aquarium.fishExample

data class Fish(var name: String)

fun main(args: Array<String>){
    fishExamples()
    //practice()
}

fun fishExamples() {
    val fish = Fish("splashy")

    // with applies multiple operations to an object.
    // it is like the with statement in VBA
    with (fish.name) {
        println(capitalize())
    }

    myWith (fish.name) {
        println(capitalize())
    }

    // run takes a lambda and returns its result after executing the lambda
    println(fish.run{name})

    // apply takes a lambda and executes it but instead of its result
    // it returns the object it was applied to after the lambda has been executed
    println(fish.apply{})
    val fish2 = Fish(name="splashy").apply{name = "Sharky"}
    println(fish2)

    // let takes a lambda and returns its result after the lambda has been executed.
    println(fish.let{it.name.capitalize()}
        .let{it + "fish"}
        .let{it.length}
        .let{it + 31})

    // difference between run and let
    // run uses the object it was called upon as its receiver (this is receiver in the lambda)
    // let uses the object it was called upon as its argument (this is argument in the lambda)

}

// parameter block is a function type that awaits an extension function lambda as an argument
// block is called a receiver
// Unit is Kotlin's way of saying the function returns nothing
fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}

// everytime a lambda is called a new object is created because
// a lambda is an object. This isn't a problem usually but if
// a lambda is more complex or is called very often this can
// add up to cost cpu time. To avoid this a function can
// be inlined which means its call will be replaced everywhere by
// hard written code at the positions of the calls of the
// function. That way you have zero overhead.
inline fun myWith2(name: String, block: String.() -> Unit) {
    name.block()
}


// practice - my solution
fun List<Int>.divideBy(block: (Int) -> Boolean): List<Int> {
    var mList = mutableListOf<Int>()
    for(e in this) {
        if (block(e)) mList.add(e)
    }
    return mList.toList()
}

// practice - official solution
fun List<Int>.divisibleBy(block: (Int) -> Int): List<Int> {
    val result = mutableListOf<Int>()
    for (item in this) {
        if (block(item) == 0) {
            result.add(item)
        }
    }
    return result
}

fun practice() {
    // my solution
    val list = listOf(1,2,3,4,5,6,7,8,9,0)
    println(list.divideBy { e -> e % 3 == 0 })

    // official solution
    val numbers = listOf(1,2,3,4,5,6,7,8,9,0)
    println(numbers.divisibleBy { it.rem(3) })

}

