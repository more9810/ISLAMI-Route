package com.example.islami.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.islami.R
import com.example.islami.adapters.quran.QuranRecycler
import com.example.islami.databinding.FragmentQuranBinding
import com.example.islami.models.DataManger

class QuranFragment : Fragment() {
    private lateinit var adapter: QuranRecycler
    private lateinit var binding: FragmentQuranBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentQuranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup() {
        adapter = QuranRecycler()
        adapter.setItem(DataManger.getAllSura())
        binding.rvSuraName.adapter = adapter

        openSura()

    }

    private fun openSura() {


        activity?.redAssets("114")
    }

    private fun Context.redAssets(name: String): String {
        return assets.open("$name.txt").bufferedReader().use {
            it.readText()
        }
    }


}