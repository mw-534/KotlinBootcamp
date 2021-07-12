fun main(args: Array<String>) {

    val spiceCabinet = listOf(
        SpiceContainer(Spice("Yellow Curry", "mild")),
        SpiceContainer(Spice("Red Curry","medium")),
        SpiceContainer(Spice("Green Curry", "hot"))
        )

    for (element in spiceCabinet) println(element)

}

data class SpiceContainer(val spice : Spice, val label : String = spice.name) {

}

