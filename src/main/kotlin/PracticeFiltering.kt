fun main(args: Array<String>)
{
    val spices = listOf("curry","pepper","cayenne","ginger","red curry","green curry","red pepper")
    val curries = spices.filter{ it.contains("curry") }.sortedBy{ it.length }
    val ce1 = spices.filter{it.startsWith('c')}.filter { it.endsWith('e') }
    val ce2 = spices.filter{it.startsWith('c') && it.endsWith('e')}
    val ce3 = spices.filter{it.startsWith('c').and(it.endsWith('e'))}
    val cStart3_0 = spices.take(3).filter{it.startsWith('c')}
    val cStart3_1 = spices.subList(0,3).filter{it[0] == 'c'}
}

