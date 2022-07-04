package com.udacity.shoestore.ui.login

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import com.udacity.shoestore.ui.binding.FragmentBinding

class LoginFragment : Fragment(R.layout.fragment_login), View.OnClickListener, TextView.OnEditorActionListener {

    private val binding by FragmentBinding(FragmentLoginBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {
        binding.btnSignIn.setOnClickListener(this)
        binding.btnSignUp.setOnClickListener(this)
        binding.tilPassword.editText?.setOnEditorActionListener(this)
    }

    // View.OnClickListener
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnSignIn -> findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            R.id.btnSignUp -> findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }
    }

    // TextView.OnEditorActionListener
    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?) =
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            true
        } else {
            false
        }
}