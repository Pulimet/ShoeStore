package com.udacity.shoestore.ui.shoes.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import com.udacity.shoestore.ui.binding.FragmentBinding

class ShoesListFragment : Fragment(R.layout.fragment_shoes_list) {

    private val binding by FragmentBinding(FragmentShoesListBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}