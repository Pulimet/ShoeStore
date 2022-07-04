package com.udacity.shoestore.ui.login

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment(), View.OnClickListener, TextView.OnEditorActionListener {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_login, container, false)
        return binding.root
    }

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