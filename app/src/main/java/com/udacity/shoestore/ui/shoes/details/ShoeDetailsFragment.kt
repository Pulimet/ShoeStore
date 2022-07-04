package com.udacity.shoestore.ui.shoes.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.ui.binding.FragmentBinding

class ShoeDetailsFragment : Fragment(R.layout.fragment_shoe_details) {

    private val binding by FragmentBinding(FragmentShoeDetailsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}