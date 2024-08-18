package com.muratguzel.usingmvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    var sonuc =MutableLiveData("0")

    fun sum(alinanSayi1: String, alinanSayi2: String) {
        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()
        val toplam = sayi1 + sayi2
        sonuc.value = toplam.toString()
    }

    fun subtraction(alinanSayi1: String, alinanSayi2: String) {
        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()
        val cikarma = sayi1 - sayi2
        sonuc.value = cikarma.toString()
    }
}