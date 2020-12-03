package machine

class CoffeeMachine(
    private var water: Int = 400,
    private var milk: Int = 540,
    private var coffee: Int = 120,
    private var cups: Int = 9,
    private var money: Int = 550
) {

    private enum class CoffeeType(
        val water: Int,
        val milk: Int,
        val coffee: Int,
        val price: Int
    ) {
        ESPRESSO(250, 0, 16, 4),
        LATTE(350, 75, 20, 7),
        CAPPUCCINO(200, 100, 12, 6)
    }

    fun requestAction() {
        print("Write action (buy, fill, take): ")
        when (readLine()!!) {
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
        }
    }

    private fun buy() {
        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
        when (readLine()!!.toInt()) {
            1 -> buyCoffee(CoffeeType.ESPRESSO)
            2 -> buyCoffee(CoffeeType.LATTE)
            3 -> buyCoffee(CoffeeType.CAPPUCCINO)
        }
    }

    private fun buyCoffee(coffeeType: CoffeeType) {
        water -= coffeeType.water
        milk -= coffeeType.milk
        coffee -= coffeeType.coffee
        cups--
        money += coffeeType.price
    }

    private fun fill() {
        print("Write how many ml of water do you want to add: "); water += readLine()!!.toInt()
        print("Write how many ml of milk do you want to add: "); milk += readLine()!!.toInt()
        print("Write how many grams of coffee beans do you want to add: "); coffee += readLine()!!.toInt()
        print("Write how many disposable cups of coffee do you want to add: "); cups += readLine()!!.toInt()
        println()
    }

    private fun take() {
        println("I gave you $$money")
        println()
        money = 0
    }

    fun printState() {
        println(this)
        println()
    }

    override fun toString(): String {
        return """The coffee machine has: 
            |$water of water
            |$milk of milk
            |$coffee of coffee beans
            |$cups of disposable cups
            |$money of money
        """.trimMargin()
    }
}

fun main() {
    val coffeeMachine = CoffeeMachine()

    coffeeMachine.printState()

    coffeeMachine.requestAction()

    coffeeMachine.printState()
}