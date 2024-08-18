package com.muratguzel.usingmvvm

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.muratguzel.usingmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainActivityNesnesi = this
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel.sonuc.observe(this){sonuc->
            binding.hesaplamaSonucu = sonuc

        }
    }

    fun sumButtonClicked(alinanSayi1: String, alinanSayi2: String){
        viewModel.sum(alinanSayi1,alinanSayi2)
    }

    fun subtractionButtonClicked(alinanSayi1: String, alinanSayi2: String) {
        viewModel.subtraction(alinanSayi1,alinanSayi2)
    }
}