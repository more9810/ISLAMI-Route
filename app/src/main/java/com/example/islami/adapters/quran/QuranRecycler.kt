package com.example.islami.adapters.quran

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemQuranNameBinding

class QuranRecycler: RecyclerView.Adapter<QuranRecycler.QuranViewHolder>(){

    private var item: List<Quran> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranViewHolder {
        return QuranViewHolder(ItemQuranNameBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount() = item.size

    override fun onBindViewHolder(holder: QuranViewHolder, position: Int) {
        holder.bindView(item[position], position, onItemClickListener)
    }
    fun setItem(newItem:List<Quran>){
        this.item = newItem
        notifyDataSetChanged()
    }

    class QuranViewHolder(private val binding: ItemQuranNameBinding): RecyclerView.ViewHolder(binding.root){
        @SuppressLint("SetTextI18n")
        fun bindView(quran: Quran,position: Int, onItemClickListener: OnItemClickListener?){
            binding.tvVersesCount.text = "${quran.ayatCounts} Verses"
            binding.tvSuraArNem.text = quran.suraNameAr
            binding.tvSuraEnName.text = quran.suraNameEn
            binding.tvSuraNumber.text = quran.suraNumber

            if (onItemClickListener == null)return
            binding.root.setOnClickListener {
                onItemClickListener.onClickItem(position,quran)
            }
        }
    }

    var onItemClickListener: OnItemClickListener? = null
    fun interface OnItemClickListener{
        fun onClickItem(position: Int,quran: Quran)
    }
}