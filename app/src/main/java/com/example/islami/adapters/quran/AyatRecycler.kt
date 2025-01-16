package com.example.islami.adapters.quran

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemAyatBinding


class AyatRecycler: RecyclerView.Adapter<AyatRecycler.AyatViewHolder>(){

        private var item: List<String> = listOf()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AyatViewHolder {
            return AyatViewHolder(ItemAyatBinding.inflate(LayoutInflater.from(parent.context),parent,false))
        }

        override fun getItemCount() = item.size

        override fun onBindViewHolder(holder: AyatViewHolder, position: Int) {
            holder.bindView(item[position], position, )
        }
        fun setItem(newItem:List<String>){
            this.item = newItem
            notifyDataSetChanged()
        }

        class AyatViewHolder(private val binding: ItemAyatBinding): RecyclerView.ViewHolder(binding.root){
            @SuppressLint("SetTextI18n")
            fun bindView(aya: String,position: Int, ){
                binding.tvAya.text = "[${position+1}] ${aya} "
            }
        }

    }
