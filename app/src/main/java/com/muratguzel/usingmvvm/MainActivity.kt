package com.muratguzel.usingmvvm

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.muratguzel.usingmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainActivityNesnesi = this
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.hesaplamaSonucu = "0"

    }

    fun sum(alinanSayi1: String, alinanSayi2: String) {
        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()
        val sonuc = sayi1 + sayi2
        binding.hesaplamaSonucu = sonuc.toString()
    }

    fun subtraction(alinanSayi1: String, alinanSayi2: String) {
        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()
        val sonuc = sayi1 - sayi2
        binding.hesaplamaSonucu = sonuc.toString()
    }
}