package com.pujaditya.foodmarket.ui.auth.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.pujaditya.foodmarket.R
import com.pujaditya.foodmarket.databinding.FragmentSignUpAddressBinding
import com.pujaditya.foodmarket.databinding.FragmentSignUpBinding
import com.pujaditya.foodmarket.ui.auth.AuthActivity


class SignUpAddressFragment : Fragment() {

    private lateinit var binding: FragmentSignUpAddressBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpAddressBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.btnSignup.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_sign_up_success)
            (activity as AuthActivity).toolbarSignUpAddress()
        }
    }

}