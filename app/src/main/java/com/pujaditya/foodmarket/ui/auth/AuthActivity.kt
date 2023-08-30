package com.pujaditya.foodmarket.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.pujaditya.foodmarket.R
import com.pujaditya.foodmarket.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pageRequest = intent.getIntExtra("page_request", 0)
        if (pageRequest == 2) {
            toolbarSignUp()
            val navOption = NavOptions.Builder()
                .setPopUpTo(R.id.fragmentSignIn, true)
                .build()

            Navigation.findNavController(findViewById(R.id.authHostFragment))
                .navigate(R.id.action_sign_up, null, navOption)
        }
    }

    fun toolbarSignUp() {
        binding.apply {
            toolbar.toolbar.title = "Sign Up"
            toolbar.toolbar.subtitle = "Register and eat"
            toolbar.toolbar.navigationIcon = resources.getDrawable(R.drawable.ic_arrow_back_000, null)
            toolbar. toolbar.setNavigationOnClickListener { onBackPressed() }
        }
        }

    fun toolbarSignUpAddress() {
        binding.apply {
            toolbar.toolbar.title = "Address"
            toolbar.toolbar.subtitle = "Make sure it's valid"
            toolbar.toolbar.navigationIcon =
                resources.getDrawable(R.drawable.ic_arrow_back_000, null)
            toolbar.toolbar.setNavigationOnClickListener { onBackPressed() }

        }
       }

    fun toolbarSignUpSuccess() {
       binding.toolbar.toolbar.visibility = View.GONE
    }
}