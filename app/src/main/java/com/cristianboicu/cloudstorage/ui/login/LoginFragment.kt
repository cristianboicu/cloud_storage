package com.cristianboicu.cloudstorage.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.cristianboicu.cloudstorage.R
import com.cristianboicu.cloudstorage.core.CloudStorageFragment
import com.cristianboicu.cloudstorage.core.CloudStorageViewModel
import com.cristianboicu.cloudstorage.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : CloudStorageFragment() {
    override val viewModel: LoginViewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.loginCompose.setContent {
            LoginScreen(onLogin = { username, password ->
                viewModel.login(emailOrUsername = username, password = password)
            }, onRegister = {
                navigateTo(R.id.action_loginFragment_to_registerFragment)
            })
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}