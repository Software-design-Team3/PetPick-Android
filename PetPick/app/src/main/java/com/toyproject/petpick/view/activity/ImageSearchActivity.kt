package com.toyproject.petpick.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.toyproject.petpick.R
import com.toyproject.petpick.databinding.ActivityImageSearchBinding

class ImageSearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageSearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pngLoad.setOnClickListener {

        }

        binding.breedAnalysis.setOnClickListener {
            startActivity(Intent(this, BreedInformationActivity::class.java))
        }
    }
}