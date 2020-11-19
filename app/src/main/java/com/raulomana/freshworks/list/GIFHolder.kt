package com.raulomana.freshworks.list

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.raulomana.api.model.GIF
import com.raulomana.freshworks.R
import com.raulomana.freshworks.databinding.ItemGifBinding

class GIFHolder(private val binding: ItemGifBinding, val listener: (GIF) -> Unit) : RecyclerView.ViewHolder(binding.root) {

    fun bind(gif: GIF) {
        Glide.with(binding.itemGifImage)
            .load(gif.images.downsized.url)
            .centerInside()
            .placeholder(R.color.colorAccent)
            .into(binding.itemGifImage)

        binding.itemGifFavAction.isSelected = gif.favorite
        binding.itemGifFavAction.setOnClickListener{
            gif.favorite = !gif.favorite
            binding.itemGifFavAction.isSelected = gif.favorite
            listener(gif)
        }
    }

}