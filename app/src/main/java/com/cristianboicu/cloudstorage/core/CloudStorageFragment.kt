package com.cristianboicu.cloudstorage.core

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

abstract class CloudStorageFragment : Fragment() {

    abstract val viewModel: CloudStorageViewModel

    private val fragmentScope = CoroutineScope(Dispatchers.Main + Job())
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
    }

    private fun setUpObservers() {
        fragmentScope.launch {
            viewModel.navigationFlow.collect { destination ->
                navigateTo(destination)
            }
        }

        fragmentScope.launch {
            viewModel.toastMessage.collect { message ->
                showToastMessage(message)
            }
        }
    }

    fun navigateTo(destination: Int) {
        findNavController().navigate(destination)
    }

    private fun showToastMessage(message: Int) {
        Toast.makeText(context, context?.getString(message), Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentScope.cancel()
    }
}