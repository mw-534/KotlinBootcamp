fun main(args: Array<String>)
{
    //filterExample()
    //eagerExample()
    exampleLambdas()
}

fun filterExample()
{
    val colors = listOf("blue","black","white")
    println(
        // filters list for all items which start with letter b
        // it = each item to be tested
        // " " is used for strings
        // ' ' is used for single characters
        // in Kotlin "" and '' are not interchangeable
        colors.filter{it[0]=='b'}
    )

    // filter is a normal higher order function filter()
    // since it only takes a lambda as argument
    // the () can be removed because the lambda
    // expression, which is the last parameter
    // of its declaration, can be moved out of the
    // () when the function is called
}

fun eagerExample() {
    val decorations = listOf ("rock", "pagoda", "plastic plant", "alligator", "flowerpot")

    // eager filtering: filter is applied immediately and new returned list
    // contains only the filtered elements
    // lazy filtering: filter is applied on each element of the
    // collection when needed. Returned list (the sequence) contains
    // all elements of the original list

    val eager = decorations.filter { it[0] == 'p'}
    println(eager)

    // apply filter lazily
    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println(filtered)  // doesn't print elements because it is lazy
    println(filtered.toList()) // prints the elements in the list because returned list is eager

    // apply map lazily
    val lazyMap = decorations.asSequence().map {
        println("map: $it")
        it
    }

    println(lazyMap)
    println("first: ${lazyMap.first()}")
    println("all: ${lazyMap.toList()}")

}

// example lambdas
fun exampleLambdas()
{
    // a lambda expression is defined in { }
    // using () on a lambda expression calls it

    { println("hello") }()

    val swim = { println("swim\n") }

    swim()

    var d = 20
    val waterFilter = { dirty: Int -> dirty / 2 }
    println(waterFilter(d))
}

// example function types
fun exampleFunctionTypes()
{
    // function type is Kotlins name for delegate
    // here we declare a variable of type function type (Int) -> Int
    // then assign a lambda to it
    // in the lambda the type of the input parameter
    // doesn't have to be specified anymore because
    // it can be inferred from the function type
    val waterFilter : (Int) -> Int = { dirty -> dirty / 2}

    var waterFilter2 : (Int) -> Int

    waterFilter2 = { dirty -> dirty / 2}

    // this is not a function type of lambda
    fun feedFish(dirty: Int) = dirty + 10

    // a higher power function is any function that
    // takes a function as an argument
    // function arguments should be the last parameter in Kotlin
    fun updateDirty( dirty : Int, operation : (Int) -> Int ) : Int {
        return operation(dirty)
    }
}