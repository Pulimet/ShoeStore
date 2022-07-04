package com.udacity.shoestore.ui.shoes.list

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.ui.binding.FragmentBinding
import com.udacity.shoestore.ui.shoes.ShoesViewModel

class ShoesListFragment : Fragment(R.layout.fragment_shoes_list), MenuProvider {

    private val binding by FragmentBinding(FragmentShoesListBinding::bind)
    private val viewModel: ShoesViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupMenu()
        observeViewModel()
    }

    private fun setupMenu() {
        requireActivity().addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun observeViewModel() {
        viewModel.shoesList.observe(viewLifecycleOwner) { it?.let { updateShoesList(it) } }
    }

    private fun updateShoesList(shoesList: List<Shoe>) {

    }

    // MenuProvider
    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_shoes_list, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.action_logout -> {
                findNavController().navigate(ShoesListFragmentDirections.actionShoesListFragmentToLoginFragment())
                true
            }
            else -> false
        }
    }
}