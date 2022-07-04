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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.ui.binding.FragmentBinding
import com.udacity.shoestore.ui.shoes.ShoesViewModel

class ShoesListFragment : Fragment(R.layout.fragment_shoes_list), View.OnClickListener, MenuProvider {

    private val binding by FragmentBinding(FragmentShoesListBinding::bind)
    private val viewModel: ShoesViewModel by activityViewModels()
    private var shoesAdapter: ShoesAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupMenu()
        setListeners()
        setRecyclerView()
        observeViewModel()
    }

    private fun setListeners() {
        binding.fabAdd.setOnClickListener(this)
    }

    private fun setupMenu() {
        requireActivity().addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun setRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = ShoesAdapter().apply { shoesAdapter = this }
        }
    }

    private fun observeViewModel() {
        viewModel.shoesList.observe(viewLifecycleOwner) { it?.let { updateShoesList(it) } }
    }

    private fun updateShoesList(shoesList: List<Shoe>) {
        shoesAdapter?.submitList(shoesList)
    }

    // View.OnClickListener
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.fabAdd -> findNavController().navigate(ShoesListFragmentDirections.actionShoesListFragmentToShoeDetailsFragment())
        }
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