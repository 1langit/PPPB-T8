package com.example.pppb_t8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pppb_t8.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private var bundle = Bundle()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        with(binding) {
            val mainActivity = requireActivity() as MainActivity

            registerBtn.setOnClickListener {
                val username = inputUsername.text.toString()
                val email = inputEmail.text.toString()
                val phone = inputPhone.text.toString()
                val password = inputPassword.text.toString()

                if (username == "" || email == "" || phone == "" || password == "") {
                    Toast.makeText(requireContext(), "Input cannot be blank", Toast.LENGTH_SHORT) .show()
                } else if (!termsCheck.isChecked) {
                    Toast.makeText(requireContext(), "Please agree to terms and conditions", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(requireContext(), "Register success", Toast.LENGTH_SHORT).show()
                    inputUsername.text.clear()
                    inputEmail.text.clear()
                    inputPhone.text.clear()
                    inputPassword.text.clear()
                    termsCheck.isChecked = false

                    val adapter = (requireActivity() as MainActivity).viewPager2.adapter as FragmentStateAdapter
                    val loginFragment = adapter.createFragment(1) as LoginFragment

                    bundle.putString("username", username)
                    bundle.putString("password", password)
                    loginFragment.arguments = bundle
                    mainActivity.navigateToLogin()
                }
            }

            loginTxt.setOnClickListener {
                mainActivity.navigateToLogin()
            }
        }
        return binding.root
    }

    fun resetBundle() {
        bundle.putString("username", null)
        bundle.putString("password", null)
    }
}