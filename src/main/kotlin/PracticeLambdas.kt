import java.util.*

fun main(args : Array<String>){

    val rollDice = {sides : Int -> if (sides == 0) 0 else Random().nextInt(sides) + 1 }
    val rollDice2 : (Int) -> Int = { sides -> if (sides == 0) 0 else Random().nextInt(sides) +1 }
    println(rollDice2(3))
    gamePlay(8, rollDice)
}

fun gamePlay(sides : Int, rollDice : (Int) -> Int) {
    println(rollDice(sides))
}
