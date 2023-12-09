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

        answers = mutableListOf()
        for(i in 0..9) {
            answers.add(-1)
        }

        binding.pageNum.text = "${index + 1} / ${answers.size}"
        binding.question.text = "질문${index + 1}\n\n질문 본문"

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
            binding.question.text = "질문${index + 1}\n\n질문 본문"
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
            binding.question.text = "질문${index + 1}\n\n질문 본문"
        }
    }
}