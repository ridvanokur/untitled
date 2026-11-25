package org.example.app

fun main() {

    val kelime = "Rıdvan"

    println("ilk harf  ${kelime[kelime.indices.first]}") // ilk harf alma

    println("son harf  ${kelime[kelime.indices.last]}") // ilk harf alma

    println("uzunluk ${kelime.length}")

    println("------------------")
    println(kelime[0])
    println(kelime[1])
    println(kelime[2])
    println(kelime[3])
    println(kelime[4])
    println(kelime[5])
}