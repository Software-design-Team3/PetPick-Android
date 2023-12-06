package com.toyproject.petpick.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.toyproject.petpick.R
import com.toyproject.petpick.databinding.ActivityMainBinding
import com.toyproject.petpick.view.fragment.ImageSearchFragment
import com.toyproject.petpick.view.fragment.RecommandFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().add(R.id.frame, ImageSearchFragment()).commitAllowingStateLoss()
        binding.bottomNavigation.selectedItemId = R.id.menu_image_search

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_home->{
                    Toast.makeText(this, "미구현", Toast.LENGTH_SHORT).show()
                }
                R.id.menu_image_search->{
                    supportFragmentManager.beginTransaction().replace(R.id.frame, ImageSearchFragment())
                        .commitAllowingStateLoss()
                }
                R.id.menu_recommand->{
                    supportFragmentManager.beginTransaction().replace(R.id.frame, RecommandFragment())
                        .commitAllowingStateLoss()
                }
                R.id.menu_mypage->{
                    Toast.makeText(this, "미구현", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }
    }
}