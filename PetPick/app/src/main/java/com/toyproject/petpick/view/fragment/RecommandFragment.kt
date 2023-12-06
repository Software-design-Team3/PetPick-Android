package com.toyproject.petpick.view.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.toyproject.petpick.R
import com.toyproject.petpick.databinding.ActivityBreedRecommendationBinding
import com.toyproject.petpick.databinding.FragmentRecommandBinding
import com.toyproject.petpick.view.activity.BreedRecommendationActivity

class RecommandFragment : Fragment() {
    private var _binding : FragmentRecommandBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecommandBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recommandBtn.setOnClickListener {
            startActivity(Intent(activity, BreedRecommendationActivity::class.java))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}