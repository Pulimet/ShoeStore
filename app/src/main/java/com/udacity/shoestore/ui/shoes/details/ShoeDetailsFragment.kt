package com.udacity.shoestore.ui.shoes.details

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.ui.shoes.ShoesViewModel
import kotlinx.coroutines.launch

class ShoeDetailsFragment : Fragment(), TextView.OnEditorActionListener {

    private lateinit var binding: FragmentShoeDetailsBinding

    private val viewModel: ShoesViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        setBinding(container)
        return binding.root
    }

    private fun setBinding(container: ViewGroup?) {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_shoe_details, container, false)
        binding.viewModel = viewModel
        binding.shoe = viewModel.currentShoe
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        observeViewModel()
    }

    private fun setListeners() {
        binding.tilDescription.editText?.setOnEditorActionListener(this)
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.navigateUp.collect { findNavController().navigateUp() }
            }
        }
    }

    // TextView.OnEditorActionListener
    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?) =
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            viewModel.onEditorActionDone()
            true
        } else {
            false
        }
}