package com.udacity.shoestore.ui.shoes.list

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.databinding.ItemShoeBinding
import com.udacity.shoestore.models.Shoe

class ShoeHolder(v: View) : RecyclerView.ViewHolder(v) {
    private val binding = ItemShoeBinding.bind(v)

    @SuppressLint("SetTextI18n")
    fun onBindViewHolder(shoe: Shoe) {
        binding.tvShoeName.text = shoe.name
        binding.tvCompany.text = shoe.company
        binding.tvSize.text = "Size: ${shoe.size}"
        binding.tvDescription.text = shoe.description
    }

}