package com.udacity.shoestore.ui.shoes.details

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.ui.binding.FragmentBinding
import com.udacity.shoestore.ui.shoes.ShoesViewModel

class ShoeDetailsFragment : Fragment(R.layout.fragment_shoe_details), View.OnClickListener,
    TextView.OnEditorActionListener {

    private val binding by FragmentBinding(FragmentShoeDetailsBinding::bind)
    private val viewModel: ShoesViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        binding.btnCancel.setOnClickListener(this)
        binding.btnSave.setOnClickListener(this)
        binding.tilDescription.editText?.setOnEditorActionListener(this)
    }

    private fun saveShoeAndGoBack() {
        viewModel.addShoe(
            binding.tilShoeName.editText?.text?.toString() ?: "",
            binding.tilCompany.editText?.text?.toString() ?: "",
            binding.tilShowSize.editText?.text?.toString() ?: "",
            binding.tilDescription.editText?.text?.toString() ?: "",
        )
        findNavController().navigateUp()
    }

    // View.OnClickListener
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnCancel -> findNavController().navigateUp()
            R.id.btnSave -> saveShoeAndGoBack()
        }
    }

    // TextView.OnEditorActionListener
    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?) =
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            saveShoeAndGoBack()
            true
        } else {
            false
        }
}