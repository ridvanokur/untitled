package org.example.app

fun main() {

    println("veri girin")

    when (val x = readln()) {

        is String -> print("kelime uzunluk: " + x.length + " \n" + x)
    }
    val red1 = "\u001b[31m"
    val red2 = "\u001b[0m"
    val kalp = '\u2764'
    print("$red1$kalp$red2")
}