package com.example.islami.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.adapters.hadith.HadithAdapter
import com.example.islami.databinding.FragmentHadithBinding
import com.example.islami.models.DataManger.readFromAsset
import com.example.islami.models.Hadith
import com.example.islami.ui.activity.HadithDetailsActivity
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper


class HadithFragment : Fragment() {
    private val hadithList: MutableList<Hadith> = mutableListOf()
    private lateinit var binding: FragmentHadithBinding
    private lateinit var adapter: HadithAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHadithBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
        initAdapter()
    }

    private fun initAdapter() {
        adapter = HadithAdapter()
        adapter.setItem(hadithList)
        binding.rvHadith.setHasFixedSize(true)
        binding.rvHadith.layoutManager = CarouselLayoutManager()
        CarouselSnapHelper().attachToRecyclerView(binding.rvHadith)
        binding.rvHadith.adapter = adapter

        adapter.onItemClick = { positin, content ->
            val intent = Intent(activity,HadithDetailsActivity::class.java )
            intent.putExtra("HADITH",content)
            startActivity(intent)
        }

    }

    private fun getData() {
        val fileContent = activity?.readFromAsset("hadith/ahadeth.txt")?.trim() ?: return
        val listOfHadith = fileContent.trim().split("#")

        listOfHadith.forEach { singleHadith ->
            val lines = singleHadith.trim().split("\n")
            val title = lines[0]
            val content = lines.takeLast(lines.size - 1).joinToString("\n")
            hadithList.add(Hadith(title, content))
        }

    }


}