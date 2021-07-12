package Aquarium

// 'composition' is when you use an instance of another class in your class instead of inheriting from that class
// in Kotlin you can do this by interface delegation

fun main(args: Array<String>) {
    delegate()
}

fun delegate() {
    val pleco = Plecostromus2()
    println("Fish has color: ${pleco.color}")
    pleco.eat()
}

interface FishAction2 {
    fun eat()
}

interface FishColor {
    val color: String
}

// compared to Plecostromus this clas doesn't inherrit anymore but instead
// uses only interfaces
// by means handle all calls to the interface FishColor by delegating them to the object GoldColor
// that way we don't have to implement the interface in our class
class Plecostromus2() : FishAction2 by PrintingFishAction("a lot of algae"), FishColor by GoldColor
// you could also use this:
// class Plecostromus2(fishColor: FishColor = GoldColor) : FishAction2, FishColor by fishColor {
// which allows to set object to which the interface should delegate dynamically

// if a class  should  have only one instance
// you can use the keyword object instead of class
// to make sure only one instance is created - Singleton Pattern
object GoldColor : FishColor {
    override val color = "gold"
}

object RedColor : FishColor {
    override val color = "red"
}

class PrintingFishAction(val food: String): FishAction2 {
    override fun eat() {
        println(food)
    }

}
