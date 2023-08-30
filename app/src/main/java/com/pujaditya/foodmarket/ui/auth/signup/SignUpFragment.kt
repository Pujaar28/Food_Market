package com.pujaditya.foodmarket.ui.auth.signup

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.pujaditya.foodmarket.R
import com.pujaditya.foodmarket.databinding.FragmentSignInBinding
import com.pujaditya.foodmarket.databinding.FragmentSignUpBinding
import com.pujaditya.foodmarket.ui.auth.AuthActivity


class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.btnContinue.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_sign_up_address)
            (activity as AuthActivity).toolbarSignUpAddress()
        }
    }

}