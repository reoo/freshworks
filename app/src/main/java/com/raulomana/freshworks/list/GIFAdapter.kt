package com.raulomana.freshworks.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raulomana.api.model.GIF
import com.raulomana.freshworks.databinding.ItemGifBinding

class GIFAdapter(private val data: List<GIF>, private val listener: (GIF) -> Unit) : RecyclerView.Adapter<GIFHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GIFHolder {
        val binding: ItemGifBinding = ItemGifBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GIFHolder(binding, listener)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: GIFHolder, position: Int) {
        holder.bind(data[position])
    }
}