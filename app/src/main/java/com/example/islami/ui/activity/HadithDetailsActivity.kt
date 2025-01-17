package com.example.islami.ui.activity

import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.islami.R
import com.example.islami.databinding.ActivityHadithDetailsBinding
import com.example.islami.models.Hadith

class HadithDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHadithDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadithDetailsBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val hadith = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent?.getParcelableExtra("HADITH", Hadith::class.java)
        } else {
            intent?.getParcelableExtra("HADITH")
        }

        if (hadith != null) {

            binding.tvTitle.text = hadith.title
            binding.tvContent.text = hadith.content

        }
    }
}