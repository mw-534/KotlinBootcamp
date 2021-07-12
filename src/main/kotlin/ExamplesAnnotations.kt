/*@file:JvmName("InteropFish")

class InteropFish {
    companion object {
        @JvmStatic fun interop() {

        }
    }
}*/




@ImAPlant class Plant {
    fun trim() {}
    fun fertilize() {}

    @get:OnGet
    val isGrowing: Boolean = true

    @set:OnSet
    var needsFoot: Boolean = false
}

annotation class ImAPlant  // a definition of an annotation which can be applied on classes

@Target(AnnotationTarget.PROPERTY_GETTER)  // an annotation which can only be  applied on getter
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)  // an annotation applied only on setter
annotation class OnSet

fun reflection() {
    val classObj = Plant::class

    // print all annotations
    for (annotation in classObj.annotations) {
        println(annotation.annotationClass.simpleName)
    }

    // find one annotation, or null
    /*val annotated: ImAPlant? = classObj.findAnnotation<ImAPlant>()

    annotated?.apply {
        println("Found a plant annotation!")
    }*/

}