package com.toyproject.petpick.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.toyproject.petpick.R
import com.toyproject.petpick.databinding.ActivityBreedRecommendationListBinding

class BreedRecommendationListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBreedRecommendationListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityBreedRecommendationListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}