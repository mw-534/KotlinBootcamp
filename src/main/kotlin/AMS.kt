// documentation to Kotlin can be found at kotlinlang.org

import java.util.*

fun main(args: Array<String>)
{
    //dayOfWeek()
    //println("Hello ${args[0]}")
    //feedTheFish()

    /*
    println(fitMoreFish(10.0, listOf(3,3,3)))
    println(fitMoreFish(8.0,listOf(2,2,2), hasDecorations = false))
    println(fitMoreFish(9.0, listOf(1,1,3),3))
    println(fitMoreFish(10.0, listOf(),7,true))
    */

    repeat(2){
        println("$it fish is swimming")
    }

}

fun feedTheFish()
{
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    shouldChangeWater(day, 20, 50)
    shouldChangeWater(day)
    shouldChangeWater(day, dirty=50)

    if (shouldChangeWater(day)){
        println("Change the water today")
    }

    // call dirty processor
    dirtyProcessor()

}

fun randomDay() : String
{
    val week = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(7)]
}

fun fishFood(day : String) : String {
    return when (day) {
        "Monday" -> "flakes"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Sunday" -> "plankton"
        else -> "fasting"
    }
}

fun getDirtySensorReading() = 20

fun shouldChangeWater(
    day : String = "Monday",
    temperature : Int = 22,
    dirty : Int = getDirtySensorReading()) : Boolean {

    // when without (argument) works like as sequence of if / else if / else statements
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        day == "Sunday" -> true
        else -> false
    }
}

// one line functions don't need a body {}, instead = is used
// if the return type can be inferred from the result it hasn't to be stated
fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) : Boolean = dirty > 30 // return type here is not necessary

fun isSunday(day: String) = day == "Sunday"


fun dayOfWeek()
{
    println("What day is it today?")
    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    println(when(day)
    {
        1 -> "Sunday"
        2 -> "Monday"
        3 -> "Tuesday"
        4 -> "Wednesday"
        5 -> "Thursday"
        6 -> "Friday"
        7 -> "Saturday"
        else -> "Time has stopped"
    })
}

var dirty = 20

val waterFilter : (Int) -> Int = { dirty -> dirty / 2}
fun feedFish(dirty : Int) = dirty + 10 // this is not a lambda but a named function

// this is a hihger order function because it has a function type as a parameter
fun updateDirty( dirty : Int, operation : (Int) -> Int ) : Int {
    return operation(dirty)
}

fun dirtyProcessor() {

    dirty = updateDirty(dirty, waterFilter)

    dirty = updateDirty(dirty, ::feedFish)
    // feedFish has to be passed with :: because it is a
    // named function, not a lambda
    // that way Kotlin knows you're not trying
    // to call feedFish but instead you are
    // passing it as reference

    dirty = updateDirty(dirty, { d -> d + 50 })

    dirty = updateDirty(dirty){ d -> d + 50}
    // since lambda is last argument in
    // function declaration Kotlin allows
    // it to be moved out of the function call
    // that way higher order functions can
    // be defined that look like normal functions
}



fun test1()
{
    val isUnit = println("This is an expression")
    println(isUnit)

    val temperature = 10
    val isHot = if (temperature > 50) true  else false
    println(isHot)

    val message = "You are ${if (temperature > 50) "fried" else "safe"} fish"
    println(message)
}

fun fitMoreFish(
    tankSize : Double,
    currentFish : List<Int>,
    fishSize : Int = 2,
    hasDecorations : Boolean = true
) : Boolean {
    return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
}