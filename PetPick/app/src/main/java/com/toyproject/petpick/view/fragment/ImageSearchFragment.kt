package com.toyproject.petpick.view.fragment

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.toyproject.petpick.data.Image
import com.toyproject.petpick.databinding.FragmentImageSearchBinding
import com.toyproject.petpick.view.activity.ImageSearchActivity

class ImageSearchFragment : Fragment() {
    private var _binding : FragmentImageSearchBinding? = null
    private val binding get() = _binding!!
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                val intent = checkNotNull(it.data)
                val imageUri = intent.data
                Log.d("Image", "${imageUri}")
                Image.image = imageUri
                startActivity(Intent(activity, ImageSearchActivity::class.java))
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentImageSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pngLoad.setOnClickListener {
            val intent = Intent().also { intent ->
                intent.type = Image.TYPE
                intent.action = Intent.ACTION_GET_CONTENT
            }
            resultLauncher.launch(intent)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}