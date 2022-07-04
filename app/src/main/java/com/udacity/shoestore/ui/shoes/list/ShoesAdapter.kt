package com.udacity.shoestore.ui.shoes.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe

class ShoesAdapter : ListAdapter<Shoe, ShoeHolder>(ShoeDiff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_shoe, parent, false)
        return ShoeHolder(v)
    }

    override fun onBindViewHolder(holder: ShoeHolder, position: Int) {
        holder.onBindViewHolder(getItem(position))
    }
}