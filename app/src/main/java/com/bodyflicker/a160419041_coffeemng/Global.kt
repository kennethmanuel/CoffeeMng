package com.bodyflicker.a160419041_coffeemng

object Global {
    var queue = 0

    val coffee_types: Array<CoffeeType> = arrayOf(
        CoffeeType(1, "Cappuccino"),
        CoffeeType(2, "Vanilla Latte"),
        CoffeeType(3, "Mochaccino"),
        CoffeeType(4, "Americano"),
        CoffeeType(5, "Black")
    )

    // INTENT
    val COFFEE_TYPE = "coffeetype"
    val COFFEE_EXTRA = "coffeeextra"
    val QUEUE = "queue"
    val COFFEE_SYRUP = "coffeesyrup"
    val COFFEE_PRICE = "coffeeprice"
}