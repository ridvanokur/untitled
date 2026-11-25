package org.example.app

fun main() {

  val agac ="""  
             *
           ***
         *****
   """
    // 3 tane çift tırnak kullanımı (raw string) göründüğü gibi yazdırır

    val agac2 ="""
             *
           ***
         *****
   """.trimIndent()
    // 3 tane çift tırnak kullanımı (raw string) göründüğü gibi yazdırır
    // ama sol kenar bnoşlugu siler

    println("$agac$agac2")
}