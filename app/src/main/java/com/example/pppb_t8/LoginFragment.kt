package com.example.pppb_t8

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pppb_t8.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        with(binding) {
            val mainActivity = requireActivity() as MainActivity

            loginBtn.setOnClickListener {
                var resUsername = arguments?.getString("username")
                var resPassword = arguments?.getString("password")
                val username = inputUsername.text.toString()
                val password = inputPassword.text.toString()

                if (username == resUsername && password == resPassword) {
                    if (!rememberCheck.isChecked) {
                        inputUsername.text.clear()
                        inputPassword.text.clear()
                        val adapter = (requireActivity() as MainActivity).viewPager2.adapter as FragmentStateAdapter
                        val registerFragment = adapter.createFragment(0) as RegisterFragment
                        registerFragment.resetBundle()
                    }

                    Toast.makeText(requireContext(), "Login success", Toast.LENGTH_SHORT).show()
                    val intentToDashboardActivity = Intent(requireContext(), DashboardActivity::class.java)
                    startActivity(intentToDashboardActivity)
                } else {
                    Toast.makeText(requireContext(), "Username or password wrong", Toast.LENGTH_SHORT).show()
                }
            }

            registerTxt.setOnClickListener {
                mainActivity.navigateToRegister()
            }
        }
        return binding.root
    }
}