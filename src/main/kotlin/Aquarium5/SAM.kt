package Aquarium5

// SAM stands for Single Abstract Method
// it means an interface that has exactly one method and the method is abstract
// e.g. Runnable is such an interface
// the syntax object: classname lets instantiate an object that implements an interface
fun exampleSAM()
{
    val runnable = object: Runnable {
        override fun run() {
            println("I'm a runnable")
        }
        JavaRun.runNow(runnable)

        // instead of instantiating a SAM Kotlin allows to just pass a lambda as an argument to a parameter which expects a SAM
        JavaRun.runNow { println("Passing a lambda as a runnable") }

    }

}