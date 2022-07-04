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
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.ui.shoes.ShoesViewModel

class ShoeDetailsFragment : Fragment(), View.OnClickListener,
    TextView.OnEditorActionListener {

    private lateinit var binding: FragmentShoeDetailsBinding

    private val viewModel: ShoesViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_shoe_details, container, false)
        return binding.root
    }


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
        val sizeString = binding.tilShowSize.editText?.text?.toString()
        val size = if (sizeString.isNullOrEmpty()) "0" else sizeString
        viewModel.addShoe(
            binding.tilShoeName.editText?.text?.toString() ?: "",
            binding.tilCompany.editText?.text?.toString() ?: "",
            size,
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