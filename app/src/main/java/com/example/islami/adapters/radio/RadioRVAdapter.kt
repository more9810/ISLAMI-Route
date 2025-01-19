package com.example.islami.adapters.radio

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.R
import com.example.islami.databinding.ItemRadioBinding

class RadioRVAdapter:RecyclerView.Adapter<RadioRVAdapter.RadioViewHolder>() {
    private var item:List<String> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioViewHolder {
        return RadioViewHolder(ItemRadioBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount() = item.size

    override fun onBindViewHolder(holder: RadioViewHolder, position: Int) {
        holder.bindView(item[position], onItemClick)
    }

    fun setItem(newItem: List<String>) {
        item = newItem
        notifyDataSetChanged()
    }

    class RadioViewHolder(private val binding:ItemRadioBinding):RecyclerView.ViewHolder(binding.root) {
        fun bindView(item: String ,onItemClick:((Int,Boolean)->Unit)?) {
            var isPlay =false
            var isMute =false
            binding.rvRadioName.text = item

            binding.imvPlay.setOnClickListener {
                if (!isPlay){
                    binding.imvPlay.setImageResource(R.drawable.ic_pause)
                    isPlay = true
                }
                else{
                    binding.imvPlay.setImageResource(R.drawable.ic_poly_gon)
                    isPlay = false
                }
            }
            binding.imvMute.setOnClickListener {
                if (!isMute){                    binding.imvMute.setImageResource(R.drawable.ic_mute)

                    isMute = true
                }
                else{                    binding.imvMute.setImageResource(R.drawable.ic_volume_high)

                    isMute = false
                }
            }


        }
    }
    var onItemClick: ((Int,Boolean)->Unit)? = null
    fun interface OnItemClickListener{
        fun onItemClick(position: Int, state:Boolean)
    }
}