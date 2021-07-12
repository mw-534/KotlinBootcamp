fun main(args: Array<String>)
{
    //exampleReversingList()
    exampleList()
    //exampleMapping()
}

fun exampleReversingList(){
    val list = listOf(1,2,3)
    val rList = list.reversed()
    println(rList)
}

fun exampleList(){

    // listOf() gives an immutable list
    // mutableListOf() returns a mutable list
    val mList = mutableListOf<String>("a","b","c")
    mList.add("d")
    mList.remove("a")

    mList.contains("c") // true
    mList.contains(("a")) // false
    println(mList.subList(2, mList.size)) // index is 0 based, start index is included, end index is excluded

    println(listOf(1,2,3).sum()) // you can do math on lists

    println( listOf("a","b","cc").sumBy { it.length } )  // sumBy takes a lambda that declares how elements of list should be summed up

    val list = listOf(1,2,3)
    val mutableList = list.toMutableList()

    val myList = listOf("a","b","c")
    println ( myList.joinToString("-") )

}

fun exampleMapping() {
    val cures: Map<String, String> = mapOf("white spot" to "Ich", "red spot" to "hole disease")
    println( cures["white spot"] )

    println( cures.getOrDefault("bloating", "sorry I don't know") )

    println( cures.getOrElse("bloating", { "this code is executed" }) )

    val inventory : MutableMap<String, Int> = mutableMapOf("fish net" to 1)
    inventory.put("tank scrubber", 3)
    inventory.remove("fish net")
}
