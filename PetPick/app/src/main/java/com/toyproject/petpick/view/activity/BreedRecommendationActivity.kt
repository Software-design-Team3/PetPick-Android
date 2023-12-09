package com.toyproject.petpick.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.toyproject.petpick.R
import com.toyproject.petpick.databinding.ActivityBreedRecommendationBinding

class BreedRecommendationActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBreedRecommendationBinding
    private lateinit var answers : MutableList<Int>
    private var index = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBreedRecommendationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val question = listOf<String>(
            "집에 사람이 있는 시간\n(수면시간 제외)",
            "거주 환경",
            "예상 월 금전 사용량\n(입양단가, 의료비용, 용품값)",
            "집에서 다른 개 혹은 고양이를 기르고 있는가?\n(풀어놓고 기르는 애완동물 포함)",
            "가족 중 알레르기가 있는가",
            "가족 구성원 중 애완동물을 키우고 싶어하는 사람은 누구인가",
            "애완동물과의 산책",
            "키워본 경험"
        )

        answers = mutableListOf()
        for(i in question.indices) {
            answers.add(-1)
        }

        binding.pageNum.text = "${index + 1} / ${answers.size}"
        binding.question.text = "질문${index + 1}\n\n${question[index]}"

        binding.home.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

        binding.checkButtons.setOnCheckedChangeListener { group, checkedId ->
            Log.d("RadioBtn", checkedId.toString())
            var check = answers.find { it == -1 }
            if(check == null){
                binding.recommandResult.visibility = View.VISIBLE
            }
        }

        binding.recommandResult.setOnClickListener {
            val intent = Intent(this, BreedRecommendationListActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.previous.setOnClickListener {
            if(index == 0){
                Toast.makeText(this, "첫 번째 질문입니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            answers[index] = binding.checkButtons.checkedRadioButtonId
            index--
            binding.checkButtons.clearCheck()
            if(answers[index] != -1){
                binding.checkButtons.check(answers[index])
            }
            binding.pageNum.text = " ${index + 1} / ${answers.size}"
            binding.question.text = "질문${index + 1}\n\n${question[index]}"
        }

        binding.next.setOnClickListener {
            if(index == answers.size -1) {
                Toast.makeText(this@BreedRecommendationActivity, "마지막 질문입니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            answers[index] = binding.checkButtons.checkedRadioButtonId
            index++
            binding.checkButtons.clearCheck()
            if(answers[index] != -1){
                binding.checkButtons.check(answers[index])
            }
            binding.pageNum.text = " ${index + 1} / ${answers.size}"
            binding.question.text = "질문${index + 1}\n\n${question[index]}"
        }
    }
}