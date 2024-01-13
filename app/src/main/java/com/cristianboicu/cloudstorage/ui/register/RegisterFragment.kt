package com.cristianboicu.cloudstorage.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.cristianboicu.cloudstorage.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private val viewModel: RegisterViewModel by viewModels<RegisterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = FragmentRegisterBinding.inflate(inflater, container, false)

        binding.registerCompose.setContent {
            RegisterScreen(onBackClick = {
                activity?.supportFragmentManager?.popBackStack()
            }, onRegister = { username, email, password ->
                viewModel.register(username, email, password)
            })
        }
        return binding.root
    }
}