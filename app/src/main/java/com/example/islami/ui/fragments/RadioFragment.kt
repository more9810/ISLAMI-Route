package com.example.islami.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.adapters.radio.RadioRVAdapter
import com.example.islami.databinding.FragmentRadioBinding

class RadioFragment : Fragment() {
    private lateinit var binding: FragmentRadioBinding
    private lateinit var adapter: RadioRVAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentRadioBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list:List<String> = listOf("Mohamed","Mohamed","Mohamed","Mohamed","Mohamed","Mohamed",)
        adapter = RadioRVAdapter()
        adapter.setItem(list)
        binding.rvRadio.adapter =adapter

    }

}