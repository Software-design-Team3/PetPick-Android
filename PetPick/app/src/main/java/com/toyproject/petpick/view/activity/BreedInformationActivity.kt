package com.toyproject.petpick.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.toyproject.petpick.R
import com.toyproject.petpick.adapter.InfoAdapter
import com.toyproject.petpick.data.Image
import com.toyproject.petpick.databinding.ActivityBreedInformationBinding

class BreedInformationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBreedInformationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBreedInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val image = "https://png.pngtree.com/element_our/20190523/ourmid/pngtree-watercolor-garland-decoration-png-free-illustration-image_1091970.jpg"

        try {
            Glide.with(this)
                .load(image)
                .error(R.drawable.recommend)
                .into(binding.petImage)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val type = intent.getIntExtra(getString(R.string.info_type), -1)

        if(type == -1){
            Toast.makeText(this, "정보를 불러오는 과정에서 문제가 발생했습니다.\n다시 시도해주세요.", Toast.LENGTH_SHORT).show()
            finish()
        }else if(type == 1){
            val imageSearchInfoTitle = listOf<String>(
                resources.getString(R.string.hereditary),
                resources.getString(R.string.personality),
                resources.getString(R.string.life),
                resources.getString(R.string.intellect),
                resources.getString(R.string.fur_type),
                resources.getString(R.string.fur_loss),
                resources.getString(R.string.play))

            val tempContext = listOf<String>(
                " - 심근비대증\n - 신부전증\n - 진행성 망각 위축증\n - 피루베이트 키니아제 결핍증",
                " - 똑똑하고 예민한편\n - 타생물과 상호작용이 잘 되는 편",
                " - 9~13년",
                " - 1위",
                " - 단모\n - 장모",
                " - 적은 편",
                " - 캣휠\n - 층이 많은 캣타워 돌아다니기\n - 먹이퍼즐")

            val adapter = InfoAdapter(imageSearchInfoTitle, tempContext)
            binding.info.adapter = adapter
        }else{
            val recommendInfoTitle = listOf(
                resources.getString(R.string.week),
                resources.getString(R.string.hereditary),
                resources.getString(R.string.personality),
                resources.getString(R.string.life),
                resources.getString(R.string.intellect),
                resources.getString(R.string.fur_type),
                resources.getString(R.string.fur_loss),
                resources.getString(R.string.play))

            val tempContext = listOf<String>(
                " - 생활방식(외향형/내향형)\n - 활동량",
                " - 심근비대증\n - 신부전증\n - 진행성 망각 위축증\n - 피루베이트 키니아제 결핍증",
                " - 똑똑하고 예민한편\n - 타생물과 상호작용이 잘 되는 편",
                " - 9~13년",
                " - 1위",
                " - 단모\n - 장모",
                " - 적은 편",
                " - 캣휠\n - 층이 많은 캣타워 돌아다니기\n - 먹이퍼즐")
            val adapter = InfoAdapter(recommendInfoTitle, tempContext)
            binding.info.adapter = adapter
        }

        binding.home.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}