package com.example.islami.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islami.databinding.FragmentSiphaBinding


class SiphaFragment : Fragment() {
    private lateinit var binding: FragmentSiphaBinding
    private var rotation = 0f
    private var countZikr = 0
    private var count = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSiphaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.tvCountZikr.text = "$countZikr"

        binding.imvSipha.setOnClickListener {
            setupRotation()
        }

    }

    private val zikrList = listOf(
        "سبحان الله", "الحمدلله", "الله اكبر", "لا اله الا الله"
    )

    private fun updateZikrText() {
        binding.tvZikr.text = zikrList[count / 33 % zikrList.size]
    }

    private fun setupRotation() {
        updateZikrText()
        count++
        count %= 100
        val zikrIndex = count / 33
        binding.tvZikr.text = zikrList[zikrIndex % zikrList.size]
        Log.d("more1010", count.toString())
        if (countZikr >= 33) {
            countZikr = 0
            binding.tvCountZikr.text = "$countZikr"
            rotation = 0.0f
            binding.imvSipha.rotation = rotation
        } else {
            countZikr += 1

            binding.tvCountZikr.text = "$countZikr"
            rotation += 360 / 33f
            binding.imvSipha.rotation = rotation
            if (count % 33 == 0 && count != 0) {
                countZikr = 0
                rotation = 0.0f
                binding.tvCountZikr.text = "$countZikr"
                binding.imvSipha.rotation = rotation
            }
            if (count == 0) countZikr = 0

        }

    }

}