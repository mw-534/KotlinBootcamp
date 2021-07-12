package Aquarium

abstract class AquariumFish() {

    abstract val color: String
}

class Shark() : AquariumFish(), FishAction {

    override val color = "gray"

    override fun eat() {
        println("hunt and eat fish")
    }

}

class Plecostromus: AquariumFish(), FishAction {

    override val color = "gold"

    override fun eat() {
        println("munch on algae")
    }
}

interface FishAction {

    fun eat()
}

// interfaces and abstract classes can have default implementations of methods
// the only difference between interfaces and abstract clases is that abstract classes
// have constructors while interfaces don't
// use an interface when you have a lot of functions with only one or two default implementations
// use an astract class everytime you can't complete a class

