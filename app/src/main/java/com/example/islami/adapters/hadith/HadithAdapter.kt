package com.example.islami.adapters.hadith

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.databinding.ItemHadithBinding
import com.example.islami.models.Hadith

class HadithAdapter : RecyclerView.Adapter<HadithAdapter.HadithViewHolder>() {

    private var item: List<Hadith> = emptyList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadithViewHolder {
        return HadithViewHolder(
            ItemHadithBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount() = item.size

    override fun onBindViewHolder(holder: HadithViewHolder, position: Int) {
        holder.bindView(item[position],position,onItemClick)
    }

    fun setItem(newItem: List<Hadith>) {
        item = newItem
    }

    class HadithViewHolder(private val binding: ItemHadithBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindView(hadith: Hadith, position: Int,onItemClick:((Int, Hadith)->Unit)?){
            binding.tvTitle.text = hadith.title
            binding.tvContent.text = hadith.content
            binding.root

            binding.root.setOnClickListener {
                onItemClick?.invoke(position,hadith)
            }
            binding.tvContent.setOnClickListener {
                onItemClick?.invoke(position,hadith)
            }
        }


    }
    var onItemClick: ((Int,Hadith) -> Unit)? = null
    fun interface OnClickItem {
        fun onItemClicked(position: Int,hadith: Hadith)
    }
}