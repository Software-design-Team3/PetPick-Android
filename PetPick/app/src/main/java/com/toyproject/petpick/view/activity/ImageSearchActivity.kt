package com.toyproject.petpick.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.toyproject.petpick.R
import com.toyproject.petpick.data.Image
import com.toyproject.petpick.databinding.ActivityImageSearchBinding

class ImageSearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageSearchBinding
    private var imageCheck = false
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val image = checkNotNull(Image.image)

        Glide.with(this)
            .load(image)
            .into(binding.galleryImage)
        imageCheck = true

        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                val intent = checkNotNull(it.data)
                val imageUri = intent.data
                Log.d("Image", "${imageUri}")
                Image.image = imageUri
                imageCheck = true
                Glide.with(this)
                    .load(Image.image)
                    .into(binding.galleryImage)
            }
        }

        binding.pngLoad.setOnClickListener {
            val intent = Intent().also { intent ->
                intent.type = Image.TYPE
                intent.action = Intent.ACTION_GET_CONTENT
            }
            resultLauncher.launch(intent)
        }

        binding.breedAnalysis.setOnClickListener {
            if(imageCheck){
                val intent = Intent(this, BreedInformationActivity::class.java)
                intent.putExtra(resources.getString(R.string.info_type), 1)
                startActivity(intent)
            }else{
                Toast.makeText(this, "이미지를 불러와주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}