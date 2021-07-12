package Buildings

fun main(args: Array<String>) {
    Building(Wood()).build()
    isSmallBuilding(Building(Brick()))
}

open class BaseBuildingMaterial(){
    open val numberNeeded: Int = 1
}

class Wood : BaseBuildingMaterial() {
    override val numberNeeded = 4
}

class Brick : BaseBuildingMaterial() {
    override val numberNeeded = 8
}

class Building<T: BaseBuildingMaterial>(val buildingMaterial: T){

    val baseMaterialsNeeded: Int = 100
    val actualMaterialNeeded = baseMaterialsNeeded * buildingMaterial.numberNeeded

    fun build() {
        println("$actualMaterialNeeded ${buildingMaterial::class.simpleName} required")  // myObject::class is reflection in Kotlin
    }
}

fun <T: BaseBuildingMaterial> isSmallBuilding(building : Building<T>) {
    if (building.actualMaterialNeeded < 500) println("small building")
    else println("large building")
}