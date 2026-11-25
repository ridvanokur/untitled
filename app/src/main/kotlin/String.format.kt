package org.example.app

import java.util.Locale

fun main() {

        // String.format metodu ile yeni bir string oluşturduk
        //veri tipine göre %s string  %d integer  %f float double %n yeni satır

    val yas= 30
    val mesaj = String.format("yas %d",yas)
    println(mesaj)

    val boy= 1.75
    val mesajboy = String.format("boy %.2f",boy)
    println(mesajboy)

    // Burada para birimlerine String.format metodu ile nokta virgül ayrımı oldu
    //farklı para birimlerinde işaretler değişir locali tanımlamak lazım

    val sayi = 1234567.89

    val localUS = Locale.forLanguageTag("us-US")
    val formatUS = String.format(localUS, "US format %,.2f", sayi)
    println(formatUS)

    val localTR = Locale.forLanguageTag("tr-TR")
    val formatTR = String.format(localTR, "TR format %,.2f", sayi)
    println(formatTR)
}