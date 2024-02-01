package com.example.coursework4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coursework4.databinding.ItemBinding

class ItemAdapter(private val items: MutableList<KakaoDocuments>) :
    RecyclerView.Adapter<ItemAdapter.Holder>() {


    inner class Holder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val imageView: ImageView = binding.imageView
        val tvUrl: TextView = binding.tvUrl
        val tvTime: TextView = binding.tvTime



        fun bind(item: KakaoDocuments) {
            Glide.with(itemView.context)
                .load(item.thumbnailUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView)

            tvUrl.text = item.thumbnailUrl
            tvTime.text = item.datetime


        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding: ItemBinding = ItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]
        holder.bind(item)

    }

    override fun getItemCount(): Int = items.size

    fun setItems(searchItems: List<KakaoDocuments>) {
        items.clear()
        items.addAll(searchItems)
        notifyDataSetChanged()
    }

}

