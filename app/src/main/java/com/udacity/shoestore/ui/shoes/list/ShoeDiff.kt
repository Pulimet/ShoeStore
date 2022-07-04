package com.udacity.shoestore.ui.shoes.list

import androidx.recyclerview.widget.DiffUtil
import com.udacity.shoestore.models.Shoe

class ShoeDiff : DiffUtil.ItemCallback<Shoe>() {
    override fun areItemsTheSame(oldItem: Shoe, newItem: Shoe) =
        oldItem.name == newItem.name && oldItem.size == newItem.size

    override fun areContentsTheSame(oldItem: Shoe, newItem: Shoe) = oldItem == newItem
}