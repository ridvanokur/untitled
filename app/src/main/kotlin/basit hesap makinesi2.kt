package org.example.app

fun main() {

    println("HESAP MAKİNESİNE HOŞGELDİNİZ\n")
    startUser()
}

fun startUser() {

    print("Birinci Sayiyi giriniz:")
    val number1 = readln().trim().toDoubleOrNull()
    if (number1 == null) {
        println("sadece sayı giriniz")
        return
    }
    print("Operatör seçiniz: +, -, *, /, %")
    val operation = readln().trim()
    if (operation !in listOf<Any>("+", "-", "*", "/", "%")) {
        println("Yanlış Operatör seçimi yaptınız")
        return
    }

    print("İkinci sayiyi giriniz:")
    val number2 = readln().trim().toDoubleOrNull()
    if (number2 == null) {
        println("Sadece sayi giriniz !!!")
        return
    }
    val sonuc = when (operation) {
        "+" -> number1 + number2
        "-" -> number1 - number2
        "*" -> number1 * number2
        "/" -> if (number2 != 0.0) {
            number1 / number2
        } else {
            "Tanımsız"
        }

        "%" -> if (number2 != 0.0) {
            number1 % number2
        } else {
            "Mod işlemde sıfır bölen olmaz"
        }

        else -> "Hatalı işlem"

    }
    println(sonuc)
    tercih()
}

fun tercih() {
    println("Devam veya Çıkış  Y / N")
    when (readln().trim().uppercase()) {
        "Y" -> {
            startUser()
        }

        "N" -> {
            println("Çıkış yapılıyor !!!")
        }

        else -> {
            println("Yanlış tercih yaptınız !!!")
            tercih()
        }
    }
}

