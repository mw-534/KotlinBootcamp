package Aquarium

fun main(args: Array<String>){
    val game = Game()
    /*println(game.path)
    game.north()
    game.east()
    game.south()
    game.west()
    game.end()
    println(game.path)*/

    while(true){
        print("Enter a direction: n/s/e/w:")
        game.makeMove(readLine()!!)
        game.makeMove("s")
        game.makeMove(null)
    }
}

enum class Direction {
    NORTH, SOUTH, EAST, WEST, START, END
}

class Game {
    var path = mutableListOf<Direction>(Direction.START)
    val north = { path.add(Direction.NORTH) }
    val south = { path.add(Direction.SOUTH) }
    val east = { path.add(Direction.EAST) }
    val west = {path.add(Direction.WEST)}
    val end = { path.add(Direction.END); println("Game Over: $path"); path.clear(); false }
    var location = Location()

    fun move(where: () -> Unit) {
        where()
    }

    fun makeMove(direction: String?) {
        when (direction) {
            null -> move{end}
            "s" -> move{ south; location.updateLocation(Direction.SOUTH) }
            "e" -> move{east; location.updateLocation(Direction.EAST)}
            "n" -> move{north; location.updateLocation(Direction.NORTH)}
            "w" -> move{west; location.updateLocation(Direction.WEST)}
            else -> move{ end }
        }
    }
}

class Location(var width: Int = 0, var height: Int = 0) {

    val map = Array(4){ arrayOfNulls<String>(4)}

    init {
        for (i in 0..3){
            for (j in 0..3){
                map[i][j] = "w: $i - h: $j"
            }
        }
    }

    fun updateLocation(direction: Direction) {
        when (direction) {
            Direction.NORTH -> if (height > 0) height--
            Direction.SOUTH -> if (height < 3) height++
            Direction.EAST -> if (width < 3) width++
            Direction.WEST -> if (width > 0) width--
        }
        println("you are at ${map[width][height]}")
    }
}

