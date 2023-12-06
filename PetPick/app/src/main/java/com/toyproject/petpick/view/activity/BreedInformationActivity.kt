package com.toyproject.petpick.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.toyproject.petpick.R
import com.toyproject.petpick.databinding.ActivityBreedInformationBinding

class BreedInformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBreedInformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBreedInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.home.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}