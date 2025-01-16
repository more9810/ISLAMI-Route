package com.example.islami.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.adapters.quran.QuranRecycler
import com.example.islami.databinding.FragmentQuranBinding
import com.example.islami.models.DataManger
import com.example.islami.ui.activity.SuraDetailsActivity
import com.example.islami.utils.Const

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
        adapter.onItemClickListener = QuranRecycler.OnItemClickListener { position, quran ->
            val intent = Intent(requireContext(), SuraDetailsActivity::class.java)
            intent.putExtra(Const.QURAN_KEY,quran)
            startActivity(intent)
        }
    }




}