package org.example.app

fun main() {
    println("Hesap makinesine hoş geldiniz")

    do {
        val number1 = takeUserInput("Birinci sayıyı giriniz:")
        val number2 = takeUserInput("İkinci sayıyı giriniz:")
        val operation = takeOperation()

        val result = try {
            operation.operate(number1, number2)
        } catch (e: ArithmeticException) {
            println("Hata: ${e.message}")
            null
        }

        if (result != null) {
            println("Sonuç: $number1 $operation $number2 = $result")
        }
    } while (askForContinue())
}

fun takeUserInput(message: String): Double {
    while (true) {
        println(message)
        val input = readlnOrNull()?.trim()
        val number = input?.toDoubleOrNull()

        if (number != null && number.isFinite()) {
            return number
        }

        println("Hata: Geçerli bir sayı giriniz!")
    }
}

fun takeOperation(): Operation {
    while (true) {
        println("İşlemi giriniz (+, -, *, /):")
        val symbol = readlnOrNull()?.trim().orEmpty()
        val operation = Operation.fromSymbol(symbol)

        if (operation != null) {
            return operation
        }

        println("Hata: Geçersiz işlem operatörü: '$symbol'")
    }
}

fun askForContinue(): Boolean {
    while (true) {
        println("Başka işlem yapmak ister misiniz? (E/H)")
        when (readlnOrNull()?.trim()?.uppercase()) {
            "E" -> return true
            "H" -> {
                println("Çıkış yapılıyor.")
                return false
            }
            else -> println("Hata: 'E' veya 'H' giriniz.")
        }
    }
}

sealed class Operation(val symbol: String) {

    abstract fun operate(num1: Double, num2: Double): Double

    override fun toString(): String = symbol

    data object Plus : Operation("+") {
        override fun operate(num1: Double, num2: Double): Double = num1 + num2
    }

    data object Minus : Operation("-") {
        override fun operate(num1: Double, num2: Double): Double = num1 - num2
    }

    data object Times : Operation("*") {
        override fun operate(num1: Double, num2: Double): Double = num1 * num2
    }

    data object Division : Operation("/") {
        override fun operate(num1: Double, num2: Double): Double {
            if (num2 == 0.0) {
                throw ArithmeticException("Bir sayı sıfıra bölünemez!")
            }
            return num1 / num2
        }
    }

    companion object {
        fun fromSymbol(symbol: String): Operation? = when (symbol) {
            Plus.symbol -> Plus
            Minus.symbol -> Minus
            Times.symbol -> Times
            Division.symbol -> Division
            else -> null
        }
    }
}