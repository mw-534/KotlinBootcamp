fun main(args : Array<String>) {
    println(whatShouldIDoToday("happy"))
}

fun whatShouldIDoToday(mood : String = getMood(), weather : String = "sunny", temperature : Int = 24) : String {
    return when {
        mood == "happy" && weather == "sunny" -> "go for a walk"
        isSad(mood, weather, temperature) -> "stay in bed"
        isHot(temperature) -> "go swimming"
        else -> "Stay home and read."
    }
}

fun isSad(mood : String, weather : String, temperature : Int) = mood == "sad!" && weather == "rainy" && temperature == 0

fun isHot(temperature: Int) = temperature > 35

fun getMood() : String {
    println("Enter your mood")
    return readLine()!!  // !! is used to enable method execution because it could result in a null pointer exception
}

