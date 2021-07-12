fun main (args: Array<String>){

    val spice = SimpleSpice()
    println("name: ${spice.name} heat: ${spice.heat}")

    val spices1 = listOf(
        Spice("curry", "mild"),
        Spice("pepper", "medium"),
        Spice("cayenne", "spicy"),
        Spice("ginger", "mild"),
        Spice("red curry", "medium"),
        Spice("green curry", "mild"),
        Spice("hot pepper", "extremely spicy")
    )

    val spice2 = Spice("cayenne", "spicy")



    val filteredList = spices1.filter{it.heat < 5}
    println(filteredList.count())

}