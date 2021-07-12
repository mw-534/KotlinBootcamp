package Aquarium

fun main(args: Array<String>){
    buildAquarium()
    makeFish()
}

fun buildAquarium(){

    val myAquarium = Aquarium() // constructor is called, in Kotlin no new keyword

    println("Length: ${myAquarium.length} " +
            "Height: ${myAquarium.height} " +
            "Width: ${myAquarium.width} ")

    myAquarium.height = 80

    println("Height: ${myAquarium.height} cm")

    println("Volume: ${myAquarium.volume} liters")

    //val smallAquarium = Aquarium(20, 15, 30)
    val smallAquarium = Aquarium(length = 20, width = 15, height=  30) // more readable
    println("small Aquarium: ${smallAquarium.volume} liters")

    val smallAquarium2 = Aquarium(numberOfFish = 9)
    println("Small Aquarium 2: ${smallAquarium2.volume} liters" +
            "length: ${smallAquarium2.length} " +
            "width: ${smallAquarium2.width} " +
            "height: ${smallAquarium2.height}")
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostromus()

    println("Shark: ${shark.color} \n Plecostromus: ${pleco.color}")

    shark.eat()
    pleco.eat()
}