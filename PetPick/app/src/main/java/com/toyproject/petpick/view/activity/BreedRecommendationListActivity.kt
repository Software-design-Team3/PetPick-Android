package com.toyproject.petpick.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.toyproject.petpick.R
import com.toyproject.petpick.adapter.RecommandAdapter
import com.toyproject.petpick.data.RecommandListItem
import com.toyproject.petpick.databinding.ActivityBreedRecommendationListBinding

class BreedRecommendationListActivity : AppCompatActivity(),
    RecommandAdapter.OnPercentButtonClickListener {
    private lateinit var binding: ActivityBreedRecommendationListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityBreedRecommendationListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = mutableListOf<RecommandListItem>()
        for(i in 0..10){
            data.add(RecommandListItem(
                "https://png.pngtree.com/element_our/20190523/ourmid/pngtree-watercolor-garland-decoration-png-free-illustration-image_1091970.jpg",
                "Test Name $i",
                "안 맞는 점 Test",
                89.0917
                ))
        }

        val adapter = RecommandAdapter(data, this)
        binding.recommandList.adapter = adapter

    }

    override fun OnPercentButtonClickListener(data: RecommandListItem) {
        val intent = Intent(this, BreedInformationActivity::class.java)
        intent.putExtra(getString(R.string.info_type), 2)
        startActivity(intent)
    }
}