package com.example.islami.ui.activity

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.islami.R
import com.example.islami.adapters.quran.AyatRecycler
import com.example.islami.adapters.quran.Quran
import com.example.islami.databinding.ActivitySuraDetilsBinding
import com.example.islami.models.DataManger.readFromAsset
import com.example.islami.utils.Const

class SuraDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySuraDetilsBinding
    private var quran: Quran? = null
    private lateinit var adapter: AyatRecycler
    private var listOfAyat:List<String> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySuraDetilsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        getQuranDetails()
        getSuraAyat(quran?.suraNumber ?: "")
        setup()
    }

    private fun setup() {
        if (quran == null) return
        binding.includedToolbar.tvTitleDetilse.text = quran?.suraNameAr
        setRecycler()
    }

    private fun setRecycler() {
        adapter = AyatRecycler()
        adapter.setItem(listOfAyat)
        binding.includedRv.rvAyat.adapter = adapter

    }

    private fun getSuraAyat(index: String) {

        val lines = readFromAsset("quran/$index.txt").trim()

        val aya = lines.split("\n")

        listOfAyat = aya

        Log.d("more1010", listOfAyat.get(0))


    }

    private fun getQuranDetails() {
        if (intent != null) quran = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Const.QURAN_KEY, Quran::class.java)
        } else {
            intent.getParcelableExtra(Const.QURAN_KEY)
        }
    }


}