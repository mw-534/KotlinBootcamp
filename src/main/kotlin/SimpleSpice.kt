class SimpleSpice {

    val name = "curry"
    val spiciness = "mild"

    val heat : Int
        get() = if (spiciness == "mild") 5 else 0
}